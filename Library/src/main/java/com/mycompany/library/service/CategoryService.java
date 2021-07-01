/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.service;

import com.mycompany.library.dao.Category;
import com.mycompany.library.database.database;
import com.mycompany.library.exception.DataNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charl3s
 */
public class CategoryService {

    public static List<Category> getCategory() throws Exception {
        List<Category> list = new ArrayList<>();
        String query = "select * from Categories";
        try (Connection conn = database.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Category c = new Category();
                    c.setCategoryId(rs.getString(1));
                    c.setCategoryName(rs.getString(2));
                    list.add(c);
                }
            }
        }
        return list;
    }

    public static boolean checkCategory(String Category_id) throws Exception {
        boolean st = false;
        try {
            Connection conn = database.getConnection();
            String Query = "Select  * from Categories WHERE Category_id=?";
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setString(1, Category_id);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (Exception e) {
        }
        return st;
    }

    public static Category getCateId(String Category_id) throws Exception {

        Category c = new Category();

//            
        if (!checkCategory(Category_id)) {
            throw new DataNotFoundException("Message with id " + Category_id + " not found");
            //System.out.println("unsuccessful");
        } else {
            try {

                String query = "select * from Categories where Category_id =?;";
                Connection conn = database.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, Category_id);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {

                    c.setCategoryId(rs.getString("Category_id"));
                    c.setCategoryName(rs.getString("Category_name"));
                    System.out.println("successful");
                }
            } catch (SQLException e) {

            } catch (Exception ex) {
                Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return c;
    }

    public static Category create(Category c)  {
       
                try {
                    Connection conn = database.getConnection();
                    System.out.println("execute");
                    PreparedStatement pst = conn.prepareStatement("insert into Categories values(?,?)");
                    pst.setString(1, c.getCategoryId());
                    pst.setString(2, c.getCategoryName());
                    System.out.println("execute 2" + c.getCategoryId() + c.getCategoryName());
                    int i = pst.executeUpdate();
                    System.out.println("execute 3" + i);
                   
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                }
                
     
         return c;
    }

    public static void update(Category c ) throws Exception {
        Connection conn = database.getConnection();
        System.out.println("execute");
        String sql = "UPDATE Categories SET Category_name=?  WHERE Category_id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, c.getCategoryId());
        pst.setString(2, c.getCategoryName());
        System.out.println("execute 2" + c.getCategoryId() + c.getCategoryName());
        int i = pst.executeUpdate();
        System.out.println(" updated:" + i);
     
    }
    

    public static void delete(String Category_id) {
        try {
            Connection conn = database.getConnection();
            String query = "delete from Categories where Category_id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, Category_id);
            int i = pst.executeUpdate();
            System.out.println("done executing " + query + "" + i);
        } catch (SQLException ex) {
            Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
