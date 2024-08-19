import { Component } from '@angular/core';
import { Workitem } from '../../shared/Workitem';
import { WorkitemTerminal } from '../../shared/WorkitemTerminal';
import { WorkitemVehicle } from '../../shared/WorkitemVehicle';
import { HttpErrorResponse } from '@angular/common/http';
import { Vehicle } from '../../shared/Vehicle';
import { Terminal } from '../../shared/terminal';
import { WorkitemService } from 'src/app/services/workitem/workitem.service';

@Component({
  selector: 'app-workitem',
  templateUrl: './workitem.component.html',
  styleUrls: ['./workitem.component.css']
})
export class WorkitemComponent {
  constructor(private service: WorkitemService) { }

  workitem: Workitem = new Workitem("",0,"","","","","","","","",new Date(),0);
  workitemTerminal : WorkitemTerminal = new WorkitemTerminal("","");
  workitemVehicle : WorkitemVehicle = new WorkitemVehicle("","","","");
  vehicle : Vehicle = new Vehicle("","",0,new Date(),"","","");
  terminal : Terminal = new Terminal(0, "", "", "", "", 0, "", "", 0);

  workitemDetails!: Workitem;
  workitems!: Workitem[];
  successMessage: any;
  errorMessage: any;
  showWorkitem: any;
  assignTerminal!: boolean;
  allocateVehicle!: boolean;
  updateWorkitemStatus!: boolean;
  fetchWorkitemsByVehicleNumber!: boolean;
  fetchWorkitemsByUser!: boolean;
  fetchAllWorkitems!: boolean;
  showFetchAllWorkitems!: boolean;
  ShowFetchWorkitemsByUser!: boolean;
  showFetchWorkitemsByVehicleNumber!: boolean;

  ngOnInit(): void {
  }

  reset(): void {
    this.successMessage = null;
    this.errorMessage = null;
    this.showWorkitem = null;
    this.assignTerminal = false;
    this.allocateVehicle = false;
    this.updateWorkitemStatus = false;
    this.fetchWorkitemsByVehicleNumber = false;
    this.fetchWorkitemsByUser = false;
    this.fetchAllWorkitems = false;
    this.showFetchAllWorkitems = false;
    this.ShowFetchWorkitemsByUser = false;
    this.showFetchWorkitemsByVehicleNumber = false;
  }

  public assignTerminalIcon() {
    this.reset();
    this.assignTerminal = true;
  }

  public allocateVehicleIcon() {
    this.reset()
    this.allocateVehicle = true;
  }

  public updateWorkitemStatusIcon() {
    this.reset();
    this.updateWorkitemStatus = true;
  }

  public fetchWorkitemsByVehicleNumberIcon() {
    this.reset();
    this.fetchWorkitemsByVehicleNumber = true;
  }

  public fetchWorkitemsByUserIcon() {
    this.reset()
    this.fetchWorkitemsByUser = true;
  }

  public fetchAllWorkitemsIcon() {
    this.reset();
    this.fetchAllWorkitems = true;
    this.fetchAllWorkitemsNow();
  }

  public assignTerminalNow() {
    this.service.assignTerminal(this.workitem.workitem_id,this.workitemTerminal.terminal_id).subscribe({
      next: (response: any) => {
        this.successMessage = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public allocateVehicleNow() {
    this.service.allocateVehicle(this.workitem.workitem_id, this.vehicle).subscribe({
      next: (response: any) => {
        this.successMessage = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public updateWorkitemStatusNow() {
    this.service.updateWorkitemStatus(this.workitem.workitem_id, this.terminal).subscribe({
      next: (response: any) => {
        this.successMessage = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public fetchWorkitemsByVehicleNumberNow() {
    this.showFetchWorkitemsByVehicleNumber = true;
    this.service.fetchWorkitemsByVehicleNumber(this.workitemVehicle.vehicle_number).subscribe({
      next: (response: any) => {
        this.workitemDetails = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public fetchWorkitemsByUserNow() {
    this.ShowFetchWorkitemsByUser = true;
    this.service.fetchWorkitemsByUser(this.workitem.user_id).subscribe({
      next: (response: any) => {
        this.workitems = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  public fetchAllWorkitemsNow() {
    this.service.fetchAllWorkitems().subscribe({
      next: (response: any) => {
        this.workitems = response ?? '';
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  goBack() {
    window.history.back();
  }
}
