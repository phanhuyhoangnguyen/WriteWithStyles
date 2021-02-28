/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 101042618
 */
public class Product implements Serializable {

    private final int Id;
    private final String Name;
    private final String Brand;
    private final String Description;
    private final Double Price;
    private final String Colour;
    private final String Image;
    private final int Quantity;
    private final Date DateAdded;
    private final int SoldQuantity;
    private final int ProductCategoryId;

    public Product(int Id, String Name, String Brand, String Description, Double Price, String Colour, String Image, int Quantity, String DateAdded, int SoldQuantity, int ProductCategoryId) throws ParseException {
        this.Id = Id;
        this.Name = Name;
        this.Brand = Brand;
        this.Description = Description;
        this.Price = Price;
        this.Colour = Colour;
        this.Image = Image;
        this.Quantity = Quantity;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.DateAdded = sdf.parse(DateAdded);
        this.SoldQuantity = SoldQuantity;
        this.ProductCategoryId = ProductCategoryId;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getBrand() {
        return Brand;
    }

    public String getDescription() {
        return Description;
    }

    public Double getPrice() {
        return Price;
    }

    public String getColour() {
        return Colour;
    }

    public String getImage() {
        return Image;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Date getDateAdded() {
        return DateAdded;
    }

    public int getSoldQuantity() {
        return SoldQuantity;
    }

    public int getProductCategoryId() {
        return ProductCategoryId;
    }

}
