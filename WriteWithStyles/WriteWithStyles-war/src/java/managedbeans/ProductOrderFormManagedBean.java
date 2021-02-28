/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import dto.CustomerDTO;
import dto.CustomerOrderDTO;
import enumclass.FormStageType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.CreditCard;
import model.FormController;
import session.UserManagementRemote;

@Named(value = "productOrderFormManagedBean")
@ViewScoped
public class ProductOrderFormManagedBean extends FormController implements Serializable {

    private String fname;

    private String lname;

    private String email;

    private String mobile;

    private String address;

    private String suburb;

    private String postCode;

    private String state;

    private final List<String> availableStates;

    private String creditCardName;

    private String creditCardNo;

    private int creditCardExpMonth;

    private int creditCardExpYear;

    private String ccvNumber;

    @Inject
    private ShoppingCartManagedBean shoppingCartManagedBean;

    @EJB
    private UserManagementRemote userManagement;

    public ProductOrderFormManagedBean() {
        availableStates = Arrays.asList("NSW", "VIC", "QLD", "WA", "SA", "TAS", "ATC", "NT");
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        creditCardExpMonth = localDate.getMonthValue() + 1;
        creditCardExpYear = localDate.getYear();
    }

    @Override
    public void submit() {
        CreditCard creditCard = new CreditCard(creditCardName, creditCardNo, creditCardExpMonth, creditCardExpYear, Integer.valueOf(ccvNumber));

        String userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        Integer userId = null;
        if (userName != null && !userName.isEmpty()) {
            userId = userManagement.findUserByEmail(userName).getId();
        }

        CustomerDTO customer = new CustomerDTO(fname, lname, email, mobile, address, suburb, postCode, state, creditCard, userId);
        CustomerOrderDTO order = new CustomerOrderDTO(customer, shoppingCartManagedBean.getCart());
        String result = shoppingCartManagedBean.placeOrder(order);

        if (!result.equalsIgnoreCase(SUCCESS)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(formComponent.getClientId(context), new FacesMessage(FacesMessage.SEVERITY_ERROR, result, result));
            stage = FormStageType.Error;
        } else {
            stage = FormStageType.Success;
            formOutputMessageHeading = "CONGRATULATION!";
            formOutputMessageBody = "Your order has been placed successfully!";
        }
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

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public int getCreditCardExpMonth() {
        return creditCardExpMonth;
    }

    public void setCreditCardExpMonth(int creditCardExpMonth) {
        this.creditCardExpMonth = creditCardExpMonth;
    }

    public int getCreditCardExpYear() {
        return creditCardExpYear;
    }

    public void setCreditCardExpYear(int creditCardExpYear) {
        this.creditCardExpYear = creditCardExpYear;
    }

    public String getCcvNumber() {
        return ccvNumber;
    }

    public void setCcvNumber(String ccvNumber) {
        this.ccvNumber = ccvNumber;
    }
}
