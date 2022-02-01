package at.htl.workloads.travelclass;

import javax.persistence.EntityManager;
import java.util.List;

public class TravelclassRepository {
    private final EntityManager em;

    public TravelclassRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Travelclass travelclass){
        this.em.persist(travelclass);
    }

    public void update(Travelclass travelclass){
        this.em.merge(travelclass);
    }

    public Travelclass getTravelclass(Long id) {
        var query = this.em
                .createQuery("select tr from Travelclass tr where tr.id = :id", Travelclass.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Travelclass> getAll() {
        return this.em
                .createQuery("select tr from Travelclass tr", Travelclass.class)
                .getResultList();
    }
}
