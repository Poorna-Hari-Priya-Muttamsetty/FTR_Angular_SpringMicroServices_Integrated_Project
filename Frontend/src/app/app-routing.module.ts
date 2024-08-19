import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { AdminComponent } from './components/admin/admin.component';
import { VehicleComponent } from './components/vehicle/vehicle.component';
import { TerminalComponent } from './components/terminal/terminal.component';
import { WorkitemComponent } from './components/workitem/workitem.component';

const routes: Routes = [
  { path: "admin-login", component: AdminLoginComponent},
  { path: "user-login", component: UserLoginComponent},
  { path: "register", component: RegisterComponent},
  { path: "home", component: HomeComponent },
  { path: "user", component: UserHomeComponent },
  { path: "admin", component: AdminComponent },
  { path: "vehicle", component: VehicleComponent },
  {path:"terminal" , component:TerminalComponent},
  {path:"workitem" , component:WorkitemComponent},
  { path: "**", redirectTo: "/home", pathMatch: "full" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
