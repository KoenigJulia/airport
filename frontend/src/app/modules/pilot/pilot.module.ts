import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PilotRoutingModule } from './pilot-routing.module';
import { PilotComponent } from './pages/pilot/pilot.component';
import {CoreModule} from "../../core/core.module";
import {MatTableModule} from "@angular/material/table";


@NgModule({
  declarations: [
    PilotComponent
  ],
  imports: [
    CommonModule,
    PilotRoutingModule,
    CoreModule,
    MatTableModule
  ]
})
export class PilotModule { }
