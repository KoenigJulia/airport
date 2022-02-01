package at.htl.workloads.travelclass;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TravelclassRepository {
    public final EntityManager em;

    public TravelclassRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void add(Travelclass travelclass){
        this.em.persist(travelclass);
    }

    @Transactional
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
