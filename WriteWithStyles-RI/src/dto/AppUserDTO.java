/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author 101042618
 */
public class AppUserDTO implements Serializable {

    private Integer id;

    private String fname;

    private String lname;

    private String email;

    private String password;

    private String mobile;

    private String address;

    private String suburb;

    private String postCode;

    private String state;

    public AppUserDTO(String fname, String lname, String email, String password, String mobile, String address, String suburb, String postCode, String state) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.suburb = suburb;
        this.postCode = postCode;
        this.state = state;
    }

    public AppUserDTO(Integer userId, String fname, String lname, String email, String password, String mobile, String address, String suburb, String postCode, String state) {
        this(fname, lname, email, password, mobile, address, suburb, postCode, state);
        this.id = userId;
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

    public String getPassword() {
        return password;
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

    public int getId() {
        return id;
    }

}
