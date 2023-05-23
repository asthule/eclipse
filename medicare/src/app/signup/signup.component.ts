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
export class SignupComponent implements OnInit {
  success = '';
  //@ts-ignore
  user: SignUpUser;
  constructor(
    private router: Router,
    public dialog: MatDialog,
    private userService: UserServices,
    private authService: AuthService
  ){}
  

  registerForm = new FormGroup(
    {
      username: new FormControl('', [Validators.required,]),
      email: new FormControl('', [Validators.required, Validators.email]),
      mobileNumber: new FormControl('', [
        Validators.required,
        Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')
      ]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
      ]),
      confirmPassword: new FormControl('', [Validators.required]),

    },

    
  );
  submitted = false;
  //@ts-ignore
  emailId: String;

  ngOnInit(): void {
      
  }
  get f(){
    return this.registerForm.controls
  }

  onSubmit(){
    this.submitted = true;
    if (this.registerForm.invalid){
      console.log('Invalid');
    }else {
      console.log('Valid'),
      this.user = this.userService.createUser(
        //@ts-ignore
        this.registerForm.value.username,
        this.registerForm.value.email,
        this.registerForm.value.password,
        this.registerForm.value.mobileNumber

      );

      this.openDialog();
      

      
      


      }
      
  }
  openDialog(): void {
    this.dialog.open(DialogAnimationsExampleDialog, {
      height: '300px',
      width: '320px',
      disableClose: true,

    });
  }



}

@Component ({
  selector: 'dialog-animations-example-dialog',
  templateUrl: 'dialog-animation-example-dialog.html',
  styleUrls: ['./signup.component.css'],
})

export class DialogAnimationsExampleDialog {
  constructor(
    public dialogRef: MatDialogRef<DialogAnimationsExampleDialog>,
    private router: Router
  ){}
  onRegister() {
    this.router.navigate(['/login']);
  }
}