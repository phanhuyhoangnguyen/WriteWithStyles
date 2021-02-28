package entities;

import entities.CustomerOrderProduct;
import entities.Inventory;
import entities.ProductCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, ProductCategory> productcategoryid;
    public static volatile SingularAttribute<Product, String> colour;
    public static volatile SingularAttribute<Product, Integer> productid;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> soldquantity;
    public static volatile SingularAttribute<Product, Inventory> inventory;
    public static volatile CollectionAttribute<Product, CustomerOrderProduct> customerOrderProductCollection;
    public static volatile SingularAttribute<Product, String> brand;

}