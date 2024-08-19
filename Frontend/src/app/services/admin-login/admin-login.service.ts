import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AdminLogin } from '../../shared/AdminLogin';
@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {

  adminName = '';

  constructor(private http: HttpClient) { }

  adminlogin(): Observable<any> {
    return this.http.get<AdminLogin[]>('./assets/admin/admin.json')
  }
}
