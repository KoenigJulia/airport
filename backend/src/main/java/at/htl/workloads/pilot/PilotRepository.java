package at.htl.workloads.pilot;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PilotRepository {
    public final EntityManager em;

    public PilotRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void add(Pilot pilot) {
        this.em.persist(pilot);
    }

    @Transactional
    public void update(Pilot pilot) {
        this.em.merge(pilot);
    }

    public Pilot getPilot(Long id) {
        var query = this.em
                .createQuery("select p from Pilot p where p.id = :id", Pilot.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Pilot> getAll() {
        return this.em
                .createQuery("select p from Pilot p", Pilot.class)
                .getResultList();
    }
}
