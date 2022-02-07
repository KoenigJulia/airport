package at.htl.api;

import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.pilot.PilotRepository;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
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

}
