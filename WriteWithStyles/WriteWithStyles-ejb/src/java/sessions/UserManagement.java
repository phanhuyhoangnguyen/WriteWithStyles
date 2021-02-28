/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dto.AppUserDTO;
import entities.AppUser;
import entities.RealmGroup;
import interfaces.RealmGroupFacadeLocal;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import interfaces.UserFacadeLocal;
import session.UserManagementRemote;
import utilities.HashHelper;

/**
 *
 * @author 101042618
 */
@Stateless
public class UserManagement implements UserManagementRemote {

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private RealmGroupFacadeLocal realmGroupFacadeLocal;

    @EJB
    private UserGroupManagement userGroupManagement;

    @EJB
    private CustomerNotificationManagement customerNotificationManagement;

    private final String SUCCESS = "SUCCESS";
    private final String ERROR = "ERROR";

    private AppUser appUserDTO2Entity(AppUserDTO userDTO)
            throws NoSuchAlgorithmException {
        if (userDTO == null) {
            return null;
        }

        String fname = userDTO.getFname();
        String lname = userDTO.getLname();
        String email = userDTO.getEmail();
        String password = HashHelper.toSHA256(userDTO.getPassword());
        String mobile = userDTO.getMobile();
        String address = userDTO.getAddress();
        String suburb = userDTO.getSuburb();
        String postCode = userDTO.getPostCode();
        String state = userDTO.getState();
        return new AppUser(fname, lname, email, password, mobile, address, suburb, postCode, state);
    }

    private AppUserDTO entity2AppUserDTO(AppUser appUser) {
        if (appUser == null) {
            return null;
        }

        Integer id = appUser.getUserid();
        String fname = appUser.getFirstname();
        String lname = appUser.getLastname();
        String email = appUser.getEmail();
        String password = appUser.getPassword();
        String mobile = appUser.getMobile();
        String address = appUser.getAddress();
        String suburb = appUser.getSuburb();
        String postCode = appUser.getPostcode();
        String state = appUser.getState();

        return new AppUserDTO(id, fname, lname, email, password, mobile, address, suburb, postCode, state);
    }

    @Override
    public String registerNewUser(AppUserDTO userDTO) {
        if (userDTO == null) {
            return "User data is empty.";
        }

        try {
            AppUser existingUser = userFacade.findUserRecordByEmail(userDTO.getEmail());

            if (existingUser != null) {
                return "Email address already exists.";
            }

            AppUser newUser = this.appUserDTO2Entity(userDTO);
            userFacade.addRecord(newUser);

            RealmGroup group = realmGroupFacadeLocal.findGroupByGroupName("WWS-USER");

            userGroupManagement.addUserGroup(newUser, group);

            customerNotificationManagement.sendEmail(userDTO.getFname(), userDTO.getEmail(), CustomerNotificationManagement.ServiceType.CreateNewMemberAccount);

            return SUCCESS;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ERROR;
    }

    @Override
    public boolean isEmailRegistered(String email) {
        return userFacade.isEmailRegistered(email);
    }

    @Override
    public AppUserDTO findUserByEmail(String email) {
        AppUser existingUser = userFacade.findUserRecordByEmail(email);
        return entity2AppUserDTO(existingUser);
    }
}
