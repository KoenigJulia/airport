import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PilotComponent} from "./pages/pilot/pilot.component";

const routes: Routes = [{path: '', component: PilotComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PilotRoutingModule { }
