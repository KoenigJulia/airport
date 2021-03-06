package at.htl.api;

import at.htl.workloads.seat.Seat;
import at.htl.workloads.seat.SeatRepository;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("seat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"user", "admin"})
public class SeatResource {
    private final SeatRepository seatRepository;

    public SeatResource(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    @GET
    @Path("all")
    public Response getAllSeats() {
        var allSeats = this.seatRepository.getAll();
        return Response.ok(allSeats).build();
    }

    @GET
    @Path("getSeat")
    public Response get(@QueryParam("SeatId") int Sid, @QueryParam("FlightId") Long Fid) {
        Seat seat = this.seatRepository.getSeat(Sid, Fid);
        return (seat == null
                ? Response.status(404)
                : Response.ok(seat))
                .build();
    }
}
