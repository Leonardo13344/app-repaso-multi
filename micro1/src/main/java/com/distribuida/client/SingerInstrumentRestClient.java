package com.distribuida.client;

import com.distribuida.dto.SingerInstrumentDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/singers-instruments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "singer-instrumentRestClient")
public interface SingerInstrumentRestClient {

    @GET
    List<SingerInstrumentDto> findAll();

    @GET
    @Path("/{id}")
    SingerInstrumentDto getById(@PathParam("id") Integer id);

    @POST
    void create(SingerInstrumentDto r);

}
