package interfaces;

import entities.CustomerOrder;
import javax.ejb.Local;

/**
 *
 * @author 101042618
 */
@Local
public interface CustomerOrderFacadeLocal {
    public void addRecord(CustomerOrder customerOrder);
}
