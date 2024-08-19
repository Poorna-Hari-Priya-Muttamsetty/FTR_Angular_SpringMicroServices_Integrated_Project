import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Workitem } from 'src/app/shared/Workitem';

@Injectable({
  providedIn: 'root'
})
export class WorkitemService {

  private workitemBaseUrl = "http://localhost:9994/FTR/workItems"

  constructor(private http: HttpClient) { }

  private handleError(error: HttpErrorResponse) {
    if (typeof error.error === 'string')
      return throwError(JSON.parse(error.error))
    return throwError(error.error);
  }

  public assignTerminal(workitemId: string, terminalId: string) {
    return this.http.post(`${this.workitemBaseUrl}/managed-terminal/` + workitemId + `/` + terminalId , { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  public allocateVehicle(workitemId: string, data: any) {
    return this.http.post(`${this.workitemBaseUrl}/managed-vehicle/` + workitemId, data , { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  public updateWorkitemStatus(workitemId: string, data: any) {
    return this.http.put(`${this.workitemBaseUrl}/managed-update/` + workitemId, data , { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  public fetchWorkitemsByVehicleNumber(vehicle_number: string) : Observable<Workitem>{
    return this.http.get<Workitem>(`${this.workitemBaseUrl}/managed-vehicle/` + vehicle_number ).pipe(
      catchError(this.handleError)
    );
  }

  public fetchWorkitemsByUser(user_id: number) :Observable<Workitem[]>{
    return this.http.get<Workitem[]>(`${this.workitemBaseUrl}/managed-user/` + user_id ).pipe(
      catchError(this.handleError)
    );
  }
  
  public fetchAllWorkitems() :Observable<Workitem[]>{
    return this.http.get<Workitem[]>(`${this.workitemBaseUrl}`).pipe(
      catchError(this.handleError)
    );
  }
}
