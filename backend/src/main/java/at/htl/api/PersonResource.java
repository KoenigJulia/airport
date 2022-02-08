package at.htl.api;

import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonRepository;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"user", "admin"})
public class PersonResource {
    private final PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GET
    @Path("all")
    public Response getAllPeople() {
        var allPeople = this.personRepository.getAll();
        return Response.ok(allPeople).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Person person = this.personRepository.getPerson(id);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }
    @GET
    @Path("byEmail")
    public Response get(@QueryParam("email") String email) {
        Person person = this.personRepository.getPerson(email);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }

    @PUT
    @Transactional
    @Path("updatePerson")
    public Response updatePerson(Person updatedPerson, @Context UriInfo uriInfo) {
        this.personRepository.update(updatedPerson);
        return Response.ok(updatedPerson).build();
    }

    @POST
    @Transactional
    @Path("addPerson")
    public Response addPerson(Person newPerson, @Context UriInfo uriInfo) {
        this.personRepository.add(newPerson);
        return Response.ok(newPerson).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removePerson(@PathParam("id") Long id) {
        Person person = this.personRepository.removePerson(id);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }

}
