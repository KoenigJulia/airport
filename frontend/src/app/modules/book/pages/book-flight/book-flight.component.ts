import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {Flight} from "../../../../shared/models/flight.model";

@Component({
  selector: 'app-book-flight',
  templateUrl: './book-flight.component.html',
})
export class BookFlightComponent implements OnInit {
  flight: Flight | null = null;

  constructor(private route: ActivatedRoute, private backendApiService: BackendApiService) { }

  ngOnInit(): void {
    this.backendApiService.getFlightById(Number.parseInt(<string>this.route.snapshot.paramMap.get("id"))).subscribe(res => {
      this.flight = res;

      this.backendApiService.getBookedSeats(this.flight.id).subscribe(res => {
        console.log(res);
      });
    });
  }

}
