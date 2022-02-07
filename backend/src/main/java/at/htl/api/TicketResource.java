package at.htl.api;

import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("ticket")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"user", "admin"})
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

    @PUT
    @Transactional
    @Path("updateTicket")
    public Response updateTicket(Ticket updatedTicket, @Context UriInfo uriInfo) {
        this.ticketRepository.update(updatedTicket);
        return Response.ok(updatedTicket).build();
    }

    @POST
    @Transactional
    @Path("addTicket")
    public Response addTicket(Ticket newTicket, @Context UriInfo uriInfo) {
        this.ticketRepository.add(newTicket);
        return Response.ok(newTicket).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeTicket(@PathParam("id") Long id) {
        Ticket ticket = this.ticketRepository.removeTicket(id);
        return (ticket == null
                ? Response.status(404)
                : Response.ok(ticket))
                .build();
    }

}
