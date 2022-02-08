import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import { BookComponent } from './pages/book/book.component';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatSelectModule } from "@angular/material/select";
import {MatNativeDateModule} from "@angular/material/core";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {CoreModule} from "../../core/core.module";
import {ReactiveFormsModule} from "@angular/forms";
import {BookFlightComponent} from "./pages/book-flight/book-flight.component";


@NgModule({
  declarations: [
    BookComponent,
    BookFlightComponent
  ],
  imports: [
    CommonModule,
    BookRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatCardModule,
    MatButtonModule,
    CoreModule,
    ReactiveFormsModule,
  ]
})
export class BookModule { }
