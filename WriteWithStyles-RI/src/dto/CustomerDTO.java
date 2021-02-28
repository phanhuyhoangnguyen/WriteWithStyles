/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import model.CreditCard;

/**
 *
 * @author 101042618
 */
public class CustomerDTO implements Serializable {

    private final String fname;

    private final String lname;

    private final String email;

    private final String mobile;

    private final String address;

    private final String suburb;

    private final String postCode;

    private final String state;

    private final CreditCard creditCard;

    private final Integer customerMemberId;

    public CustomerDTO(String fname, String lname, String email, String mobile, String address, String suburb, String postCode, String state, CreditCard creditCard, Integer customerMemberId) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.suburb = suburb;
        this.postCode = postCode;
        this.state = state;
        this.creditCard = creditCard;
        this.customerMemberId = customerMemberId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getState() {
        return state;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Integer getCustomerMemberId() {
        return customerMemberId;
    }

}
