/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.AppUser;
import javax.ejb.Local;

/**
 *
 * @author 101042618
 */
@Local
public interface UserFacadeLocal {

    public AppUser findUserRecordByUserId(int id);

    public void addRecord(AppUser user);
    
    public boolean isEmailRegistered(String email);
    
    public AppUser findUserRecordByEmail(String email);
}
