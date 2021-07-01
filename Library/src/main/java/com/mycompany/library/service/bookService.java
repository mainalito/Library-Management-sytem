/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.service;

import com.mycompany.library.dao.Book;
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
public class bookService {

    public static List<Book> getAll() throws Exception {
        List<Book> list = new ArrayList<>();
        String query = " select * from Book ";
        try (Connection conn = database.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Book b = new Book();

                    b.setBook_id(rs.getString(1));
                    b.setBook_name(rs.getString(2));
                    b.setBook_author(rs.getString(3));
                    b.setBook_Category_id(rs.getString(4));
                    list.add(b);
                }
            }
        }

        return list;
    }

    public static Book create(Book b) {
        try {
            Connection conn = database.getConnection();
            System.out.println("execute");
            PreparedStatement pst = conn.prepareStatement("insert into Book values(?,?,?,?)");
            pst.setString(1, b.getBook_id());
            pst.setString(2, b.getBook_name());
            pst.setString(3, b.getBook_author());
            pst.setString(4, b.getBook_Category_id());
            System.out.println("execute 2" + b.getBook_name() + b.getBook_author());
            int i = pst.executeUpdate();
            System.out.println("execute 3" + i);

        } catch (SQLException ex) {
            Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public static boolean checkBook(String book_id) throws Exception {
        boolean st = false;
        try {
            Connection conn = database.getConnection();
            String Query = "Select  * from Book WHERE book_id=?";
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setString(1, book_id);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (Exception e) {
        }
        return st;
    }

    public static Book getBookId(String book_id) throws Exception {

        Book b = new Book();

//            
        if (!checkBook(book_id)) {
            throw new DataNotFoundException("Message with id " + book_id + " not found");
            //System.out.println("unsuccessful");
        } else {
            try {

                String query = "select * from Book where book_id =?;";
                Connection conn = database.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, book_id);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    b.setBook_id(rs.getString(1));
                    b.setBook_name(rs.getString(2));
                    b.setBook_author(rs.getString(3));
                    b.setBook_Category_id(rs.getString(4));

                    System.out.println("successful");
                }
            } catch (SQLException e) {

            } catch (Exception ex) {
                Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return b;
    }
    
     public static void delete(String book_id) {
        try {
            Connection conn = database.getConnection();
            String query = "delete from Book where book_id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, book_id);
            int i = pst.executeUpdate();
            System.out.println("done executing " + query + "" + i);
        } catch (SQLException ex) {
            Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(bookService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
