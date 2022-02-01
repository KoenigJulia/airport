package at.htl.workloads.airplane;

import javax.persistence.EntityManager;
import java.util.List;

public class AirplaneRepository {
    private final EntityManager em;

    public AirplaneRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Airplane airplane){
        this.em.persist(airplane);
    }

    public void update(Airplane airplane){
        this.em.merge(airplane);
    }

    public Airplane getAirplane(Long id) {
        var query = this.em
                .createQuery("select a from Airplane a where a.id = :id", Airplane.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Airplane> getAll() {
        return this.em
                .createQuery("select a from Airplane a", Airplane.class)
                .getResultList();
    }
}
