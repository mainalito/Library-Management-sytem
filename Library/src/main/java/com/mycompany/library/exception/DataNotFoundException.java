/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.exception;

/**
 *
 * @author Charl3s
 */
public class DataNotFoundException extends RuntimeException {

    static final long serialVersionUID = -7034897190745766939L;

    public DataNotFoundException(String message) {
        super(message);
    }

    

}
