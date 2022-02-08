import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TicketRoutingModule } from './ticket-routing.module';
import { TicketComponent } from './pages/ticket/ticket.component';
import {MatTableModule} from "@angular/material/table";
import {CoreModule} from "../../core/core.module";


@NgModule({
  declarations: [
    TicketComponent
  ],
  imports: [
    CommonModule,
    TicketRoutingModule,
    MatTableModule,
    CoreModule
  ]
})
export class TicketModule { }
