package at.htl.api;

import at.htl.workloads.flight.Flight;
import at.htl.workloads.flight.FlightRepository;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Path("flight")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"user", "admin"})
public class FlightResource {
    private final FlightRepository flightRepository;

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
    @Path("tickets/{flightId}")
    public Response getAllTickets(@QueryParam("flightId") long flightId){
        var seats = this.flightRepository.getAllTickets(flightId);
        return Response.ok(seats).build();
    }

    @GET
    @Path("flightsLuggageWeight")
    public Response getFlightWithLuggageWeight(){
        var flightLuggageWeights = this.flightRepository.getFlightsLuggageWeight();
        var res = flightLuggageWeights.stream().map(flw -> Json.createObjectBuilder()
                .add("flightId", flw.flightId())
                .add("weight", flw.weight())
                .build()
        ).toList();
        return Response.ok(res).build();
    }

    @GET
    @Path("availableSeats/{flightId}")
    public Response getAvailableSeats(@QueryParam("flightId") long flightId){
        var seats = this.flightRepository.getAvailableSeats(flightId);
        return Response.ok(seats).build();
    }

    @GET
    @Path("bookedSeats/{flightId}")
    public Response getBookedSeats(@QueryParam("flightId") long flightId){
        var seats = this.flightRepository.getBookedSeats(flightId);
        return Response.ok(seats).build();
    }

    @GET
    @Path("allLuggage/{flightId}")
    public Response getAllLuggage(@QueryParam("flightId") long flightId){
        var luggage = this.flightRepository.getAllLuggage(flightId);
        return Response.ok(luggage).build();
    }

    @GET
    @Path("inRange")
    public Response getAllFlights(@QueryParam("startTime") String startTime, @QueryParam("endTime") String endTime) {
        LocalDate start = LocalDate.parse(startTime);
        LocalDate end = LocalDate.parse(endTime);
        var allFlights = this.flightRepository.getAllInRange(start.atStartOfDay(), end.atStartOfDay());
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
