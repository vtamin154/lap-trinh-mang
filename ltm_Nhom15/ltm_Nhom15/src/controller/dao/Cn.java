/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin 88
 */
public class Cn {

    public static java.sql.Connection con;
    private String dbUrl = "jdbc:mysql://localhost:3306/contactdb?autoReconnect=true&useSSL=false";
    private String dbClass = "com.mysql.jdbc.Driver";

    public Cn() {
        con = getConnection();
    }

    protected java.sql.Connection getConnection() {
//        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, "root", "2512hieuA");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated catch block
        return con;
    }

}
