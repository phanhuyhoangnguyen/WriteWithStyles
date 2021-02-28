/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.ProductDTO;
import enumclass.ProductCategoryType;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 101042618
 */
@Remote
public interface ProductManagementRemote {
    
    ProductDTO getProductDetails(int id);

    boolean removeProduct(int id);

    List<ProductDTO> findProductsByNameOrBrand(String name);

    List<ProductDTO> getNewArrivalProducts();

    List<ProductDTO> getProductsByCategory(ProductCategoryType category);
}
