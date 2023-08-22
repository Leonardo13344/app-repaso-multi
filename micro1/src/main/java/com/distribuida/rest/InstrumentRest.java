package com.distribuida.rest;

import com.distribuida.db.Instrument;

import com.distribuida.db.Singer;
import com.distribuida.repo.InstrumentRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/instruments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class InstrumentRest {

    @Inject
    InstrumentRepository rep;

    @GET
    public List<Instrument> findAll(){
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
    public Response create(Instrument p) {
        rep.persist(p);
        return Response.status(Response.Status.CREATED.getStatusCode(), "instrument created").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        rep.deleteById(id);
        return Response.ok( )
                .build();
    }
}
