import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from "./pages/book/book.component";
import {BookFlightComponent} from "./pages/book-flight/book-flight.component";

const routes: Routes = [
  {path: '', component: BookComponent},
  {path: ':id', component: BookFlightComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
