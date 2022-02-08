import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/shared/models/ticket.model';
import {BackendApiService} from "../../../../core/services/backend-api.service";

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['ticket.component.scss']
})
export class TicketComponent implements OnInit {

  tickets: Ticket[] = [];

  displayedColumns: string[] = ["id", "flightId", "luggageId", "personId", "price", "seatNumber", "seatType", "travelClass"];

  constructor(private backendApiService: BackendApiService) {

  }

  ngOnInit(): void {
    this.backendApiService.getTickets().subscribe(t => {
      this.tickets = t;
    })
  }

  getLuggageString(ticket:Ticket) {
    return ticket.luggage.map(t => t.id)
  }
}
