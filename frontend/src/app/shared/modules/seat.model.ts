import {SeatType} from "./seat-type.enum";
import {SeatId} from "./seat-id.model";

export interface Seat {
  seatId: SeatId;
  seatType: SeatType
}
