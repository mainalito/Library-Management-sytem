/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.resource;

import com.mycompany.library.dao.Book;
import com.mycompany.library.dao.Category;
import com.mycompany.library.database.database;
import com.mycompany.library.service.CategoryService;
import com.mycompany.library.service.bookService;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Charl3s
 */
@Path("/book")
@Produces(value = {MediaType.APPLICATION_JSON ,MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class bookResource {

    @GET
    public List<Book> getAll() throws Exception {
        return bookService.getAll();
    }
//    public Response getAll() throws Exception{
//       return Response.status(200).entity(bookService.getAll()).build();
//
////          return Response.status(200).entity("fifa").build();
//    
//    }

    @GET
    @Path("fifa")
    @Produces(MediaType.TEXT_HTML)
    public Response get() {
        return Response.status(200).entity("fifa").build();
    }

    @POST
    public Response create(Book b) {
        return Response.status(Response.Status.CREATED)
                .entity(bookService.create(b))
                .build();
    }

    @GET
    @Path("{book_id}")
    public Response getId(@PathParam("book_id") String book_id, @Context UriInfo uriInfo) throws Exception {
        Book bo = bookService.getBookId(book_id);
        String bId = String.valueOf(bo.getBook_id());
        URI uri = uriInfo.getAbsolutePathBuilder().path(bId).build();
        return Response.created(uri)
                .status(Status.OK)
                .entity(bo)
                .build();
    }

    @DELETE
    @Path("{book_id}")
    public void delete(@PathParam("book_id") String book_id) throws Exception {
        bookService.getBookId(book_id);
        bookService.delete(book_id);

    }
//   @Path("categories")
//    public CategoryResourse getCategoryResource() //jersey is mapping using this function to CategoryResource
//    {
//        return new CategoryResourse();
//    }
}
