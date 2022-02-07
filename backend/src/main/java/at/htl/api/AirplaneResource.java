package at.htl.api;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.airplane.AirplaneRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public class AirplaneResource {
    private final AirplaneRepository airplaneRepository;

    public AirplaneResource(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @GET
    @Path("all")
    public Response getAllAirplanes() {
        var allAirplanes = this.airplaneRepository.getAll();
        return Response.ok(allAirplanes).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Airplane airplane = this.airplaneRepository.getAirplane(id);
        return (airplane == null
                ? Response.status(404)
                : Response.ok(airplane))
                .build();
    }

    @POST
    @Transactional
    @Path("addAirplane")
    public Response addAirplane(Airplane newAirplane, @Context UriInfo uriInfo){
        this.airplaneRepository.add(newAirplane);
        return Response.ok(newAirplane).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeAirplane(@PathParam("id") Long id){
        Airplane airplane = this.airplaneRepository.removeAirplane(id);
        return (airplane == null
                ? Response.status(404)
                : Response.ok(airplane))
                .build();
    }
}
