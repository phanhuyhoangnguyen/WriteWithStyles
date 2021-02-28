/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.AppUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import interfaces.UserFacadeLocal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author 101042618
 */
@Stateless
public class UserFacade implements UserFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public UserFacade() {
    }

    private void create(AppUser entity) {
        em.persist(entity);
    }
    
    @Override
    public AppUser findUserRecordByUserId(int id) {
        return em.find(AppUser.class, id);
    }
    
    @Override
    public void addRecord(AppUser customerMember) {
        create(customerMember);
    }

    @Override
    public AppUser findUserRecordByEmail(String email) {
        Query queryGroupByName = em.createNamedQuery("AppUser.findByEmail");
        queryGroupByName.setParameter("email", email);
        
        List<AppUser> matchedUsers = queryGroupByName.getResultList();
        
        return (!matchedUsers.isEmpty()) ? (AppUser) matchedUsers.get(0) : null;
    }

    @Override
    public boolean isEmailRegistered(String email) {
        return findUserRecordByEmail(email) != null;
    }
}
