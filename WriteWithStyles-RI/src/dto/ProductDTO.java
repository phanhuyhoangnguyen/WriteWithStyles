/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import enumclass.ProductCategoryType;
import java.io.Serializable;
/**
 *
 * @author 101042618
 */
public class ProductDTO implements Serializable {

    private final int id;
    private final String name;
    private final String brand;
    private final String description;
    private final Float price;
    private final String colour;
    private final String image;
    private final int stockQuantity;
    private final String dateAdded;
    private final int soldQuantity;
    private final ProductCategoryType productCategoryType;

    public ProductDTO(int id, String name, String brand, String description, Float price, String colour, String image, int stockQuantity, String dateAdded, int soldQuantity, int productCategoryType) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.colour = colour;
        this.image = image;
        this.stockQuantity = stockQuantity;
        this.dateAdded = dateAdded;
        this.soldQuantity = soldQuantity;
        this.productCategoryType = ProductCategoryType.valueOf(productCategoryType);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }

    public String getImage() {
        return image;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public ProductCategoryType getProductCategoryType() {
        return productCategoryType;
    }

    public String getDisplayName(){
        return getBrand() + " - " + getName();
    }    
}
