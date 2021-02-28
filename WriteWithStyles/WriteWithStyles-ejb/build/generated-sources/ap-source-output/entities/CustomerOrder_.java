package entities;

import entities.CustomerOrderProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T12:12:29")
@StaticMetamodel(CustomerOrder.class)
public class CustomerOrder_ { 

    public static volatile SingularAttribute<CustomerOrder, String> firstname;
    public static volatile SingularAttribute<CustomerOrder, String> creditcardno;
    public static volatile SingularAttribute<CustomerOrder, Integer> orderid;
    public static volatile SingularAttribute<CustomerOrder, String> mobile;
    public static volatile SingularAttribute<CustomerOrder, String> postcode;
    public static volatile SingularAttribute<CustomerOrder, String> suburb;
    public static volatile SingularAttribute<CustomerOrder, String> state;
    public static volatile SingularAttribute<CustomerOrder, String> deliveryaddress;
    public static volatile CollectionAttribute<CustomerOrder, CustomerOrderProduct> customerOrderProductCollection;
    public static volatile SingularAttribute<CustomerOrder, Integer> userid;
    public static volatile SingularAttribute<CustomerOrder, String> email;
    public static volatile SingularAttribute<CustomerOrder, String> lastname;

}