/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.dao;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Charl3s
 */
@XmlRootElement
public class Book {
   private String book_id,book_name,book_author,book_Category_id;
   private Date date;

    public Book(String book_id, String book_name, String book_author, String book_Category_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_Category_id = book_Category_id;
        this.date = new Date();
    }
    
    public Book() {
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_Category_id() {
        return book_Category_id;
    }

    public void setBook_Category_id(String book_Category_id) {
        this.book_Category_id = book_Category_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}