/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.dao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Charl3s
 */
public class Category {
    private String Category_id, Category_name;

    public Category() {
    }

    public Category(String Category_id, String Category_name) {
        this.Category_id = Category_id;
        this.Category_name = Category_name;
    }

    
    public String getCategoryId() {
        return Category_id;
    }

    public void setCategoryId(String Category_id) {
        this.Category_id = Category_id;
    }

    public String getCategoryName() {
        return Category_name;
    }

    public void setCategoryName(String Category_Name) {
        this.Category_name = Category_Name;
    }
    
}
