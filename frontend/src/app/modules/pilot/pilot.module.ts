import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PilotRoutingModule } from './pilot-routing.module';
import { PilotComponent } from './pages/pilot/pilot.component';


@NgModule({
  declarations: [
    PilotComponent
  ],
  imports: [
    CommonModule,
    PilotRoutingModule
  ]
})
export class PilotModule { }
