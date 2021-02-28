/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.CustomerOrderProduct;
import entities.UserGroup;
import interfaces.UserGroupFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 101042618
 */
@Stateless
public class UserGroupFacade implements UserGroupFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public UserGroupFacade() {
    }

    private void create(UserGroup entity) {
        em.persist(entity);
    }

    @Override
    public void addRecord(UserGroup userGroup) {
        create(userGroup);
    }
}
