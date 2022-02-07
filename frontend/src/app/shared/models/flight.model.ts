import { Airplane } from "./airplane.model";
import { Pilot } from "./pilot.model";
import { Location } from "./location.model";
import { Attendant } from "./attendant.model";
import { Seat } from "./seat.model";

export interface Flight {
  airplane: Airplane;
  coPilot: Pilot;
  distance: number;
  arrivalDestination: Location;
  arrivalTime: Date;
  arrivalGate: string;
  flightAttendants: Attendant[];
  id: number;
  pilot: Pilot;
  seats: Seat[];
  departureDestination: Location;
  departureGate: string;
  departureTime: Date;
}
