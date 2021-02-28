/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author 101042618
 */
@FacesValidator("creditCardNumberValidator")
public class CreditCardNumberValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent toValidate, Object value) 
            throws ValidatorException {
        String textValue = value.toString().replaceAll(" ", "");
        String regex = "^5[1-5][0-9]{14}$";
        if (!textValue.matches(regex)){
            String message = "Please input valid card number";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
