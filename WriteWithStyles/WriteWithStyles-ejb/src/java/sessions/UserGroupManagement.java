/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.AppUser;
import entities.RealmGroup;
import entities.UserGroup;
import entities.UserGroupPK;
import interfaces.UserGroupFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 101042618
 */
@Stateless
public class UserGroupManagement {

    @EJB
    private UserGroupFacadeLocal userGroupFacade;

    private UserGroup getUserGroupEntityFromUserAndGroup(AppUser user, RealmGroup group) {
        if (user == null || group == null) {
            return null;
        }

        UserGroupPK userGroupPK = new UserGroupPK(user.getUserid(), group.getGroupid());
        return new UserGroup(userGroupPK, user, group);
    }

    public boolean addUserGroup(AppUser user, RealmGroup group) {
        if (user == null || group == null) {
            return false;
        }

        UserGroup userGroup = getUserGroupEntityFromUserAndGroup(user, group);
        userGroupFacade.addRecord(userGroup);
        return true;
    }
}
