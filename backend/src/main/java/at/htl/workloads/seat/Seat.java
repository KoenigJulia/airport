package at.htl.workloads.seat;

import javax.persistence.*;

@Entity
public class Seat {
    @EmbeddedId
    private SeatId seatId;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    //region constructor
    public Seat() {
    }

    public Seat(SeatId seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    //endregion


    //region gettersetter


    public SeatId getSeatId() {
        return seatId;
    }

    public void setSeatId(SeatId seatId) {
        this.seatId = seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    //endregion
}
