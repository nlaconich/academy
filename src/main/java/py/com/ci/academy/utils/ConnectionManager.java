/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author nick
 */
public class ConnectionManager {

    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/db_academy", "developer", "developer");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }


        return connection;
    }

    public static void main(String[] args) throws SQLException {
        if (new ConnectionManager().getConnection() != null) {
            System.out.println("CONNECTION OK!");
        } else {
            System.out.println("ERROR CONNECTION");
        }

    }

}
