package at.htl.api;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.airplane.AirplaneRepository;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

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

}
