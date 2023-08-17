package com.distribuida.rest;

import com.distribuida.clients.SingerRestClient;
import com.distribuida.db.Album;
import com.distribuida.dto.AlbumDto;
import com.distribuida.dto.SingerDto;
import com.distribuida.repo.AlbumRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Path("/albums")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AlbumRest {

    @Inject
    AlbumRepository rep;

    @Inject
    @RestClient
    SingerRestClient clientSingers;


    @GET
    public List<AlbumDto> findAll(){
        return rep.findAll().list()
                .stream()
                .map(obj ->{
                    AlbumDto dto = new AlbumDto();
                    dto.setId(obj.getId());
                    dto.setReleaseDate(obj.getReleaseDate());
                    dto.setTitle(obj.getTitle());
                    dto.setVersion(obj.getVersion());
                    dto.setSingerId(obj.getSingerId());
                    SingerDto tmp = clientSingers.getById(dto.getSingerId());
                    String aname = String.format("%s, %s", tmp.getFirstName(), tmp.getLastName());
                    dto.setSingerFullName(aname);
                    return dto;
                }).collect(Collectors.toList());
    }

//    @GET
//    public List<Album> findAll(){
//        return rep.findAll().list();
//    }

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
    public Response create(Album p) {
        rep.persist(p);
        return Response.status(Response.Status.CREATED.getStatusCode(), "album created").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Album tmpObj) {
        Album obj = rep.findById(id);
        obj.setReleaseDate(tmpObj.getReleaseDate());
        obj.setVersion(tmpObj.getVersion());
        obj.setTitle(tmpObj.getTitle());
        obj.setSingerId(tmpObj.getSingerId());
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
