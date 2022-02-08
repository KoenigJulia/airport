import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AirplaneRoutingModule } from './airplane-routing.module';
import { AirplaneComponent } from './pages/airplane/airplane.component';


@NgModule({
  declarations: [
    AirplaneComponent
  ],
  imports: [
    CommonModule,
    AirplaneRoutingModule
  ]
})
export class AirplaneModule { }
