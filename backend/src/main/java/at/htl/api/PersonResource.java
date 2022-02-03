package at.htl.api;

import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

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
}
