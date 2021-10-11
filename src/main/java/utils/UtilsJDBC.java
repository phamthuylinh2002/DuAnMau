/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84373
 */
public class UtilsJDBC {

    public static Connection conn;

    private UtilsJDBC() {
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed() ) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=SOF2041";
                    conn = DriverManager.getConnection(url, "sa", "sa");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilsJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;

    }

}
