package at.htl.api;

import at.htl.workloads.flight.Flight;
import at.htl.workloads.flight.FlightRepository;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Path("flight")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"user", "admin"})
public class FlightResource {
    private final FlightRepository flightRepository;
    
     DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("M/d/yy, h:mm a");

    public FlightResource(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @GET
    @Path("all")
    public Response getAllFlights() {
        var allFlights = this.flightRepository.getAll();
        return Response.ok(allFlights).build();
    }

    @GET
    @Path("availableSeats/{flightId}")
    public Response getAvailableSeats(@QueryParam("flightId") long flightId){
        var seats = this.flightRepository.getAvailableSeats(flightId);
        return Response.ok(seats).build();
    }

    @GET
    @Path("inRange")
    public Response getAllFlights(@QueryParam("startTime") String startTime, @QueryParam("endTime") String endTime) {
        LocalDateTime start = LocalDateTime.parse(startTime, dateTimeFormatter);
        LocalDateTime end = LocalDateTime.parse(endTime, dateTimeFormatter);
        var allFlights = this.flightRepository.getAllInRange(start, end);
        return Response.ok(allFlights).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Flight flight = this.flightRepository.getFlight(id);
        return (flight == null
                ? Response.status(404)
                : Response.ok(flight))
                .build();
    }

    @PUT
    @Transactional
    @Path("updateFlight")
    public Response updateFlight(Flight updatedFlight, @Context UriInfo uriInfo) {
        this.flightRepository.update(updatedFlight);
        return Response.ok(updatedFlight).build();
    }

    @POST
    @Transactional
    @Path("addFlight")
    public Response addFlight(Flight newFlight, @Context UriInfo uriInfo) {
        this.flightRepository.add(newFlight);
        return Response.ok(newFlight).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeFlight(@PathParam("id") Long id) {
        Flight flight = this.flightRepository.removeFlight(id);
        return (flight == null
                ? Response.status(404)
                : Response.ok(flight))
                .build();
    }

}
