import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Terminal } from '../../shared/terminal';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TerminalService {

  private terminalBaseUrl = "http://localhost:9992/FTR/terminals";

  constructor(private http: HttpClient) { }

  public deleteTerminal(terminalId: number) {
    return this.http.delete(`${this.terminalBaseUrl}/` + terminalId, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }
  
  public insertTerminal(terminal: Terminal) {
    return this.http.post(`${this.terminalBaseUrl}`, terminal).pipe(
      catchError(this.handleError)
    );
  }

  public updateTerminal(terminalId: number, newCapacity: number) {
    return this.http.put(`${this.terminalBaseUrl}/` + terminalId + "/" + newCapacity, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  public updateTerminalStatus(terminalId: number, status: string) {
    return this.http.put(`${this.terminalBaseUrl}/` + terminalId + "?status=" + status, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (typeof error.error === 'string')
      return throwError(JSON.parse(error.error))
    return throwError(error.error);
  }

  public fetchTerminalById(terminalId: number) {
    return this.http.get(`${this.terminalBaseUrl}/fetchTerminalByTerminalId/` + terminalId).pipe(
      catchError(this.handleError)
    );
  }

  public fetchTerminalByType(itemType: string) {
    return this.http.get(`${this.terminalBaseUrl}/fetchTerminalsByItemType/` + itemType).pipe(
      catchError(this.handleError)
    );
  }

  public fetchFTRTerminals() {
    return this.http.get(`${this.terminalBaseUrl}`).pipe(
      catchError(this.handleError)
    );
  }
}
