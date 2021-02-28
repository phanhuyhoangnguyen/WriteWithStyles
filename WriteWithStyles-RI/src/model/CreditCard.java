package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author 101042618
 */
public class CreditCard implements Serializable {

    private final String holderName;
    private final String creditcardNo;
    private final int expiryMonth;
    private final int expiryYear;
    private final int cvvNumber;

    public CreditCard(String holderName, String creditcardNo, int expiryMonth, int expiryYear, int cvvNumber) {
        this.holderName = holderName;
        this.creditcardNo = creditcardNo;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvvNumber = cvvNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }

    public String getCreditcardNo() {
        return creditcardNo;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }
}
