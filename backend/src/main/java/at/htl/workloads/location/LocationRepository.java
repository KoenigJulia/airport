package at.htl.workloads.location;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LocationRepository {
    public final EntityManager em;

    public LocationRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Location location){
        this.em.persist(location);
    }

    public void update(Location location){
        this.em.merge(location);
    }

    public Location getLocation(Long id) {
        var query = this.em
                .createQuery("select l from Location l where l.id = :id", Location.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Location> getAll() {
        return this.em
                .createQuery("select l from Location l", Location.class)
                .getResultList();
    }

    public Location deleteLocation(Long id){
        Location location = this.em.find(Location.class,id);
        this.em.remove(location);
        return location;
    }

}
