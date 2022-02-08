import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Flight} from "../../shared/models/flight.model";
import {environment} from "../../../environments/environment";
import {Person} from "../../shared/models/person.model";
import {AuthenticationService} from "../authentication/authentication.service";

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
}
