package at.htl.workloads.travelclass;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TravelClassRepository {
    public final EntityManager em;

    public TravelClassRepository(EntityManager em) {
        this.em = em;
    }

    public void add(TravelClass travelclass){
        this.em.persist(travelclass);
    }

    public void update(TravelClass travelclass){
        this.em.merge(travelclass);
    }

    public TravelClass getTravelClass(Long id) {
        var query = this.em
                .createQuery("select tr from TravelClass tr where tr.id = :id", TravelClass.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<TravelClass> getAll() {
        return this.em
                .createQuery("select tr from TravelClass tr", TravelClass.class)
                .getResultList();
    }

    public TravelClass removeTravelClass(Long id){
        TravelClass travelClass = this.em.find(TravelClass.class,id);
        this.em.remove(travelClass);
        return travelClass;
    }

}
