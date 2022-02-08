import {Component, OnInit, ViewChild} from '@angular/core';
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {Person} from "../../../../shared/models/person.model";

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.scss']
})
export class PersonComponent implements OnInit {

  persons: Person[] = [];
  displayedColumns: string[] = ["id", "email", "lastName", "firstName", "phoneNumber", "birthdate", "role", "socialSecurityNumber"];

  constructor(private backendApiService: BackendApiService) {

  }

  ngOnInit(): void {
    this.backendApiService.getPersons().subscribe(p => {
      this.persons = p;
    })
  }

  filter() {

  }
}
