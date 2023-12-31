package com.distribuida.rest;

import com.distribuida.db.SingerInstrument;
import com.distribuida.repo.SingerInstrumentRepo;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/singers-instruments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class SingerInstrumentRest {

    @Inject
    SingerInstrumentRepo rep;

    @GET
    public List<SingerInstrument> findAll(){
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
    public Response create(SingerInstrument p) {
        rep.persist(p);
        return Response.status(Response.Status.CREATED.getStatusCode(), "singer created").build();
    }

    @DELETE
    public Response delete(Long id) {
        rep.deleteById(id);
        return Response.ok( )
                .build();
    }
}
