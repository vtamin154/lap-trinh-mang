/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

/**
 *
 * @author vtamin154
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    public static Connection con;
    private String dbUrl = "jdbc:mysql://localhost:3306/contactdb?autoReconnect=true&useSSL=false";
    private String dbClass = "com.mysql.jdbc.Driver";

    public Dao() {
//        if (con == null) {
//            try {
//                Class.forName(dbClass);
//                con = DriverManager.getConnection(dbUrl, "root", "131096");
//            } catch (ClassNotFoundException | SQLException e) {
//                e.printStackTrace();
//            }
//        }
        con = getConnection();
    }

    protected Connection getConnection() {
//        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, "root", "131095");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated catch block
        return con;
    }

}
