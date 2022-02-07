package at.htl.workloads.ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TicketRepository {
    public final EntityManager em;

    public TicketRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Ticket ticket){
        if(ticket.getTravelclass().getMaxLuggage() > ticket.getLugagge().size()){
            System.out.println("Ticket invalid (too many luggage)");
            return;
        }

        this.em.persist(ticket);
    }

    public void update(Ticket ticket) {
        this.em.merge(ticket);
    }

    public Ticket getTicket(Long id) {
        var query = this.em
                .createQuery("select t from Ticket t where t.id = :id", Ticket.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Ticket> getAll(){
        return this.em
                .createQuery("select t from Ticket t", Ticket.class)
                .getResultList();
    }

    public Ticket deleteTicket(Long id){
        Ticket ticket = this.em.find(Ticket.class,id);
        this.em.remove(ticket);
        return ticket;
    }

}
