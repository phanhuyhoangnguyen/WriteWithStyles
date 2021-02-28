package validator;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author 101042618
 */
@FacesValidator("creditCardExpiryDateValidator")
public class CreditCardExpiryDateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent toValidate, Object value) 
            throws ValidatorException {
        int ccexpyear = (int) value;
        UIInput ccexpmonthComponent = (UIInput) toValidate.getAttributes().get("ccexpmonth");
        int ccexpmonth = (int) ccexpmonthComponent.getValue();

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int currentMonth = localDate.getMonthValue();
        int currentYear = localDate.getYear();
        
        if (ccexpyear < Year.now().getValue() || (ccexpyear == currentYear && ccexpmonth <= currentMonth)){
            String message = "The inputted card is expired.";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
