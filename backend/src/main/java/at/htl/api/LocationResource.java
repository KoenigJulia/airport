package at.htl.api;

import at.htl.workloads.location.Location;
import at.htl.workloads.location.LocationRepository;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("location")
public class LocationResource {
    private final LocationRepository locationRepository;

    public LocationResource(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @GET
    @Path("all")
    public Response getAllLocations() {
        var allLocations = this.locationRepository.getAll();
        return Response.ok(allLocations).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Location location = this.locationRepository.getLocation(id);
        return (location == null
                ? Response.status(404)
                : Response.ok(location))
                .build();
    }

}
