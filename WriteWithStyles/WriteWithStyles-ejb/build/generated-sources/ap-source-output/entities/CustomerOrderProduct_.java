package entities;

import entities.CustomerOrder;
import entities.CustomerOrderProductPK;
import entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(CustomerOrderProduct.class)
public class CustomerOrderProduct_ { 

    public static volatile SingularAttribute<CustomerOrderProduct, CustomerOrderProductPK> customerOrderProductPK;
    public static volatile SingularAttribute<CustomerOrderProduct, Product> product;
    public static volatile SingularAttribute<CustomerOrderProduct, Integer> orderedquantity;
    public static volatile SingularAttribute<CustomerOrderProduct, CustomerOrder> customerOrder;
    public static volatile SingularAttribute<CustomerOrderProduct, Float> productprice;

}