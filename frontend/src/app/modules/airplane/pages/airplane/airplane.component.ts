import {Component, OnInit} from '@angular/core';
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {Airplane} from "../../../../shared/models/airplane.model";

@Component({
  selector: 'app-airplane',
  templateUrl: './airplane.component.html',
  styleUrls: ['airplane.component.scss']
})
export class AirplaneComponent implements OnInit {

  airplanes: Airplane[] = [];
  displayedColumns: string[] = ["id", "airplaneNr", "crewCnt", "fuelCapacity", "maxHeight", "maxSpeed", "seatColumns", "seatRows"];

  constructor(private backendApiService: BackendApiService) {

  }

  ngOnInit(): void {
    this.backendApiService.getAirplanes().subscribe(a => {
      this.airplanes = a;
    })
  }
}
