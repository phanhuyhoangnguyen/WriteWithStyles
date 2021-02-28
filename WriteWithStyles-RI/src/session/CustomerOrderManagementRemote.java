/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CustomerOrderDTO;
import javax.ejb.Remote;

/**
 *
 * @author 101042618
 */
@Remote
public interface CustomerOrderManagementRemote {
    public String addOrder(CustomerOrderDTO customerOrderDTO);
}
