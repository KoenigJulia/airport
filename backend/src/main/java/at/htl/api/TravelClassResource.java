package at.htl.api;

import at.htl.workloads.travelclass.TravelClass;
import at.htl.workloads.travelclass.TravelClassRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("travelClass")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravelClassResource {
    private final TravelClassRepository travelClassRepository;

    public TravelClassResource(TravelClassRepository travelClassRepository) {
        this.travelClassRepository = travelClassRepository;
    }


    @GET
    @Path("all")
    public Response getAllTravelClasses() {
        var allTravelClasses = this.travelClassRepository.getAll();
        return Response.ok(allTravelClasses).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        TravelClass travelClass = this.travelClassRepository.getTravelClass(id);
        return (travelClass == null
                ? Response.status(404)
                : Response.ok(travelClass))
                .build();
    }

    @PUT
    @Transactional
    @Path("updateTravelClass")
    public Response updateTravelClass(TravelClass updatedTravelClass, @Context UriInfo uriInfo) {
        this.travelClassRepository.update(updatedTravelClass);
        return Response.ok(updatedTravelClass).build();
    }

    @POST
    @Transactional
    @Path("addTravelClass")
    public Response addTravelClass(TravelClass newTravelClass, @Context UriInfo uriInfo) {
        this.travelClassRepository.add(newTravelClass);
        return Response.ok(newTravelClass).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeTravelClass(@PathParam("id") Long id) {
        TravelClass travelClass = this.travelClassRepository.removeTravelClass(id);
        return (travelClass == null
                ? Response.status(404)
                : Response.ok(travelClass))
                .build();
    }


}
