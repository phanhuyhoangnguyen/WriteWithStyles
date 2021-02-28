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
@FacesValidator("emailFormatValidator")
public class EmailFormatValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        String textValue = (String) value;
        String regex = "^.+@.+\\..{2,3}$";
        if (!textValue.matches(regex)){
            String message = "Please input valid email address";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
