package at.htl.api;

import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonRepository;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("person")
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

    @POST
    @Transactional
    @Path("addPerson")
    public Response addPerson(Person newPerson, @Context UriInfo uriInfo){
        this.personRepository.add(newPerson);
        return Response.ok(newPerson).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removePerson(@PathParam("id") Long id){
        Person person = this.personRepository.removePerson(id);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }

}
