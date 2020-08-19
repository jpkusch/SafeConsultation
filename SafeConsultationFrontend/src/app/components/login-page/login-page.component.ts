import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Patient } from 'src/app/models/Patient';
import { Login } from 'src/app/models/Login';
import { Doctor } from 'src/app/models/Doctor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit(): void {
  }

  showSignUp:boolean = false;
  userType:string = "patient";

  username:string;
  password:string;

  //patient info
  age:number;
  weight:number;
  height:number;
  bloodType:string;

  //doctor info
  specialty:string;

  async patientLogIn(){
    if(this.username && this.password){
      let login:Login = new Login(this.username, this.password);
      await this.loginService.patientLogIn(login);
      if(this.loginService.patientUser != null){
        this.router.navigateByUrl('/patient');
      }
      alert("Either the username or password is incorrect. Please try again.");
    }
    alert("Please ensure the username and password fields are correctly fill out.")
  }

  async doctorLogIn(){
    if(this.username && this.password){
      let login:Login = new Login(this.username, this.password);
      await this.loginService.doctorLogIn(login);
      if(this.loginService.doctorUser != null){
        this.router.navigateByUrl('/doctor');
      }
      alert("Either the username or password is incorrect. Please try again.");
    }
    alert("Please ensure the username and password fields are correctly fill out.")
  }

  async patientSignUp(){
    if((this.username && this.username.length >= 6) && (this.password && this.password.length >= 6) && (this.age && this.age >= 0)){
      let patient:Patient = new Patient(0, this.username, this.password, this.age, this.weight, this.height, this.bloodType, []);
      await this.loginService.patientSignUp(patient);
      if(this.loginService.patientUser != null){
        this.router.navigateByUrl('/patient');
      }
      alert("Either the username or password is already taken. Please try again.");
    }
    alert("Please ensure the username and password are at least 6 characters and the age is greater than 0.")
  }

  async doctorSignUp(){
    if((this.username && this.username.length >= 6) && (this.password && this.password.length >= 6) && (this.specialty && this.specialty.length >= 0)){
      let doctor:Doctor = new Doctor(0, this.username, this.password, this.specialty, []);
      await this.loginService.doctorSignUp(doctor);
      if(this.loginService.doctorUser != null){
        this.router.navigateByUrl('/doctor');
      }
      alert("Either the username or password is already taken. Please try again.");
    }
    alert("Please ensure the username and password are at least 6 characters and the specialty is at least 3 characters.")
  }

  manageSignUp(){
    if(this.userType === 'doctor'){
      this.doctorSignUp();
    } else{
      this.patientSignUp();
    }
  }

  manageLogIn(){
    if(this.userType === 'doctor'){
      this.doctorLogIn();
    } else{
      this.patientLogIn();
    }
  }

  switchPage(){
    this.showSignUp = !this.showSignUp;
  }

}
