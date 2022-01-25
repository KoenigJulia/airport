package at.htl.workloads.person;

import at.htl.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonRepository {
    public final EntityManager em;

    public PersonRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Person person) {
        this.em.persist(person);
    }

    public void update(Person person) {
        this.em.merge(person);
    }

    public Person getPerson(Long id) {
        var query = this.em
                .createQuery("select p from Person p where p.id = :id", Person.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Person> getAll() {
        return this.em
                .createQuery("select p from Person p", Person.class)
                .getResultList();
    }
}
