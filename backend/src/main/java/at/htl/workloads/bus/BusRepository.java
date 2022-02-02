package at.htl.workloads.bus;

import at.htl.workloads.airplane.Airplane;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BusRepository {
    public final EntityManager em;

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

    public Bus deleteBus(Long id){
        Bus bus = this.em.find(Bus.class,id);
        this.em.remove(bus);
        return bus;
    }
}
