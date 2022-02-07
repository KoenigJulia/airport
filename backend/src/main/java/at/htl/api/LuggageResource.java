package at.htl.api;

import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.luggage.LuggageRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("luggage")
public class LuggageResource {
    private final LuggageRepository luggageRepository;

    public LuggageResource(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }


    @GET
    @Path("all")
    public Response getAllTLuggage() {
        var allLuggage = this.luggageRepository.getAll();
        return Response.ok(allLuggage).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Luggage luggage = this.luggageRepository.getLuggage(id);
        return (luggage == null
                ? Response.status(404)
                : Response.ok(luggage))
                .build();
    }

    @POST
    @Transactional
    @Path("addLuggage")
    public Response addLuggage(Luggage newLuggage, @Context UriInfo uriInfo){
        this.luggageRepository.add(newLuggage);
        return Response.ok(newLuggage).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeLuggage(@PathParam("id") Long id){
        Luggage luggage = this.luggageRepository.removeLuggage(id);
        return (luggage == null
                ? Response.status(404)
                : Response.ok(luggage))
                .build();
    }

}
