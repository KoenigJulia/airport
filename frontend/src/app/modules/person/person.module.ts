import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PersonRoutingModule } from './person-routing.module';
import { PersonComponent } from './pages/person/person.component';
import {CoreModule} from "../../core/core.module";
import {MatTableModule} from "@angular/material/table";


@NgModule({
  declarations: [
    PersonComponent
  ],
  imports: [
    CommonModule,
    PersonRoutingModule,
    CoreModule,
    MatTableModule
  ]
})
export class PersonModule { }
