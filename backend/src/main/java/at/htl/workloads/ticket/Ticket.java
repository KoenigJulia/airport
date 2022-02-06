package at.htl.workloads.ticket;

import at.htl.workloads.flight.Flight;
import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.person.Person;
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
    private Double price;
    private Integer seatNumber;
    private String rowNumber;
    @ManyToOne
    private TravelClass travelclass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<Luggage> lugagge;

    //region constructor
    public Ticket() {
    }
    public Ticket(Flight flight, Person person, Double price, Integer seatNumber, String rowNumber, TravelClass travelclass,
                  List<Luggage> luggage) {
        this.flight = flight;
        this.person = person;
        this.price = price;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.travelclass = travelclass;
        this.lugagge = luggage;
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
    public Integer getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String getRowNumber() {
        return rowNumber;
    }
    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }
    public TravelClass getTravelclass() {
        return travelclass;
    }
    public void setTravelclass(TravelClass travelclass) {
        this.travelclass = travelclass;
    }
    public List<Luggage> getLugagge() {
        return lugagge;
    }
    public void setLugagge(List<Luggage> lugagge) {
        this.lugagge = lugagge;
    }
//endregion
}
