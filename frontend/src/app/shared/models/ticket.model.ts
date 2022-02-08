import {Flight} from "./flight.model";
import {Luggage} from "./luggage.model";
import {Person} from "./person.model";
import {Seat} from "./seat.model";
import {TravelClass} from "./travel-class.model";

export interface Ticket {
  flight: Flight;
  id: number;
  luggage: Luggage[];
  person: Person;
  price: number;
  seat: Seat;
  travelClass: TravelClass;
}
