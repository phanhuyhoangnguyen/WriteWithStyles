/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import dto.ProductDTO;
import enumclass.FormStageType;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.FormController;
import session.ProductManagementRemote;

/**
 *
 * @author 101042618
 */
@Named(value = "viewProductManagedBean")
@ViewScoped
public class ViewProductManagedBean extends FormController implements Serializable {

    private Integer productId;
    private ProductDTO product;

    private int orderedQuantity;

    @EJB
    private ProductManagementRemote productManagement;

    @Inject
    private ShoppingCartManagedBean shoppingCartManagedBean;
    
    public ViewProductManagedBean() {
    }

    public void init() {
        if (productId == null) {
            String message = "Bad request. Please use a link from within the system.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        product = productManagement.getProductDetails(productId);

        if (product.getStockQuantity() > 0) {
            orderedQuantity = 1;                    // default orderedQuantity
        }

        if (product == null) {
            String message = "Bad request. Unknown product.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    @Override
    public void submit() {
        boolean result = shoppingCartManagedBean.addToCart(product, orderedQuantity);
        if (!result) {
            String message = "Unable to add item";
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(formComponent.getClientId(context), new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
            stage = FormStageType.Error;
        } else {
            stage = FormStageType.Success;
        }
    }
}
