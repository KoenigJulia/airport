import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Flight} from "../../shared/models/flight.model";
import {environment} from "../../../environments/environment";
import {Person} from "../../shared/models/person.model";
import {AuthenticationService} from "../authentication/authentication.service";
import {Seat} from "../../shared/models/seat.model";
import {Employee} from "../../shared/models/employee.model";
import {Pilot} from "../../shared/models/pilot.model";
import {Airplane} from "../../shared/models/airplane.model";
import {Ticket} from "../../shared/models/ticket.model";

@Injectable({
  providedIn: 'root'
})
export class BackendApiService {
  headers = {};

  requestOptions = {};

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) {

  }

  getFlights(): Observable<Flight[]> {
    return this.http.get<Flight[]>(`${environment.backendUrl}/flight/all`, this.requestOptions);
  }

  getPersonByEmail(): Observable<Person> {
    this.headers = {
      "Authorization": "Basic " + btoa(this.authenticationService.username + ":" + this.authenticationService.password)
    }

    this.requestOptions = {
      headers: new HttpHeaders(this.headers)
    }

    return this.http.get<Person>(`${environment.backendUrl}/person/byEmail?email=${this.authenticationService.username.replace("@", "%40")}`, this.requestOptions);
  }

  getFlightsInTime(startTime: string | null, endTime: string | null): Observable<Flight[]> {
    return this.http.get<Flight[]>(`${environment.backendUrl}/flight/inRange?startTime=${startTime}&endTime=${endTime}`, this.requestOptions);
  }

  getFlightById(id: number): Observable<Flight> {
    return this.http.get<Flight>(`${environment.backendUrl}/flight/${id}`, this.requestOptions);
  }

  getPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.backendUrl}/person/all`, this.requestOptions);
  }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${environment.backendUrl}/employee/all`, this.requestOptions);
  }

  getPilots(): Observable<Pilot[]> {
    return this.http.get<Pilot[]>(`${environment.backendUrl}/pilot/all`, this.requestOptions);
  }

  getAirplanes(): Observable<Airplane[]> {
    return this.http.get<Airplane[]>(`${environment.backendUrl}/airplane/all`, this.requestOptions);
  }

  getTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${environment.backendUrl}/ticket/all`, this.requestOptions);
  }


  getAvailableSeats(id: number): Observable<Seat[]> {
    return this.http.get<Seat[]>(`${environment.backendUrl}/flight/availableSeats/${id}?flightId=${id}`, this.requestOptions);
  }
}
