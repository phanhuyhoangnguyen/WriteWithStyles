/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import interfaces.ProductFacadeLocal;
import entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 101042618
 */
@Stateless
public class ProductFacade implements ProductFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public ProductFacade() {
    }

    private void create(Product entity) {
        em.persist(entity);
    }

    private void edit(Product entity) {
        em.merge(entity);
    }

    private void remove(Product entity) {
        em.remove(em.merge(entity));
    }

    @Override
    public Product find(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public boolean addProduct(Product product) {
        Product p = find(product.getProductid());
        
        if (p != null) return false;

        create(product);

        return true;
    }

    @Override
    public boolean updateProductDetails(Product product) {
        Product p = find(product.getProductid());

        if (p == null) {
            return false;
        }

        edit(product);
        return true;
    }

    @Override
    public boolean removeProduct(int productId) {
        Product targetProduct = find(productId);

        if (targetProduct == null) {
            return false;
        }

        em.remove(targetProduct);
        return true;
    }

    @Override
    public List getAllProducts() {
        return em.createQuery("Select p from Product p", Product.class).getResultList();
    }
}
