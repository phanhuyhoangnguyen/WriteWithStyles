/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dto.CartItemDTO;
import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import session.ShoppingCartManagementRemote;

/**
 *
 * @author 101042618
 */
@Stateful
public class ShoppingCartManagement implements ShoppingCartManagementRemote {

    private ArrayList<CartItemDTO> cart;

    public ShoppingCartManagement() {
        cart = new ArrayList<>();
    }

    @Override
    public ArrayList<CartItemDTO> getCart() {
        return cart;
    }

    @Override
    public void clearCart() {
        cart = new ArrayList<>();
    }

    private boolean add(CartItemDTO cartItem) throws Exception {
        try {
            cart.add(cartItem);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    private CartItemDTO findCartItem(int itemId) {
        return cart.stream()
                .filter(cartItm -> itemId == cartItm.getProduct().getId())
                .findFirst().orElse(null);
    }

    @Override
    public boolean addCartItem(CartItemDTO cartItem) {
        try {
            CartItemDTO existingItem = findCartItem(cartItem.getProduct().getId());

            if (existingItem == null) {
                add(cartItem);
                return true;
            }
            int currentQuatity = existingItem.getQuantityAdded();
            existingItem.setQuantityAdded(currentQuatity + cartItem.getQuantityAdded());
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean deleteCartItem(int itemId) {
        CartItemDTO matchedItem = findCartItem(itemId);
        if (matchedItem == null) {
            return false;
        }
        cart.remove(matchedItem);
        return true;
    }

    @Override
    public boolean updateCartItem(CartItemDTO cartItem) {
        CartItemDTO matchedItem = findCartItem(cartItem.getProduct().getId());
        if (matchedItem == null) {
            return false;
        }

        int indexOfExistingItem = cart.indexOf(matchedItem);
        cart.set(indexOfExistingItem, cartItem);
        return true;
    }

    @Remove
    public void remove() {
        cart = null;
    }
}
