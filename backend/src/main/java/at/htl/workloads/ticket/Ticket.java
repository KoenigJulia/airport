package at.htl.workloads.ticket;

import at.htl.workloads.flight.Flight;
import at.htl.workloads.person.Person;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Person person;

    //region gettersetter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    //endregion
}
