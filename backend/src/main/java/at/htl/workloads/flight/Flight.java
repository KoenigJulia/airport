package at.htl.workloads.flight;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.employee.Employee;
import at.htl.workloads.location.Location;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.seat.Seat;
import at.htl.workloads.seat.SeatId;
import at.htl.workloads.seat.SeatType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @ManyToMany
    private List<Employee> flightAttendants;
    @ManyToOne
    private Pilot pilot;
    @ManyToOne
    private Pilot coPilot;

    private LocalDateTime startTime;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats;


    //region constructor
    public Flight() {
    }

    public Flight(Location startDestination, Location endDestination, Double distance, Airplane airplane, LocalDateTime startTime, List<Employee> flightAttendants, Pilot pilot, Pilot coPilot) {
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.distance = distance;
        this.airplane = airplane;
        this.startTime = startTime;
        this.flightAttendants = flightAttendants;
        this.pilot = pilot;
        this.coPilot = coPilot;
        createSeats();
    }

    public void createSeats(){
        seats = new ArrayList<>();
        int rows = this.getAirplane().getRows();
        int columns = this.getAirplane().getColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int seatNumber = i * rows + j + 1;
                SeatId seatId = new SeatId(seatNumber, this);
                Seat seat;
                if(j == 0 || j == getAirplane().getColumns() - 1){
                    seat = new Seat(seatId, SeatType.WINDOW);
                }
                else if(j == columns / 2 - 1 ||  j == columns / 2) {
                    seat = new Seat(seatId, SeatType.CORRIDOR);
                }
                else {
                    seat = new Seat(seatId, SeatType.MIDDLE);
                }
                this.getSeats().add(seat);
            }
        }
    }

    //endregion
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

    public List<Employee> getFlightAttendants() {
        return flightAttendants;
    }

    public void setFlightAttendants(List<Employee> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Pilot getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(Pilot coPilot) {
        this.coPilot = coPilot;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }


    //endregion
}
