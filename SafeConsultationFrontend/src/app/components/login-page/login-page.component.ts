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
  isDoctor:boolean = false;
  userType:string = "patient";

  username:string;
  password:string;

  //patient info
  age:number;
  weight:number;
  height:number;
  bloodType:string;

  //doctor info
  specialy:string;

  async patientLogIn(){
    let login:Login = new Login(this.username, this.password);
    await this.loginService.patientLogIn(login);
    this.router.navigateByUrl('/patient');
  }

  async doctorLogIn(){
    let login:Login = new Login(this.username, this.password);
    await this.loginService.doctorLogIn(login);
    this.router.navigateByUrl('/doctor');
  }

  async patientSignUp(){
    let patient:Patient = new Patient(0, this.username, this.password, this.age, this.weight, this.height, this.bloodType, []);
    this.loginService.patientSignUp(patient);
    this.router.navigateByUrl('/patient');
  }

  async doctorSignUp(){
    let doctor:Doctor = new Doctor(0, this.username, this.password, this.specialy, []);
    this.loginService.doctorSignUp(doctor);
    this.router.navigateByUrl('/doctor');
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
