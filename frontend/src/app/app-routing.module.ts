import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./core/guards/auth.guard";
import {PageNotFoundComponent} from "./shared/components/page-not-found/page-not-found.component";

const routes: Routes = [
  {
    path: "",
    canActivateChild: [AuthGuard],
    children: [
      {
        path: "",
        redirectTo: "/home",
        pathMatch: "full"
      },
      {
        path: 'book',
        loadChildren: () => import('./modules/book/book.module').then(m => m.BookModule)
      },
      {
        path: 'person',
        loadChildren: () => import('./modules/person/person.module').then(m => m.PersonModule)
      },
      {
        path: 'employee',
        loadChildren: () => import('./modules/employee/employee.module').then(m => m.EmployeeModule)
      },
      {
        path: 'pilot',
        loadChildren: () => import('./modules/pilot/pilot.module').then(m => m.PilotModule)
      },
      {
        path: 'airplane',
        loadChildren: () => import('./modules/airplane/airplane.module').then(m => m.AirplaneModule)
      },
      {
        path: 'ticket',
        loadChildren: () => import('./modules/ticket/ticket.module').then(m => m.TicketModule)
      }
    ]
  },
  {
    path: "login",
    loadChildren: () => import("./modules/login/login.module").then(m => m.LoginModule)
  },
  {
    path: "home",
    loadChildren: () => import("./modules/home/home.module").then(m => m.HomeModule)
  },
  {
    path: "**",
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
      preloadingStrategy: PreloadAllModules,
      relativeLinkResolution: 'legacy'
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
