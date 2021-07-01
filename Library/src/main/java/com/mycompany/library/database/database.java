/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Charl3s
 */
public class database {
     public static Connection getConnection()throws Exception{
        try 
        {
            // TODO code application logic here
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //registering the driver
            System.out.println("trying to connect");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=book";
            String user = "sa";
            String pass = "123456789";
            Connection conn;
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("connection established :" + conn.getMetaData().getDatabaseProductName());
            return conn;
        }
       catch(ClassNotFoundException | SQLException e){
           System.out.println("unable to make connection");
            throw e;
        }
     }
     public static void main(String[] args) throws Exception{
         database.getConnection();
     }
}
