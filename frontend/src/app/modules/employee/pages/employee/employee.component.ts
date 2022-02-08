import { Component, OnInit } from '@angular/core';
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {Employee} from "../../../../shared/models/employee.model";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: [ 'employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[] = [];
  displayedColumns: string[] = ["id", "email", "lastName", "firstName", "phoneNumber", "birthdate", "role", "socialSecurityNumber", "employeeNumber", "salary"/*, "isFlightAttendant"*/];

  constructor(private backendApiService: BackendApiService) {

  }

  ngOnInit(): void {
    this.backendApiService.getEmployees().subscribe(e => {
      this.employees = e;
      console.log(e)
    })
  }

  filter() {

  }

}
