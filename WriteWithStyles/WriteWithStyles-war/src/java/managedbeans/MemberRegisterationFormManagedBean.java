/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import dto.AppUserDTO;
import enumclass.FormStageType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.FormController;
import session.UserManagementRemote;

@Named(value = "memberRegisterationFormManagedBean")
@ViewScoped
public class MemberRegisterationFormManagedBean extends FormController implements Serializable {

    private String fname;

    private String lname;

    private String email;

    private String password;

    private String confirmPassword;

    private String mobile;

    private String address;

    private String suburb;

    private String postCode;

    private String state;

    private final List<String> availableStates;

    @EJB
    private UserManagementRemote userManagement;

    public MemberRegisterationFormManagedBean() {
        availableStates = Arrays.asList("NSW", "VIC", "QLD", "WA", "SA", "TAS", "ATC", "NT");
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getAvailableStates() {
        return availableStates;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void validateIsEmailUnique(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        String textValue = (String) value;

        if (textValue == null || textValue.isEmpty()) {
            return;
        }

        boolean emailIsRegistered = userManagement.isEmailRegistered(textValue);

        if (emailIsRegistered) {
            String message = "Email address already exists.";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    @Override
    public void submit() {
        AppUserDTO newMember = new AppUserDTO(fname, lname, email, password, mobile, address, suburb, postCode, state);
        String result = userManagement.registerNewUser(newMember);

        if (!result.equalsIgnoreCase(SUCCESS)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(formComponent.getClientId(context), new FacesMessage(FacesMessage.SEVERITY_ERROR, result, result));
            stage = FormStageType.Error;
        } else {
            stage = FormStageType.Success;
            formOutputMessageHeading = "CONGRATULATION!";
            formOutputMessageBody = "Your account has been registered successfully! You can now login with your email and password.";
        }
    }
}
