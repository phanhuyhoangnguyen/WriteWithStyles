package sessions;

import entities.CustomerOrder;
import entities.CustomerOrderProduct;
import entities.CustomerOrderProductPK;
import entities.Product;
import interfaces.CustomerOrderProductFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 101042618
 */
@Stateless
public class CustomerOrderProductManagement {

    @EJB
    private CustomerOrderProductFacadeLocal customerOrderProductFacade;

    private CustomerOrderProduct getCustomerProductEntityFromCustomerOrderAndProduct(CustomerOrder customerOrder, Product product, int orderedQuantity) {
        if (customerOrder == null || product == null) {
            return null;
        }

        CustomerOrderProductPK customerOrderProductPK = new CustomerOrderProductPK(customerOrder.getOrderid(), product.getProductid());
        return new CustomerOrderProduct(customerOrderProductPK, orderedQuantity, product.getPrice(), customerOrder, product);
    }

    public boolean addOrderProduct(CustomerOrder customerOrder, Product product, int orderedQuantity) {
        if (customerOrder == null || product == null) {
            return false;
        }
        
        CustomerOrderProduct customerOrderProduct = getCustomerProductEntityFromCustomerOrderAndProduct(customerOrder, product, orderedQuantity);
        customerOrderProductFacade.addRecord(customerOrderProduct);
        return true;
    }
}
