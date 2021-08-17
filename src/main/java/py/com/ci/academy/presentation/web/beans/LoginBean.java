/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import py.com.ci.academy.user.entities.SystemUser;

/**
 *
 * @author cbustamante
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
    
    private String username;
    private String password;
    private SystemUser loggedUser;
    
    public String login(){
        System.out.println("Logged User:" + username );
        //@TODO: Loggin Process
        return "home";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(SystemUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    
}
