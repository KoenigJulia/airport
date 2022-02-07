package at.htl.api;

import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.luggage.LuggageRepository;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
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
}
