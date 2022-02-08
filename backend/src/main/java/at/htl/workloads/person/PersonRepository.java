package at.htl.workloads.person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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

    public Person getPerson(String email) {
        var query = this.em
                .createQuery("select p from Person p where p.email = :email", Person.class)
                .setParameter("email", email);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Person> getAll() {
        return this.em
                .createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    public Person removePerson(Long id){
        Person person = this.em.find(Person.class,id);
        this.em.remove(person);
        return person;
    }

}
