package at.htl.workloads.flight;

import at.htl.workloads.airplane.Airplane;
import at.htl.workloads.employee.Employee;
import at.htl.workloads.location.Location;
import at.htl.workloads.luggage.Luggage;
import at.htl.workloads.luggage.Size;
import at.htl.workloads.person.Person;
import at.htl.workloads.pilot.Pilot;
import at.htl.workloads.seat.Seat;
import at.htl.workloads.seat.SeatId;
import at.htl.workloads.seat.SeatType;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.travelclass.TravelClass;

import javax.json.bind.annotation.JsonbTransient;
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
    private Location departureDestination;
    private String departureGate;
    private LocalDateTime departureTime;
    @ManyToOne
    private Location arrivalDestination;
    private String arrivalGate;
    private LocalDateTime arrivalTime;
    private Double distance;
    @ManyToOne
    private Airplane airplane;
    @ManyToMany
    private List<Employee> flightAttendants;
    @ManyToOne
    private Pilot pilot;
    @ManyToOne
    private Pilot coPilot;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats;

    @JsonbTransient
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;


    //region constructor
    public Flight() {
    }

    public Flight(Location startDestination, String startGate, LocalDateTime depatureTime, Location arrivalDestination, String arrivalGate, Double distance, Airplane airplane, LocalDateTime arrivalTime, List<Employee> flightAttendants, Pilot pilot, Pilot coPilot) {
        this.departureDestination = startDestination;
        this.departureGate = startGate;
        this.departureTime = depatureTime;
        this.arrivalDestination = arrivalDestination;
        this.arrivalGate = arrivalGate;
        this.arrivalTime = arrivalTime;
        this.distance = distance;
        this.airplane = airplane;
        this.flightAttendants = flightAttendants;
        this.pilot = pilot;
        this.coPilot = coPilot;
        createSeats();
    }


    public Seat getSeatBySeatNumber(int seatNumber) {
        return this.getSeats().stream()
                .filter(s -> s.getSeatId().getSeatNumber() == seatNumber)
                .findFirst()
                .orElse(null);
    }

    public Ticket bookFlight(Person person, TravelClass travelClass, int seatNumber, List<Luggage> luggage) {
        Seat seat = getSeatBySeatNumber(seatNumber);
        if (seat == null) return null;
        this.getSeats().remove(seat);

        double price = this.getAirplane().getDefaultTicketPrice();
        price += travelClass.getPrice();
        for (var l : luggage) {
            if (l.getSize() == Size.Small) {
                price += Luggage.SIZE_SMALL_PRICE;
            } else if (l.getSize() == Size.Medium) {
                price += Luggage.SIZE_MEDIUM_PRICE;
            } else if (l.getSize() == Size.Large) {
                price += Luggage.SIZE_LARGE_PRICE;
            }
        }
        Ticket ticket = new Ticket(this, person, price, seat, travelClass, luggage);
        return ticket;
    }

    public void createSeats() {
        seats = new ArrayList<>();
        int rows = this.getAirplane().getSeatRows();
        int columns = this.getAirplane().getSeatColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int seatNumber = i * rows + j + 1;
                SeatId seatId = new SeatId(seatNumber, this);
                Seat seat;
                if (j == 0 || j == getAirplane().getSeatColumns() - 1) {
                    seat = new Seat(seatId, SeatType.WINDOW);
                } else if (j == columns / 2 - 1 || j == columns / 2) {
                    seat = new Seat(seatId, SeatType.CORRIDOR);
                } else {
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

    public Location getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(Location startDestination) {
        this.departureDestination = startDestination;
    }

    public Location getArrivalDestination() {
        return arrivalDestination;
    }

    public void setArrivalDestination(Location endDestination) {
        this.arrivalDestination = endDestination;
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

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime startTime) {
        this.arrivalTime = startTime;
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

    public String getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(String startGate) {
        this.departureGate = startGate;
    }

    public String getArrivalGate() {
        return arrivalGate;
    }

    public void setArrivalGate(String endGate) {
        this.arrivalGate = endGate;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    //endregion
}
