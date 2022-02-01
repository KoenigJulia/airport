package at.htl.workloads.bus;

import at.htl.workloads.person.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class BusRepository {
    private final EntityManager em;

    public BusRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Bus bus){
        this.em.persist(bus);
    }

    public void update(Bus bus){
        this.em.merge(bus);
    }

    public Bus getBus(Long id) {
        var query = this.em
                .createQuery("select b from Bus b where b.id = :id", Bus.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Bus> getAll() {
        return this.em
                .createQuery("select b from Bus b", Bus.class)
                .getResultList();
    }
}
