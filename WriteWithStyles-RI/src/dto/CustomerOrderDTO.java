/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 101042618
 */
public class CustomerOrderDTO implements Serializable {
    
    private final CustomerDTO customer;
    
    private final ArrayList<CartItemDTO> products;

    public CustomerOrderDTO(CustomerDTO customer, ArrayList<CartItemDTO> products) {
        this.customer = customer;
        this.products = products;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public ArrayList<CartItemDTO> getProducts() {
        return products;
    }
    
}
