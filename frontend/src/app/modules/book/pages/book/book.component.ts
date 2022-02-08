import { Component, OnInit } from '@angular/core';
import {Flight} from "../../../../shared/models/flight.model";
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {FormControl, FormGroup} from "@angular/forms";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
})
export class BookComponent implements OnInit {
  flights: Flight[] | undefined;

  formGroup = new FormGroup({
    from: new FormControl(),
    to: new FormControl(),
  });

  constructor(private backendApiService: BackendApiService) { }

  ngOnInit(): void {
    this.backendApiService.getFlights().subscribe(f => {
      this.flights = f;
    })
  }

  filter(): void {
    if (this.formGroup.get("from")?.value != null && this.formGroup.get("to")?.value != null) {
      this.backendApiService.getFlightsInTime(new DatePipe("en-US").transform(this.formGroup.get("from")?.value, "yyyy-MM-dd"),
        new DatePipe("en-US").transform(this.formGroup.get("to")?.value, "yyyy-MM-dd")).subscribe(res => {
        this.flights = res;
      });
    }
  }
}
