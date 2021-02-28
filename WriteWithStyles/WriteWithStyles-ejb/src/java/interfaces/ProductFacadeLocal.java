/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Product;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author elau
 */
@Local
public interface ProductFacadeLocal {

    Product find(int id);
    
    boolean addProduct(Product product);
    
    boolean updateProductDetails(Product product);
    
    boolean removeProduct(int id);
    
    List<Product> getAllProducts();
}
