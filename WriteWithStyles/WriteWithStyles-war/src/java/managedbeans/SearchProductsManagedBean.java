package managedbeans;

import javax.ejb.EJB;
import java.util.List;
import java.util.ArrayList;
import session.ProductManagementRemote;
import dto.ProductDTO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "searchProductsManagedBean")
@ViewScoped
public class SearchProductsManagedBean implements Serializable {

    private String searchValue;
    private List<ProductDTO> targetSearchedProductMatches;

    @EJB
    private ProductManagementRemote productManagement;

    public SearchProductsManagedBean() {
        targetSearchedProductMatches = new ArrayList();
    }

    public void init() {
        if (searchValue == null) {
            String message = "Bad request. Please use a link from within the system.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        targetSearchedProductMatches = productManagement.findProductsByNameOrBrand(searchValue);
    }

    public String searchProduct() {
        if (searchValue != null && !searchValue.isEmpty()) {
            return "searchResults?faces-redirect=true&searchValue=" + searchValue;
        }
        
        return "index";
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<ProductDTO> getTargetSearchedProductMatches() {
        return targetSearchedProductMatches;
    }

    public void setTargetSearchedProductMatches(List<ProductDTO> targetSearchedProductMatches) {
        this.targetSearchedProductMatches = targetSearchedProductMatches;
    }
}
