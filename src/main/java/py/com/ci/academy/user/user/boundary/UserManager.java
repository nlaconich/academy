package py.com.ci.academy.user.user.boundary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import py.com.ci.academy.user.user.entities.SystemUser;
import py.com.ci.academy.utils.ConnectionManager;

/**
 *
 * @author matias
 */
public class UserManager {

    private final String SELECT_USER = "SELECT * FROM public.users WHERE username=? AND password=?";

    public boolean checkUser(String username, String password) {
        try ( PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SELECT_USER)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
