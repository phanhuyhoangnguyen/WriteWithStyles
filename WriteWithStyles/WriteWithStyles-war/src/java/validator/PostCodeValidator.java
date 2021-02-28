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
@FacesValidator("postCodeValidator")
public class PostCodeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        String textValue = (String) value;
        String regex = "^\\d{4,4}$";
        if (!textValue.matches(regex)){
            String message = "Please input valid post code.";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
