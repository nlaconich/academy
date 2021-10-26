package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import py.com.ci.academy.login.controller.LoginController;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = -2152389656664659476L;
    private String user;
    private String password;
    private boolean logged = false;
    private LoginController loginController = new LoginController();

    public boolean isLogged() {
        return logged;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        if (loginController.lookForUser(user, password)) {
            logged = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user);
        } else {
            logged = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid USER or PASSWORD");

        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("isLogged", logged);
        if (logged) {
            context.addCallbackParam("view", "home.xhtml");
        }
            return "home";
    }

    

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        logged = false;
    }
}
