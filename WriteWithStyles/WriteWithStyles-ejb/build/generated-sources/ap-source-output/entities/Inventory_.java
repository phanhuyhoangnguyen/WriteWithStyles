package entities;

import entities.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(Inventory.class)
public class Inventory_ { 

    public static volatile SingularAttribute<Inventory, Product> productid;
    public static volatile SingularAttribute<Inventory, Integer> inventoryid;
    public static volatile SingularAttribute<Inventory, Integer> stockquantity;
    public static volatile SingularAttribute<Inventory, Date> dateadded;

}