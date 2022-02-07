package at.htl.workloads.seat;

import at.htl.workloads.flight.Flight;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeatId implements Serializable {
    private int seatNumber;
    @JsonbTransient
    @ManyToOne
    private Flight flight;

    public SeatId() {
    }

    public SeatId(int seatNumber, Flight flight) {
        this.seatNumber = seatNumber;
        this.flight = flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int id) {
        this.seatNumber = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatId seatId = (SeatId) o;
        return seatNumber == seatId.seatNumber && Objects.equals(flight, seatId.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, flight);
    }
}
