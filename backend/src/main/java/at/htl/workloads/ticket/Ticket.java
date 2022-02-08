package at.htl.workloads.ticket;

import at.htl.workloads.flight.Flight;
import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.person.Person;
import at.htl.workloads.seat.Seat;
import at.htl.workloads.travelclass.TravelClass;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Person person;
    private double price;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private TravelClass travelclass;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Luggage> luggage;

    //region constructor
    public Ticket() {
    }
    public Ticket(Flight flight, Person person, double price, Seat seat, TravelClass travelclass,
                  List<Luggage> luggage) {
        this.flight = flight;
        this.person = person;
        this.price = price;
        this.seat = seat;
        this.travelclass = travelclass;
        this.luggage = luggage;
    }

    //endregion
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public TravelClass getTravelclass() {
        return travelclass;
    }
    public void setTravelclass(TravelClass travelclass) {
        this.travelclass = travelclass;
    }
    public List<Luggage> getLuggage() {
        return luggage;
    }
    public void setLuggage(List<Luggage> lugagge) {
        this.luggage = lugagge;
    }
//endregion
}
