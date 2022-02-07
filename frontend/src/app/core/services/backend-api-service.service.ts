import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Observable} from "rxjs";
import {Flight} from "../../shared/models/flight.model";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BackendApiServiceService {

  constructor(private http: HttpClient) { }

  getFlights(): Observable<Flight[]> {
    return this.http.get<Flight[]>(`${environment.backendUrl}/flight/all`);
  }
}
