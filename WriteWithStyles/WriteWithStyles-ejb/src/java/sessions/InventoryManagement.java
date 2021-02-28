package sessions;

import entities.Inventory;
import interfaces.InventoryFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 101042618
 */
@Stateless
public class InventoryManagement {

    @EJB
    private InventoryFacadeLocal inventoryFacade;

    public boolean updateInventoryDetails(Inventory inventory) {
        return inventoryFacade.updateRecordDetails(inventory);
    }
}
