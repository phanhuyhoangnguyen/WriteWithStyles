/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import com.google.gson.Gson;
import dto.ProductDTO;
import enumclass.ProductCategoryType;
import javax.ejb.EJB;
import session.ProductManagementRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "dynamicProductsDisplayForPageManagedBean")
@ViewScoped
public class DynamicProductsDisplayForPageManagedBean implements Serializable {

    private String pageName;
    private String pageBanner;

    private final String NEWARRIVALS = "New Arrivals";
    private final String FOUNTAINPENS = "Fountain Pens";
    private final String INDEX = "Index";
    private final String BALLPOINTPENS = "Ballpoint Pens";
    private final String SEARCHRESULTS = "Search Results";
    private final String VIEWPRODUCT = "View Product";

    @EJB
    private ProductManagementRemote productManagement;

    @Inject
    private SearchProductsManagedBean searchProductsManagedBean;

    @Inject
    private ViewProductManagedBean viewProductManagedBean;

    private List<ProductDTO> availableProducts;
    private List<ProductDTO> availableProductsUnderFilter;
    private final List<String> availableSortingOptions;
    private final String SORTING_OPTION_MOST_POPULAR = "Most Popular";
    private final String SORTING_OPTION_NEWEST = "Newest";
    private final String SORTING_OPTION_PRODUCT_NAME = "Product Name";
    private final String SORTING_OPTION_PRICE_ASC = "Price: Low To High";
    private final String SORTING_OPTION_PRICE_DESC = "Price: High To Low";

    private String selectedSortingOption;

    private double minPrice;
    private double maxPrice;

    private List<String> availableBrands;
    private Map<String, Boolean> selectedBrandsForFilters;

    private List<String> availableColours;
    private Map<String, Boolean> selectedColoursForFilters;

    private List<ProductDTO> availableProductsUnderFilterAndCurrentPaginationPage;
    private final int productsPerPaginationPage = 12;
    private int currentPaginationPageIndex;
    private int paginationPagesCount;

