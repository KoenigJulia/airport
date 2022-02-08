import { Component, OnInit } from '@angular/core';
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {Pilot} from "../../../../shared/models/pilot.model";

@Component({
  selector: 'app-pilot',
  templateUrl: './pilot.component.html',
  styleUrls: ['pilot.component.scss']
})
export class PilotComponent implements OnInit {

  pilots: Pilot[] = [];
  displayedColumns: string[] = ["id", "email", "lastName", "firstName", "phoneNumber", "birthdate", "role", "socialSecurityNumber", "employeeNumber", "salary"/*, "isFlightAttendant"*/, "extraPayment", "pilotNumber"];

  constructor(private backendApiService: BackendApiService) {

  }

  ngOnInit(): void {
    this.backendApiService.getPilots().subscribe(p => {
      this.pilots = p;
    })
  }

}
