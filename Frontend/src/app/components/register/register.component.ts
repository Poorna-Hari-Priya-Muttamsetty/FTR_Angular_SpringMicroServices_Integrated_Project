import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegisterService } from '../../services/register/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  formDisplay: boolean = true;
  successMessage!: string;
  errorMessage!: string;

  constructor(private formBuilder: FormBuilder, private registerService: RegisterService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.maxLength(20)]],
      lastName: ['', [Validators.required, Validators.maxLength(20)]],
      emailId: ['', [Validators.required, Validators.email]],
      mobileNumber: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(12), Validators.pattern("[A-z0-9]*[!@#$%^&*()_+:;><]+[A-z0-9]*")]],
      nationality: ['', [Validators.required, Validators.maxLength(20)]],
      passportNumber: ['', [Validators.required, Validators.minLength(7), Validators.maxLength(12)]],
      permanentAddress: ['', [Validators.required, Validators.maxLength(200)]],
      officeAddress: ['', [Validators.required, Validators.maxLength(200)]],
      personalIdentificationNumber: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(12)]]
    })
  }

  register() {
    let userData = {
      "email_id": this.registerForm.controls['emailId'].value,
      "first_name": this.registerForm.controls['firstName'].value,
      "last_name": this.registerForm.controls['lastName'].value,
      "mobile_number": this.registerForm.controls['mobileNumber'].value,
      "nationality": this.registerForm.controls['nationality'].value,
      "office_address": this.registerForm.controls['officeAddress'].value,
      "passport_number": this.registerForm.controls['passportNumber'].value,
      "password": this.registerForm.controls['password'].value,
      "permanent_address": this.registerForm.controls['permanentAddress'].value,
      "personal_identification_number": this.registerForm.controls['personalIdentificationNumber'].value
    }

    this.registerService.register(userData).subscribe({
      next: (response) => {
        this.successMessage = response ?? '';
        this.formDisplay = false;
        this.registerForm.reset();
      },
      error: (error) => {
        this.errorMessage = error.message?? '';
      }
    });
  }

  goBack() {
    window.history.back();
  }

}
