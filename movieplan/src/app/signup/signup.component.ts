import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SignUpUser } from '../models/signup-user.model';
import { CustomValidators } from 'ngx-custom-validators'; 
import { AuthService } from '../services/auth.service';
import { UserServices } from '../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  //@ts-ignore
registerForm: FormGroup<any>;
onSubmit: any;
f: any;
submitted: any;

}