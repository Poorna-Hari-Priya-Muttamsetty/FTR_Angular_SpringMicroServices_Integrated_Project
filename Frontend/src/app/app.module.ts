import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { TerminalComponent } from './components/terminal/terminal.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { VehicleComponent } from './components/vehicle/vehicle.component';
import { WorkitemComponent } from './components/workitem/workitem.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserLoginService } from './services/user-login/user-login.service';
import { AdminLoginService } from './services/admin-login/admin-login.service';
import { VehicleService } from './services/vehicle/vehicle.service';
import { TerminalService } from './services/terminal/terminal.service';
import { RegisterService } from './services/register/register.service';
import { WorkitemService } from './services/workitem/workitem.service';
import { UserHomeService } from './services/user-home/user-home.service';


@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    AdminComponent,
    HomeComponent,
    RegisterComponent,
    TerminalComponent,
    UserHomeComponent,
    UserLoginComponent,
    VehicleComponent,
    WorkitemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserLoginService,AdminLoginService,VehicleService,TerminalService,RegisterService,WorkitemService,UserHomeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
