import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AirplaneRoutingModule } from './airplane-routing.module';
import { AirplaneComponent } from './pages/airplane/airplane.component';
import {MatTableModule} from "@angular/material/table";
import {CoreModule} from "../../core/core.module";


@NgModule({
  declarations: [
    AirplaneComponent
  ],
  imports: [
    CommonModule,
    AirplaneRoutingModule,
    MatTableModule,
    CoreModule
  ]
})
export class AirplaneModule { }
