/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.mycompany.library.dao.Error;
import javax.el.MethodNotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Charl3s
 */
@Provider

public class GenericExceptionMapper implements ExceptionMapper<MethodNotFoundException> {

    @Override
    
    public Response toResponse(MethodNotFoundException ex) {
        Error err = new Error(ex.getMessage(), 407);
        return Response.status(Status.METHOD_NOT_ALLOWED)
                .entity(err)
                .build();
    }

}
