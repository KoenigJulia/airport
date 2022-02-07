import { Airplane } from "./airplane.model";
import { Pilot } from "./pilot.model";
import { Location } from "./location.model";
import { Attendant } from "./attendant.model";
import { Seat } from "./seat.model";

export interface Flight {
  airplane: Airplane;
  coPilot: Pilot;
  distance: number;
  endDestination: Location;
  endGate: string;
  flightAttendants: Attendant[];
  id: number;
  pilot: Pilot;
  seats: Seat[];
  startDestination: Location;
  startGate: string;
  startTime: Date;
}
