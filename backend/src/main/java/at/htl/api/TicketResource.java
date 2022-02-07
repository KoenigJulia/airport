package at.htl.api;

import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("ticket")
public class TicketResource {
    private final TicketRepository ticketRepository;

    public TicketResource(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @GET
    @Path("all")
    public Response getAllTickets() {
        var allTickets = this.ticketRepository.getAll();
        return Response.ok(allTickets).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Ticket ticket = this.ticketRepository.getTicket(id);
        return (ticket == null
                ? Response.status(404)
                : Response.ok(ticket))
                .build();
    }
}
