package entities;

import entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(ProductCategory.class)
public class ProductCategory_ { 

    public static volatile SingularAttribute<ProductCategory, Integer> productcategoryid;
    public static volatile CollectionAttribute<ProductCategory, Product> productCollection;
    public static volatile SingularAttribute<ProductCategory, String> name;

}