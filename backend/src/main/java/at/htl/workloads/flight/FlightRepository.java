package at.htl.workloads.flight;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FlightRepository {
    public final EntityManager em;

    public FlightRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Flight flight) {
        this.em.persist(flight);
    }

    public void update(Flight flight) {
        this.em.merge(flight);
    }

    public Flight getFlight(Long id) {
        var query = this.em
                .createQuery("select f from Flight f where f.id = :id", Flight.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Flight> getAll() {
        return this.em
                .createQuery("select f from Flight f", Flight.class)
                .getResultList();
    }
}
