package at.htl.workloads.flight;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.flightattendant.FlightAttendant;
import at.htl.workloads.location.Location;
import at.htl.workloads.person.Person;
import at.htl.workloads.pilot.Pilot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Location startDestination;
    @ManyToOne
    private Location endDestination;
    private Double distance;
    @ManyToOne
    private Airplane airplane;
    private LocalDateTime startTime;
    @OneToMany
    private List<FlightAttendant> flightAttendants;
    @OneToMany
    private List<Pilot> pilots;
    @OneToMany
    private List<Person> personList;
    //region gettersetter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Location getStartDestination() {
        return startDestination;
    }
    public void setStartDestination(Location startDestination) {
        this.startDestination = startDestination;
    }
    public Location getEndDestination() {
        return endDestination;
    }
    public void setEndDestination(Location endDestination) {
        this.endDestination = endDestination;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public Airplane getAirplane() {
        return airplane;
    }
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public List<FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }
    public void setFlightAttendants(List<FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }
    public List<Pilot> getPilots() {
        return pilots;
    }
    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }
    public List<Person> getPersonList() {
        return personList;
    }
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
    //endregion
}
