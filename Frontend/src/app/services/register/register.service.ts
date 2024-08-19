import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  userBaseUrl = "http://localhost:9991/FTR/user"
  constructor(private http: HttpClient) { }

  register(user: any): Observable<string> {
    return this.http.post<string>(this.userBaseUrl, user,  { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );;
  }
  private handleError(error: HttpErrorResponse) {
    if (typeof error.error === 'string')
      return throwError(JSON.parse(error.error))
    return throwError(error.error)
  }
}
