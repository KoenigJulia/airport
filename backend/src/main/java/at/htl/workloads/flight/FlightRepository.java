package at.htl.workloads.flight;

import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.seat.Seat;
import at.htl.workloads.ticket.Ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class FlightRepository {
    public final EntityManager em;

    public FlightRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Flight flight) {
        this.em.persist(flight);
    }

    public void update(Flight flight) {
        this.em.merge(flight);
    }

    public Flight getFlight(Long id) {
        var query = this.em
                .createQuery("select f from Flight f where f.id = :id", Flight.class)
                .setParameter("id", id);

        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    public List<Flight> getAll() {
        return this.em
                .createQuery("select f from Flight f", Flight.class)
                .getResultList();
    }

    public List<Flight> getAllInRange(LocalDateTime startTime, LocalDateTime endTime) {
        return this.em
                .createQuery("select f from Flight f where " +
                        "f.departureTime >= :startTime and f.arrivalTime <= :endTime", Flight.class)
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime)
                .getResultList();
    }

    public List<Ticket> getAllTickets(long flightId){
        return this.em
                .createQuery("select t from Flight f left join f.tickets t where f.id = :flightId", Ticket.class)
                .setParameter("flightId", flightId)
                .getResultList();
    }

    public List<Seat> getAvailableSeats(long flightId){
        return this.em
                .createQuery("select s from Flight f left join f.seats s where f.id = :flightId", Seat.class)
                .setParameter("flightId", flightId)
                .getResultList();
    }

    public List<Seat> getBookedSeats(long flightId) {
        return this.em
                .createQuery("select t.seat from Flight f left join f.tickets t where f.id = :flightId", Seat.class)
                .setParameter("flightId", flightId)
                .getResultList();
    }

    public List<Luggage> getAllLuggage(long flightId){
        return this.em
                .createQuery("select l from Flight f left join f.tickets t left join t.luggage l " +
                        "where f.id = :flightId", Luggage.class)
                .setParameter("flightId", flightId)
                .getResultList();
    }

    public List<FlightLuggageWeight> getFlightsLuggageWeight(){
        return this.em
                .createQuery("select new at.htl.workloads.flight.FlightLuggageWeight(f.id, coalesce(sum(l.weight), 0.0)) from Flight f " +
                        "left join f.tickets t " +
                        "left join t.luggage l group by f.id order by f.id", FlightLuggageWeight.class)
                .getResultList();
    }

    public Flight removeFlight(Long id){
        Flight flight = this.em.find(Flight.class,id);
        this.em.remove(flight);
        return flight;
    }

}
