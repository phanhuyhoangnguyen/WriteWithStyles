package managedbeans;

import dto.CartItemDTO;
import dto.CustomerOrderDTO;
import dto.ProductDTO;
import javax.ejb.EJB;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import session.CustomerOrderManagementRemote;
import session.ShoppingCartManagementRemote;

@Named(value = "shoppingCartManagedBean")
@SessionScoped
public class ShoppingCartManagedBean implements Serializable {

    @EJB
    private ShoppingCartManagementRemote shoppingCartManagement;

    @EJB
    private CustomerOrderManagementRemote customerOrderManagementRemote;
    
    public ShoppingCartManagedBean() {
    }

    public boolean addToCart(ProductDTO product, int addedQuantity) {
        return shoppingCartManagement.addCartItem(new CartItemDTO(product, addedQuantity));
    }
    
    public void updateItem(CartItemDTO item) {
        shoppingCartManagement.updateCartItem(item);
    }

    public ArrayList<CartItemDTO> getCart() {
        return shoppingCartManagement.getCart();
    }

    public void removeItemFromCart(CartItemDTO item) {
        shoppingCartManagement.deleteCartItem(item.getProduct().getId());
    }

    public String totalPriceInCart() {
        return "AUD$" + String.format("%.2f", getCart()
                .stream()
                .mapToDouble(item -> item.getQuantityAdded() * item.getProduct().getPrice())
                .sum());
    }

    public void clearCart() {
        shoppingCartManagement.clearCart();
    }
    
    public String placeOrder(CustomerOrderDTO order){
        String result = customerOrderManagementRemote.addOrder(order);
        clearCart();
        return result;
    }
}
