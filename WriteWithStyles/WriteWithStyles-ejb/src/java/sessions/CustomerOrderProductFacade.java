package sessions;

import entities.CustomerOrderProduct;
import interfaces.CustomerOrderProductFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 101042618
 */
@Stateless
public class CustomerOrderProductFacade implements CustomerOrderProductFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public CustomerOrderProductFacade() {
    }

    private void create(CustomerOrderProduct entity) {
        em.persist(entity);
    }

    @Override
    public void addRecord(CustomerOrderProduct customerOrderProduct) {
        create(customerOrderProduct);
    }
}
