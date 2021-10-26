package py.com.ci.academy.login.controller;

import py.com.ci.academy.user.user.boundary.UserManager;

/**
 *
 * @author matias
 */
public class LoginController {

    private final UserManager userManager = new UserManager();

    public boolean lookForUser(String user, String password) {

        return userManager.checkUser(user, password);

    }

}
