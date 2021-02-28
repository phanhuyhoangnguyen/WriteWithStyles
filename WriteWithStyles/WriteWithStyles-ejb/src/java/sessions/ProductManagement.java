/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import interfaces.ProductFacadeLocal;
import dto.ProductDTO;
import entities.Product;
import enumclass.ProductCategoryType;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import session.ProductManagementRemote;

/**
 *
 * @author 101042618
 */
@Stateless
public class ProductManagement implements ProductManagementRemote {

    @EJB
    private ProductFacadeLocal productFacade;

    private ProductDTO productEntity2DTO(Product product) {
        if (product == null) {
            return null;
        }
        int productId = product.getProductid();

        ProductDTO productDTO = new ProductDTO(
                productId,
                product.getName(),
                product.getBrand(),
                product.getDescription(),
                product.getPrice(),
                product.getColour(),
                getImageSourceDirectory(product.getImage()),
                product.getInventory().getStockquantity(),
                product.getInventory().getDateadded().toString(),
                product.getSoldquantity(),
                product.getProductcategoryid().getProductcategoryid()
        );

        return productDTO;
    }

    @Override
    public ProductDTO getProductDetails(int productId) {
        Product product = productFacade.find(productId);
        return product != null ? productEntity2DTO(product) : null;
    }

    @Override
    public boolean removeProduct(int productId) {
        return productFacade.removeProduct(productId);
    }

    @Override
    public List<ProductDTO> findProductsByNameOrBrand(String searchParam) {

        Comparator<Product> groupByComparator = Comparator.comparing(Product::getName)
                .thenComparing(Product::getBrand);

        List<Product> results = productFacade.getAllProducts()
                .stream()
                .filter(e -> e.getName().toLowerCase().contains(searchParam.toLowerCase())
                || e.getBrand().toLowerCase().contains(searchParam.toLowerCase()))
                .sorted(groupByComparator)
                .collect(Collectors.toList());

        return results.stream()
                .map(obj -> productEntity2DTO((Product) obj))
                .collect(Collectors.toList());
    }

    private String getImageSourceDirectory(String imageName) {
        return "images/" + imageName;
    }

    @Override
    public List<ProductDTO> getNewArrivalProducts() {
        final int limit = 30;
        List<Product> allProducts = productFacade.getAllProducts();

        return allProducts.stream()
                .sorted(Comparator.comparing(product -> ((Product) product).getInventory().getDateadded()).reversed())
                .map(obj -> productEntity2DTO((Product) obj))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategory(ProductCategoryType category) {
        List<Product> results = productFacade.getAllProducts()
                .stream()
                .filter(e -> e.getProductcategoryid().getProductcategoryid() == category.getValue())
                .collect(Collectors.toList());

        return results.stream()
                .map(obj -> productEntity2DTO((Product) obj))
                .collect(Collectors.toList());
    }
}
