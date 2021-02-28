/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.AppUser;
import entities.RealmGroup;
import interfaces.RealmGroupFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 101042618
 */
@Stateless
public class RealmGroupFacade implements RealmGroupFacadeLocal {

    @PersistenceContext(unitName = "WriteWithStyles-ejbPU")
    private EntityManager em;

    public RealmGroupFacade() {
    }

    @Override
    public RealmGroup findGroup(int id) {
        return em.find(RealmGroup.class, id);
    }

    @Override
    public RealmGroup findGroupByGroupName(String groupname) {
        Query queryGroupByName = em.createNamedQuery("RealmGroup.findByGroupname");
        queryGroupByName.setParameter("groupname", groupname);
        return (RealmGroup) queryGroupByName.getResultList().get(0);
    }
}
