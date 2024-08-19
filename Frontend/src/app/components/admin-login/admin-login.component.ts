import { Component } from '@angular/core';
import { AdminLogin } from '../../shared/AdminLogin';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/services/admin-login/admin-login.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  login = new AdminLogin();
  users: AdminLogin[] = [];

  errorMsg!: string;
  loginForm!: FormGroup;
  errorif!: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private adminLoginService: AdminLoginService
  ) { }

  onSubmit(): void {

    this.login = this.loginForm.getRawValue();
    const name = this.login.adminName;
    this.adminLoginService.adminName = this.login.adminName;
    const password = this.login.password;
    const user = this.users.filter(currentUser => currentUser.adminName === name && currentUser.password === password)[0];
    if (user) {
      this.router.navigate(['/admin']);
    } else {
      this.errorif = true;
      this.errorMsg = "Invalid user ID/password" ?? '';
    }
  }

  ngOnInit(): void {

    this.adminLoginService.adminlogin().subscribe(
      (users: AdminLogin[]) => this.users = users);

    this.loginForm = this.formBuilder.group({
      adminName: ["", Validators.required],
      password: ["", Validators.required],
    });

  }
}
