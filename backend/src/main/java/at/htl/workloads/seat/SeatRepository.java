package at.htl.workloads.seat;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class SeatRepository {
    public final EntityManager em;

    public SeatRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Seat seat) {
        this.em.persist(seat);
    }

    public void update(Seat seat) {
        this.em.merge(seat);
    }
}
