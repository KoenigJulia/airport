package at.htl.api;

import at.htl.workloads.bus.Bus;
import at.htl.workloads.bus.BusRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("bus")
public class BusResource {
    private final BusRepository busRepository;

    public BusResource(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @GET
    @Path("all")
    public Response getAllBuses() {
        var allBuses = this.busRepository.getAll();
        return Response.ok(allBuses).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Bus bus = this.busRepository.getBus(id);
        return (bus == null
                ? Response.status(404)
                : Response.ok(bus))
                .build();
    }
}
