import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserLoginService } from '../../services/user-login/user-login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  message: string = "Logged in successfully.";
  submit!: boolean;
  errorMsg!: string;
  loginForm!: FormGroup;
  errorif!: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userLoginService: UserLoginService
  ) { }

  login(): void {
    this.submit = true;
    this.userLoginService.login(this.loginForm.value).subscribe({
      next: (response) => {
        this.errorif = false;
        this.router.navigate(["/user"]);
      },
      error: (error) => {
        this.errorif = true;
        this.errorMsg = error.message;
        this.submit = false;
      }
    });
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      user_name: ["", Validators.required,],
      password: ["", Validators.required],
    });
  }
}
