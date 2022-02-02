package at.htl.workloads.airplane;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AirplaneRepository {
    public final EntityManager em;

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

    public Airplane deleteAirplane(Long id){
        Airplane airplane = this.em.find(Airplane.class,id);
        this.em.remove(airplane);
        return airplane;
    }
}
