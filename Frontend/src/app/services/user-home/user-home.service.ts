import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Workitem } from '../../shared/Workitem';
import { UserLogin } from 'src/app/shared/UserLogin';

@Injectable({
  providedIn: 'root'
})
export class UserHomeService {
  constructor(private http: HttpClient) { }

  private userBaseUrl = "http://localhost:9991/FTR/user";

  postLogin(login: UserLogin): Observable<any> {
    return this.http.post(`${this.userBaseUrl}/login`, login, { responseType: 'text' });
  }

  emailId!: string;

  getProfileByEmailId(): Observable<UserProfile> {
    this.emailId = localStorage.getItem("user_name") ?? '';
    return this.http.get<UserProfile>(`${this.userBaseUrl}?emailId=` + this.emailId).pipe(
      catchError(this.handleError)
    );
  }
  private handleError(error: HttpErrorResponse) {
    if (typeof error.error === 'string')
      return throwError(JSON.parse(error.error))
    return throwError(error.error)
  }

  updateProfileByEmailId(userUpdateData: UpdateProfile): Observable<any> {
    this.emailId = localStorage.getItem("user_name") ?? '';
    return this.http.put<any>(`${this.userBaseUrl}?emailId=` + this.emailId, userUpdateData, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }
  deleteProfileByEmailId(): Observable<any> {
    this.emailId = localStorage.getItem("user_name") ?? '';
    return this.http.delete(`${this.userBaseUrl}?emailId=` + this.emailId, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }
  createWorkItem(data: any): Observable<Workitem> {
    return this.http.post<Workitem>(`${this.userBaseUrl}/createWorkItem`, data,).pipe(
      catchError(this.handleError)
    );
  }

  updateWorkItem(data: any) {
    return this.http.post(`${this.userBaseUrl}/updateWorkItem`, data, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  fetchAvailableharborLocations(country: any): Observable<any> {
    return this.http.get(`${this.userBaseUrl}/fetchAvailableharbor_locations/` + country).pipe(
      catchError(this.handleError)
    );
  }
}

interface UpdateProfile {
  mobile_number: number;
  permanent_address: string;
  office_address: string;
}

interface Login {
  user_name: number;
  password: string;
}

interface UserProfile {
  user_id: number;
  first_name: string;
  last_name: string;
  email_id: string;
  mobile_number: number;
  password: string;
  nationality: string;
  passport_number: string;
  permanent_address: string;
  office_address: string;
  personal_identification_number: number;
}