/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.mycompany.library.dao.Error;


/**
 *
 * @author Charl3s
 */
@Provider 
//used to register a class in jax service .. a way to declare classes in jax rs
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException ex){
        Error er = new Error(ex.getMessage(),404);
        return Response.status(Status.NOT_FOUND)
                .entity(er)
                .build();
    }
    
   
    
}
