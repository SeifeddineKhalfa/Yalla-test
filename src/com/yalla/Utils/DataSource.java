/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Utils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Datatbase connection Singleton
 * @author SEIF
 */
public class DataSource {
    private Connection connection;
    static String url = "jdbc:mysql://localhost:3306/yalla";
    static String login = "root";
    static String pwd = "";
    private static  DataSource data;
    
    
    private DataSource()
    {
    
        try {
            connection=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static DataSource getInstance()
    {
    if(data==null)
       data= new DataSource();
    return data;
    }
    public Connection getConnection() {
        return connection;
    }
    
    
    
}