    public DynamicProductsDisplayForPageManagedBean() {
        pageName = "";
        pageBanner = "";

        availableSortingOptions = Arrays.asList(
                SORTING_OPTION_MOST_POPULAR,
                SORTING_OPTION_NEWEST,
                SORTING_OPTION_PRODUCT_NAME,
                SORTING_OPTION_PRICE_ASC,
                SORTING_OPTION_PRICE_DESC);

        availableProducts = new ArrayList();
        selectedBrandsForFilters = new HashMap<>();

        availableColours = new ArrayList();
        selectedColoursForFilters = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        final FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            pageName = (String) context.getViewRoot().getAttributes().get("pageName");

            if (pageName == null) {
                String message = "Bad request. Please use a link from within the system.";
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
                return;
            }

            switch (pageName) {
                case FOUNTAINPENS:
                    availableProducts = productManagement.getProductsByCategory(ProductCategoryType.FountainPen);
                    pageBanner = "fountain_pens_banner.jpg";
                    break;

                case BALLPOINTPENS:
                    availableProducts = productManagement
                            .getProductsByCategory(ProductCategoryType.BallpointPen);
                    pageBanner = "ballpoint_pens_banner.jpg";
                    break;

                case NEWARRIVALS:
                    availableProducts = productManagement.getNewArrivalProducts();
                    pageBanner = "new_arrivals_banner.jpg";
                    break;

                case INDEX:
                    availableProducts = productManagement.getNewArrivalProducts();
                    break;

                case SEARCHRESULTS:
                    if (searchProductsManagedBean != null) {
                        availableProducts = searchProductsManagedBean
                                .getTargetSearchedProductMatches();
                    }
                    break;

                case VIEWPRODUCT:
                    if (viewProductManagedBean != null) {
                        ProductDTO currentViewingProduct = viewProductManagedBean.getProduct();
                        availableProducts = productManagement
                                .getProductsByCategory(currentViewingProduct.getProductCategoryType())
                                .stream()
                                .filter(product -> product.getId() != currentViewingProduct.getId())
                                .collect(Collectors.toList());
                        break;
                    }
            }

            availableBrands = availableProducts.stream()
                    .map(ProductDTO::getBrand).distinct()
                    .collect(Collectors.toList());
            
            availableColours = availableProducts.stream()
                    .map(ProductDTO::getColour).distinct()
                    .collect(Collectors.toList());
            
            availableProducts.sort((p1, p2) -> p2.getSoldQuantity() - p1.getSoldQuantity()); // default sorting 
            
            clearFilters();
        }
    }

    public void sortProduct(AjaxBehaviorEvent event) {
        switch (selectedSortingOption) {
            case SORTING_OPTION_MOST_POPULAR:
                availableProducts.sort((p1, p2) -> p2.getSoldQuantity() - p1.getSoldQuantity());
                break;
            case SORTING_OPTION_NEWEST:
                availableProducts.sort((p1, p2) -> p1.getDateAdded().compareTo(p2.getDateAdded()));
                break;
            case SORTING_OPTION_PRODUCT_NAME:
                availableProducts.sort((p1, p2) -> p1.getDisplayName().compareTo(p2.getDisplayName()));
                break;
            case SORTING_OPTION_PRICE_ASC:
                availableProducts.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
                break;
            case SORTING_OPTION_PRICE_DESC:
                availableProducts = availableProducts.stream()
                        .sorted(Comparator.comparing(ProductDTO::getPrice).reversed())
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("no match");
        }

        // re-filter and re-paginate the product list according to its new product ordering
        filterProducts();
    }

    public void filterProducts() {
        availableProductsUnderFilter = availableProducts.stream()
                .filter(p -> p.getPrice() > minPrice && p.getPrice() < maxPrice)
                .collect(Collectors.toList());

        Boolean showAllBrands = selectedBrandsForFilters.values().stream().allMatch(i -> i == false);

        availableProductsUnderFilter = availableProductsUnderFilter.stream()
                .filter(p -> selectedBrandsForFilters.get(p.getBrand()) || showAllBrands)
                .collect(Collectors.toList());

        Boolean showAllColour = selectedColoursForFilters.values().stream().allMatch(i -> i == false);

        availableProductsUnderFilter = availableProductsUnderFilter.stream()
                .filter(p -> selectedColoursForFilters.get(p.getColour()) || showAllColour)
                .collect(Collectors.toList());

        availableProductsUnderFilterAndCurrentPaginationPage = productsDisplayForCurrentPaginationPage();
    }

    public void clearFilters() {
        availableProductsUnderFilter = availableProducts;
        minPrice = 0.0;
        maxPrice = 1000.0;                          // TODO: remove this

        availableBrands.forEach((brand) -> {
            selectedBrandsForFilters.put(brand, Boolean.FALSE);
        });

        availableColours.forEach((colour) -> {
            selectedColoursForFilters.put(colour, Boolean.FALSE);
        });

        paginationPagesCount = calculatePaginationPagesCount();
        currentPaginationPageIndex = 1;

        availableProductsUnderFilterAndCurrentPaginationPage = productsDisplayForCurrentPaginationPage();
    }

    public void prevPaginationPage() {
        if (currentPaginationPageIndex > 0) {
            currentPaginationPageIndex--;
            availableProductsUnderFilterAndCurrentPaginationPage = productsDisplayForCurrentPaginationPage();
        }
    }

    public void navigtateToPaginationPage(int targetIndex) {
        currentPaginationPageIndex = targetIndex;
        availableProductsUnderFilterAndCurrentPaginationPage = productsDisplayForCurrentPaginationPage();
    }

    public void nextPaginationPage() {
        if (currentPaginationPageIndex < paginationPagesCount) {
            currentPaginationPageIndex++;
            availableProductsUnderFilterAndCurrentPaginationPage = productsDisplayForCurrentPaginationPage();
        }
    }

    public int calculatePaginationPagesCount() {
        if (!availableProductsUnderFilter.isEmpty()) {
            return (int) (Math.ceil(availableProductsUnderFilter.size() / productsPerPaginationPage) + 1);
        } else {
            return 0;
        }
    }

    public List<ProductDTO> productsDisplayForCurrentPaginationPage() {
        List<ProductDTO> currentAvailableProductsDisplayed = availableProductsUnderFilter;
        if (currentAvailableProductsDisplayed.size() > productsPerPaginationPage) {
            int offset = (currentPaginationPageIndex - 1) * productsPerPaginationPage;
            currentAvailableProductsDisplayed = currentAvailableProductsDisplayed.stream()
                    .skip(offset)
                    .limit(productsPerPaginationPage)
                    .collect(Collectors.toList());
        }

        return currentAvailableProductsDisplayed;
    }

    //page range according to current page: calculate each time page load
    public List<Integer> calculatePaginationPageRange() {
        List<Integer> pageIndexesAvailable = new ArrayList();
        int rangePageIndexSize;

        rangePageIndexSize = paginationPagesCount >= 3 ? 3 : paginationPagesCount;

        int startIndex = currentPaginationPageIndex;

        if (startIndex >= (paginationPagesCount - rangePageIndexSize)) {
            startIndex = paginationPagesCount - rangePageIndexSize + 1;
        }
        // -1 to sync with index array of products
        for (int i = startIndex; i <= rangePageIndexSize; i++) {
            pageIndexesAvailable.add(i);
        }
        return pageIndexesAvailable;
    }

    public List<ProductDTO> getProductsByCollectionSize(java.lang.Long size, boolean getRandom) {
        List<ProductDTO> results = availableProducts;

        if (getRandom) {
            Collections.shuffle(results);
        }
        return results.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public String getSelectedSortingOption() {
        return selectedSortingOption;
    }

    public void setSelectedSortingOption(String selectedSort) {
        this.selectedSortingOption = selectedSort;
    }

    public List<ProductDTO> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<ProductDTO> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public List<ProductDTO> getAvailableProductsUnderFilter() {
        return availableProductsUnderFilter;
    }

    public void setAvailableProductsUnderFilter(List<ProductDTO> availableProductsUnderFilter) {
        this.availableProductsUnderFilter = availableProductsUnderFilter;
    }

    public List<String> getAvailableSortingOptions() {
        return availableSortingOptions;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<String> getAvailableBrands() {
        return availableBrands;
    }

    public void setAvailableBrands(List<String> availableBrands) {
        this.availableBrands = availableBrands;
    }

    public Map<String, Boolean> getSelectedBrandsForFilters() {
        return selectedBrandsForFilters;
    }

    public void setSelectedBrandsForFilters(Map<String, Boolean> selectedBrandsForFilters) {
        this.selectedBrandsForFilters = selectedBrandsForFilters;
    }

    public List<String> getAvailableColours() {
        return availableColours;
    }

    public void setAvailableColours(List<String> availableColours) {
        this.availableColours = availableColours;
    }

    public Map<String, Boolean> getSelectedColoursForFilters() {
        return selectedColoursForFilters;
    }

    public void setSelectedColoursForFilters(Map<String, Boolean> selectedColoursForFilters) {
        this.selectedColoursForFilters = selectedColoursForFilters;
    }

    public int getCurrentPaginationPageIndex() {
        return currentPaginationPageIndex;
    }

    public void setCurrentPaginationPageIndex(int currentPaginationPageIndex) {
        this.currentPaginationPageIndex = currentPaginationPageIndex;
    }

    public int getPaginationPagesCount() {
        return paginationPagesCount;
    }

    public void setPaginationPagesCount(int paginationPagesCount) {
        this.paginationPagesCount = paginationPagesCount;
    }

    public List<ProductDTO> getAvailableProductsUnderFilterAndCurrentPaginationPage() {
        return availableProductsUnderFilterAndCurrentPaginationPage;
    }

    public void setAvailableProductsUnderFilterAndCurrentPaginationPage(List<ProductDTO> availableProductsUnderFilterAndCurrentPaginationPage) {
        this.availableProductsUnderFilterAndCurrentPaginationPage = availableProductsUnderFilterAndCurrentPaginationPage;
    }

    public int getProductsPerPaginationPage() {
        return productsPerPaginationPage;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageBanner() {
        return pageBanner;
    }

    public String getProductsAsJson() {
        return new Gson().toJson(getAvailableProducts());
    }
}
