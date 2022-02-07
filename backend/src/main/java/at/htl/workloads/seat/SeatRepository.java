package at.htl.workloads.seat;

import at.htl.workloads.pilot.Pilot;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

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

    public Seat getSeat(int Sid, Long Fid) {
        var query = this.em
                .createQuery("select s from Seat s where s.seatId.seatNumber = :Sid and s.seatId.flight.id = :Fid", Seat.class)
                .setParameter("Sid", Sid)
                .setParameter("Fid", Fid);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Seat> getAll() {
        return this.em
                .createQuery("select s from Seat s", Seat.class)
                .getResultList();
    }
}
