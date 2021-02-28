/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CartItemDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author 101042618
 */
@Remote
public interface ShoppingCartManagementRemote {

    public ArrayList<CartItemDTO> getCart();

    public boolean addCartItem(CartItemDTO cartItem);

    public boolean deleteCartItem(int itemId);

    public boolean updateCartItem(CartItemDTO cartItem);
    
    public void clearCart();
}
