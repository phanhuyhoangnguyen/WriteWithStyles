package managedbeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "userLoginManagedBean")
@SessionScoped
public class UserLoginManagedBean implements Serializable {

    public UserLoginManagedBean() {
    }

    public String logout() {
        // terminate the session by invalidating the session context
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();

        try {
            request.logout();
        } catch (ServletException ex) {
            System.out.println(ex.toString());
        }

        // terminate the session by invalidating the session context
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();

        return "index?faces-redirect=true";
    }
}
