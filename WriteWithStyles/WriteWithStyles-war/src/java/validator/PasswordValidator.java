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
@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent toValidate, Object value) 
            throws ValidatorException {
        String textValue = (String) value;
        String regex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[_\\W]).{8,}$";
        if (!textValue.matches(regex)){
            String message = "Password must has at least 1 character, 1 number, 1 special character and more than 8.";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
