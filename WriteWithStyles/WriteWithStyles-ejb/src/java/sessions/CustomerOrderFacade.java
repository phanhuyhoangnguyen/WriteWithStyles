package sessions;

import entities.CustomerOrder;
import interfaces.CustomerOrderFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 101042618
 */
@Stateless
public class CustomerOrderFacade implements CustomerOrderFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public CustomerOrderFacade() {
    }

    private void create(CustomerOrder entity) {
        em.persist(entity);
    }

    private void flush() {
        em.flush();
    }
    
    @Override
    public void addRecord(CustomerOrder customerOrder) {
        create(customerOrder);
        flush();
    }
}
