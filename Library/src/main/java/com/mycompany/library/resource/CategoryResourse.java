/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.resource;

import com.mycompany.library.dao.Category;
import com.mycompany.library.service.CategoryService;
import java.net.URI;
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
@Path("categories")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)//this is a subresource
public class CategoryResourse {

    @GET
    public List<Category> getCategory(@Context UriInfo uriInfo) throws Exception {
        URI uri = uriInfo.getAbsolutePathBuilder().build();
        return CategoryService.getCategory();
    }

    @GET
    @Path("{Category_id}")
    public Response getId(@PathParam("Category_id") String Category_id, @Context UriInfo uriInfo) throws Exception {
        Category cat = CategoryService.getCateId(Category_id);
        URI uri = uriInfo.getAbsolutePathBuilder().build();
        return Response.created(uri)
                .status(Response.Status.OK)
                .entity(cat)
                .build();

    }

    @DELETE
    @Path("{Category_id}")
    public Response delete(@PathParam("Category_id") String Category_id, @Context UriInfo uriInfo) throws Exception {
        CategoryService.getCateId(Category_id);
        CategoryService.delete(Category_id);
        URI uri = uriInfo.getAbsolutePathBuilder().build();
        return Response.created(uri)
                .status(Status.NO_CONTENT)
                .build();

    }

    @POST
    public Response create(@Context UriInfo uriInfo, Category c) throws Exception {
        Category cat = CategoryService.create(c);
        String catId = String.valueOf(cat.getCategoryId());
        //uri for the new message ..
        // we use @Context to achieve this
        //we have added the category id to the path using the uribuilder
        //we use .path to add several 
        URI uri = uriInfo.getAbsolutePathBuilder().path(catId).build();
        return Response.created(uri)
                .entity(cat)
                .build();
        //return bookService.create(c);
    }

    @PUT
    public Category update(Category category) throws Exception {

        CategoryService.update(category);
        return category;
    }

    @GET
    @Path("context")
    public String getParamns(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "path " + path + " \nCookies " + cookies;
    }

    @GET
    @Path("secured")

    public String securedMethod() {
        return "this is a secured API";
    }

}
