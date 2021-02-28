/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Inventory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 101042618
 */
@Local
public interface InventoryFacadeLocal {

    public Inventory findRecord(int inventoryId);

    public boolean addRecord(Inventory inventory);

    public boolean updateRecordDetails(Inventory inventory);

    public Inventory findRecordByProductId(int productId);

    public List getAllInventories();
}
