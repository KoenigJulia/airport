package at.htl.api;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.pilot.PilotRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("pilot")
public class PilotResource {
    private final PilotRepository pilotRepository;

    public PilotResource(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }


    @GET
    @Path("all")
    public Response getAllPilots() {
        var allPilots = this.pilotRepository.getAll();
        return Response.ok(allPilots).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Pilot pilot = this.pilotRepository.getPilot(id);
        return (pilot == null
                ? Response.status(404)
                : Response.ok(pilot))
                .build();
    }

    @PUT
    @Transactional
    @Path("updatePilot")
    public Response updatePilot(Pilot updatedPilot, @Context UriInfo uriInfo){
        this.pilotRepository.update(updatedPilot);
        return Response.ok(updatedPilot).build();
    }

    @POST
    @Transactional
    @Path("addPilot")
    public Response addPilot(Pilot newPilot, @Context UriInfo uriInfo){
        this.pilotRepository.add(newPilot);
        return Response.ok(newPilot).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removePilot(@PathParam("id") Long id){
        Pilot pilot = this.pilotRepository.removePilot(id);
        return (pilot == null
                ? Response.status(404)
                : Response.ok(pilot))
                .build();
    }
}
