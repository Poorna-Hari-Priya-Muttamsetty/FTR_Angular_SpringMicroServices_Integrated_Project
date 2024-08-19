import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Vehicle } from '../../shared/Vehicle';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { VehicleService } from 'src/app/services/vehicle/vehicle.service';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  nameif: boolean = false;
  insertif: boolean = false;
  numif: boolean = false;
  deleteif: boolean = false;
  showVehiclesDetails: boolean = false;
  tableToggle: boolean = false;
  vehicles!: Vehicle[];
  vehicle!: Vehicle;
  successMessage!: string;
  errorMessage!: any;
  insertForm!: FormGroup;
  nameForm!: FormGroup;
  numberForm!: FormGroup;
  deleteForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private vehicleService: VehicleService
  ) { }

  reset(): void {
    this.insertForm.reset();
    this.nameForm.reset();
    this.numberForm.reset();
    this.deleteForm.reset();
    this.errorMessage = null;
    this.successMessage = '';
    this.tableToggle = false;
    this.vehicles = [];
    this.vehicle = {} as Vehicle;
    this.showVehiclesDetails = false;
    this.insertif = false;
    this.nameif = false;
    this.numif = false;
    this.deleteif = false;
  }

  clickInsert(): void {
    this.reset();
    this.insertif = !this.insertif;
  }

  clickAll(): void {
    this.reset();
    this.vehicleService.getVehicles().subscribe({
      next: (response: any) => {
        this.vehicles = response;
        this.showVehiclesDetails = !this.showVehiclesDetails;
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message;
      }
    });
  }

  clickName(): void {
    this.reset();
    this.nameif = !this.nameif;
  }

  clickNumber(): void {
    this.reset();
    this.numif = !this.numif;
  }

  clickDelete(): void {
    this.reset();
    this.deleteif = !this.deleteif;
  }

  insert(): void {
    this.vehicleService.insert(this.insertForm.value).subscribe({
      next: (response: any) => {
        this.successMessage = response;
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message;
      }
    });
  }

  getByName() {
    this.vehicleService.getByName(this.nameForm.value).subscribe({
      next: (response: any) => {
        this.vehicles = response ?? '';
        this.tableToggle = !this.tableToggle;
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  getByNumber() {
    this.vehicleService.getByNum(this.numberForm.value).subscribe({
      next: (response: any) => {
        this.vehicle = response ?? '';
        this.tableToggle = !this.tableToggle;
      },
      error: (error: any) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  delete() {
    this.vehicleService.delete(this.deleteForm.value).subscribe({
      next: (response: any) => {
        this.successMessage = response ?? '';
      },
      error: (error: any) => {
        this.errorMessage = error.message;
      }
    });
  }

  ngOnInit(): void {
    this.insertForm = this.formBuilder.group({
      vehicle_number: ["", [Validators.required, Validators.pattern("[A-Z]{2}[0-9]{4}")]],
      vehicle_name: ["", [Validators.required]],
      max_lifting_capacity: ["", [Validators.required, Validators.pattern("([0-9]+.?)+")]],
      retire_date: ["", [Validators.required]],
      vehicle_status: ["", [Validators.required]],
      harbor_location: ["", [Validators.required]],
      country: ["", [Validators.required]],
    });

    this.nameForm = this.formBuilder.group({
      vehicle_name: ["", [Validators.required]]
    });

    this.numberForm = this.formBuilder.group({
      vehicle_number: ["", [Validators.required, Validators.pattern("[A-Z]{2}[0-9]{4}")]]
    });
    this.deleteForm = this.formBuilder.group({
      vehicle_number: ["", [Validators.required, Validators.pattern("[A-Z]{2}[0-9]{4}")]]
    });
  }

  goBack() {
    window.history.back();
  }

}
