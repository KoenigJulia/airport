package at.htl.api;

import at.htl.workloads.flight.Flight;
import at.htl.workloads.flight.FlightRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("flight")
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
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Flight flight = this.flightRepository.getFlight(id);
        return (flight == null
                ? Response.status(404)
                : Response.ok(flight))
                .build();
    }
}
