package com.mycompany.management_course.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDatabaseManager {

    private static Connection c;
    private static Statement s;
    private static PreparedStatement p;

    private String host, port, dbUser, dbName, dbPassword;

    public MyDatabaseManager() {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "School";
        dbPassword = "";
    }

    public void connectDB() {
        if (c == null) {
            String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
            try {

                c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
                s = c.createStatement();
                System.out.println("Connected");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Connection getConnection() {
        return c;
    }

}
