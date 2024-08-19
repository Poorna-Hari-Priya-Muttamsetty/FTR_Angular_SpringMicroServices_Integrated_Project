import { Injectable } from '@angular/core';
import { UserLogin } from '../../shared/UserLogin';
import { catchError, Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  private userBaseUrl = "http://localhost:9991/FTR/user"

  constructor(private http: HttpClient) { }

  login(data: UserLogin): Observable<any> {
    localStorage.setItem('user_name', data.user_name.toString());
    return this.http.post(`${this.userBaseUrl}/login`, data, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (typeof error.error === 'string')
      return throwError(JSON.parse(error.error))
    return throwError(error.error)
  }
}
