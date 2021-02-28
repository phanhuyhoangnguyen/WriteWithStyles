/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author 101042618
 */
public class CartItemDTO implements Serializable {

    private ProductDTO product;
    private int quantityAdded;

    public CartItemDTO(ProductDTO product, int quantity) {
        this.product = product;
        this.quantityAdded = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(int quantityAdded) {
        this.quantityAdded = quantityAdded;
    }
    
    public String totalPrice(){
        return "AUD$" + String.format("%.2f", product.getPrice() * quantityAdded);
    }
}
