import { Component, OnInit } from '@angular/core';
import {Flight} from "../../../../shared/models/flight.model";
import {BackendApiServiceService} from "../../../../core/services/backend-api-service.service";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
})
export class BookComponent implements OnInit {
  flights: Flight[] | undefined;

  constructor(private backendApiService: BackendApiServiceService) { }

  ngOnInit(): void {
    this.backendApiService.getFlights().subscribe(f => {
      this.flights = f;
    })
  }
}
