package at.htl.workloads.luggage;

import at.htl.workloads.bus.Bus;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LuggageRepository {
    public final EntityManager em;

    public LuggageRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Luggage luggage) {
        this.em.persist(luggage);
    }

    public void update(Luggage luggage) {
        this.em.merge(luggage);
    }

    public Luggage getLuggage(Long id) {
        var query = this.em
                .createQuery("select l from Luggage l where l.id = :id", Luggage.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Luggage> getAll() {
        return this.em
                .createQuery("select l from Luggage l", Luggage.class)
                .getResultList();
    }

    public Luggage deleteLuggage(Long id){
        Luggage luggage = this.em.find(Luggage.class,id);
        this.em.remove(luggage);
        return luggage;
    }

}
