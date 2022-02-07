package at.htl.api;

import at.htl.workloads.location.Location;
import at.htl.workloads.location.LocationRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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

    @POST
    @Transactional
    @Path("addLocation")
    public Response addLocation(Location newLocation, @Context UriInfo uriInfo){
        this.locationRepository.add(newLocation);
        return Response.ok(newLocation).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeLocation(@PathParam("id") Long id){
        Location location = this.locationRepository.removeLocation(id);
        return (location == null
                ? Response.status(404)
                : Response.ok(location))
                .build();
    }
}
