package sessions;

import interfaces.InventoryFacadeLocal;
import entities.Inventory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author 101042618
 */
@Stateless
public class InventoryFacade implements InventoryFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public InventoryFacade() {
    }

    private void create(Inventory entity) {
        em.persist(entity);
    }

    private void edit(Inventory entity) {
        em.merge(entity);
    }

    @Override
    public Inventory findRecord(int inventoryItemId) {
        return em.find(Inventory.class, inventoryItemId);
    }

    @Override
    public boolean addRecord(Inventory inventory) {
        Inventory inventoryItem = findRecord(inventory.getInventoryid());

        // existing record is found, stop adding
        if (inventoryItem != null) {
            return false;
        }

        create(inventoryItem);

        return true;
    }

    @Override
    public boolean updateRecordDetails(Inventory inventory) {
        Inventory inventoryItem = findRecord(inventory.getInventoryid());

        // record is not found, stop updating
        if (inventoryItem == null) {
            return false;
        }

        edit(inventory);
        return true;
    }

    @Override
    public List getAllInventories() {
        return em.createQuery("Select i from Inventory i", Inventory.class).getResultList();
    }

    @Override
    public Inventory findRecordByProductId(int productId) {
        TypedQuery<Inventory> query = em.
                createQuery("SELECT I FROM Product P, Inventory I WHERE P.inventoryCollection = I "
                        + "AND I.productid.productid = :productId", Inventory.class);
        query.setParameter("productId", productId);
        List<Inventory> resultList = query.getResultList();
        return resultList.get(0);
    }
}
