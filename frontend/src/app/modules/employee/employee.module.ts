import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './pages/employee/employee.component';
import {MatTableModule} from "@angular/material/table";
import {CoreModule} from "../../core/core.module";


@NgModule({
  declarations: [
    EmployeeComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    MatTableModule,
    CoreModule
  ]
})
export class EmployeeModule { }
