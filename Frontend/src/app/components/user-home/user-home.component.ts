import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Workitem } from '../../shared/Workitem';
import { UserHomeService } from 'src/app/services/user-home/user-home.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  userDetails!: UserProfile
  userUpdateForm!: FormGroup;
  userWorkitem!: boolean;
  viewUserProfile!: boolean;
  user_name!: string;
  successMessage!: string;
  errorMessage!: string;
  updateUserProfile!: boolean;
  createUserDisplay!: boolean;
  deleteUserProfile!: boolean;
  createWorkItem!: boolean;
  showInsertForm!: boolean;
  updateWorkItem!: boolean;
  fetchAvailableHarborLocations!: boolean;
  workitem: Workitem = new Workitem("", 0, "", "", "", "", "", "", "", "", new Date(), 0);
  showInsertedDetails!: boolean;
  workItemDetails!: any;
  availableHarborLocations!: any;
  country!: string;

  constructor(private userHomeService: UserHomeService,
    private router: Router,
    private formBuilder: FormBuilder) {

  }

  reset() {
    this.userUpdateForm.reset();
    this.userWorkitem = false;
    this.viewUserProfile = false;
    this.user_name = '';
    this.successMessage = '';
    this.errorMessage = '';
    this.updateUserProfile = false;
    this.createUserDisplay = false;
    this.deleteUserProfile = false;
    this.createWorkItem = false
    this.updateWorkItem = false;
    this.showInsertForm = false;
    this.fetchAvailableHarborLocations = false;
    this.showInsertedDetails = false;
    this.workItemDetails = '';
    this.availableHarborLocations = '';
  }

  ngOnInit(): void {
    this.user_name = localStorage.getItem('user_name') ?? '';
    this.userUpdateForm = this.formBuilder.group({
      mobileNumber: ['', [Validators.required, Validators.pattern("[0-9]{10}")]],
      permanent_address: ['', [Validators.required, Validators.maxLength(200)]],
      office_address: ['', [Validators.required, Validators.maxLength(200)]]
    });
  }

  createUserIcon() {
    this.createUserDisplay = true;
    this.router.navigate(['/register']);
  }
  viewUserIcon() {
    this.reset();
    this.viewUserProfile = true;
    this.viewUserNow();
  }

  updateUserIcon() {
    this.reset();
    this.updateUserProfile = true;
  }

  deleteUserIcon() {
    this.reset();
    this.deleteUserProfile = true;
    this.deleteUserNow();
  }
  createWorkitemIcon() {
    this.reset();
    this.createWorkItem = true;
    this.showInsertForm = true;
  }
  updateWorkitemIcon() {
    this.reset();
    this.updateWorkItem = true;
  }
  fetchAvailableHarborLocationsIcon() {
    this.reset();
    this.fetchAvailableHarborLocations = true;
  }

  viewUserNow() {
    this.userHomeService.getProfileByEmailId().subscribe({
      next: (response) => {
        this.viewUserProfile = true;
        this.userDetails = response ?? '';
      },
      error: (error) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  updateUserNow(mobile: any, permanent_address: any, office_address: any) {
    this.userHomeService.updateProfileByEmailId({ 'mobile_number': mobile, 'permanent_address': permanent_address, 'office_address': office_address }).subscribe({
      next: (response) => {
        console.log(response)
        console.log(this.successMessage)
        this.successMessage = response ?? '';
      },
      error: (error) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  backToProfile() {
    this.updateUserProfile = false;
    this.viewUserIcon();
  }

  deleteUserNow() {
    if (confirm("Are you sure you want to delete your profile? ")) {
      this.userHomeService.deleteProfileByEmailId().subscribe({
        next: (response) => {
          this.successMessage = response ?? '';
          this.router.navigate(['/home']);
          localStorage.removeItem('user_name');
        },
        error: (error) => {
          this.errorMessage = error.message ?? '';
        }
      });
    }
  }

  createWorkitemNow() {
    this.userHomeService.createWorkItem(this.workitem).subscribe({
      next: (response) => {
        this.showInsertForm = false;
        this.showInsertedDetails = true;
        this.workItemDetails = response ?? '';
      },
      error: (error) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  updateWorkitemNow() {
    this.userHomeService.updateWorkItem(this.workitem).subscribe({
      next: (response) => {
        this.viewUserProfile = true;
        this.workItemDetails = response ?? '';
      },
      error: (error) => {
        this.errorMessage = error.message ?? '';
      }
    });
  }

  fetchAvailableHarborLocationsNow() {
    this.userHomeService.fetchAvailableharborLocations(this.country).subscribe({
      next: (response) => {
        this.availableHarborLocations = response ?? '';
      },
      error: (error) => {
        console.log(typeof error);
        this.errorMessage = 'Workitem details not found for given workitem id';
      }
    });
  }

  goBack() {
    window.history.back();
  }

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
