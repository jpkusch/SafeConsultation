import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/Login';
import { Patient } from '../models/Patient';
import { Doctor } from '../models/Doctor';
import { CookieService} from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  patientUser:Patient = null;
  doctorUser:Doctor = null;

  constructor(private http:HttpClient) { 
  }

  async patientLogIn(login:Login){
    const patient:Patient = await this.http.post<Patient>(`http://localhost:8080/patients/login`, login).toPromise();
    this.patientUser = patient;
    this.doctorUser = null;
  }

  async patientSignUp(patient:Patient){
    patient = await this.http.post<Patient>(`http://localhost:8080/patients`, patient).toPromise();
    this.patientUser = patient;
    this.doctorUser = null;
  }

  async doctorLogIn(login:Login){
    const doctor:Doctor = await this.http.post<Doctor>(`http://localhost:8080/doctors/login`, login).toPromise();
    this.doctorUser = doctor;
    this.patientUser = null;
  }

  async doctorSignUp(doctor:Doctor){
    doctor = await this.http.post<Doctor>(`http://localhost:8080/doctors`,doctor).toPromise();
    this.doctorUser = doctor;
    this.patientUser = null;
  }

  logout(){
    this.doctorUser = null;
    this.patientUser = null;
  }
}
