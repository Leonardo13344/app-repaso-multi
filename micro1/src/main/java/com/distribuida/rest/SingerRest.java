package com.distribuida.rest;

import com.distribuida.db.Singer;
import com.distribuida.repo.SingerRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/singers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class SingerRest {

    @Inject
    SingerRepository rep;

    @GET
    public List<Singer> findAll(){
        return rep.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        var obj = rep.findByIdOptional(id);
        if (obj.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(obj.get()).build();
    }

    @POST
    public Response create(Singer p) {
        rep.persist(p);
        return Response.status(Response.Status.CREATED.getStatusCode(), "singer created").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Singer tmpObj) {
        Singer obj = rep.findById(id);
        obj.setFirstName(tmpObj.getFirstName());
        obj.setLastName(tmpObj.getLastName());
        obj.setBirthDate(tmpObj.getBirthDate());
        obj.setVersion(tmpObj.getVersion());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        rep.deleteById(id);
        return Response.ok( )
                .build();
    }
}
