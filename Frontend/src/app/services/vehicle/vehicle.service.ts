import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Vehicle } from '../../shared/Vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private vehicleBaseUrl = "http://localhost:9993/FTR/vehicles"
  constructor(private http: HttpClient) { }

  insert(data: Vehicle): Observable<any> {
    return this.http.post(`${this.vehicleBaseUrl}`, data, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }
  private handleError(error: HttpErrorResponse) {
    if (typeof error.error === 'string')
      return throwError(JSON.parse(error.error))
    return throwError(error.error)
  }

  getVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${this.vehicleBaseUrl}`).pipe(
      catchError(this.handleError)
    );
  }

  getByName(data: Vehicle): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${this.vehicleBaseUrl}/managed-name?vehicle_name=` + data.vehicle_name).pipe(
      catchError(this.handleError)
    );
  }

  getByNum(data: Vehicle): Observable<Vehicle> {
    console.log(data)
    console.log(data.vehicle_number);
    return this.http.get<Vehicle>(`${this.vehicleBaseUrl}/managed-number?vehicle_number=` + data.vehicle_number).pipe(
      catchError(this.handleError)
    );
  }

  delete(data: Vehicle): Observable<string> {
    return this.http.delete<string>(`${this.vehicleBaseUrl}/` + data.vehicle_number, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

}
