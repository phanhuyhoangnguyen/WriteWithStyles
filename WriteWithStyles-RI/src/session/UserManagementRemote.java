/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.AppUserDTO;
import javax.ejb.Remote;

/**
 *
 * @author 101042618
 */
@Remote
public interface UserManagementRemote {

    public AppUserDTO findUserByEmail(String email);
            
    public String registerNewUser(AppUserDTO customerMemberDTO);

    public boolean isEmailRegistered(String email);
}
