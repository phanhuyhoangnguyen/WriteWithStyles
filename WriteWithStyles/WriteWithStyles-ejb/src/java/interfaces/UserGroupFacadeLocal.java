/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.UserGroup;
import javax.ejb.Local;

/**
 *
 * @author 101042618
 */
@Local
public interface UserGroupFacadeLocal {
    
    public void addRecord(UserGroup userGroup);
}
