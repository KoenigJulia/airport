package at.htl.api;

import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;
import at.htl.workloads.travelclass.TravelClass;
import at.htl.workloads.travelclass.TravelClassRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("travelclass")
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

}
