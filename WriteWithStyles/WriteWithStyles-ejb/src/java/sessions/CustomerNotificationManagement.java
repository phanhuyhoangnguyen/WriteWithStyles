package sessions;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 101042618
 */
@Stateless
public class CustomerNotificationManagement {

    @Resource(name = "mail/WriteWithStylesJavaMailSession")
    private Session mailSession;

    public enum ServiceType {
        PurchaseProducts,
        CreateNewMemberAccount
    }

    public boolean sendEmail(String customer, String targetEmail, ServiceType serviceType) {
        try {
            String emailSubject = "";
            String emailBody = "";
            switch (serviceType) {
                case PurchaseProducts:
                    emailSubject = "Your shopping order has been placed!";
                    emailBody += "Hi " + customer + "," + System.lineSeparator()
                            + "Thank you for shopping with us!" + System.lineSeparator()
                            + "We'll let you know when your order ships.";
                    break;

                case CreateNewMemberAccount:
                    emailSubject = "Welcome To Write With Styles!";
                    emailBody += "Hi " + customer + "," + System.lineSeparator()
                            + System.lineSeparator()
                            + "Thank you for joining us!" + System.lineSeparator()
                            + "You're now granted to be the one of the first to hear about all awesome products, new releases and exclusive amazing deals." + System.lineSeparator();
                    break;
            }

            emailBody += System.lineSeparator()
                    + "Please sign in to the website to see more details." + System.lineSeparator()
                    + "If you have any questions, please let us know!" + System.lineSeparator()
                    + System.lineSeparator()
                    + "Sincerely," + System.lineSeparator()
                    + "WriteWithStyles";

            String to = targetEmail;

            Message msg = new MimeMessage(mailSession);
            msg.setSubject(emailSubject);
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to, ""));
            msg.setText(emailBody);
            Transport.send(msg);
            return true;
        } catch (MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(CustomerNotificationManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
