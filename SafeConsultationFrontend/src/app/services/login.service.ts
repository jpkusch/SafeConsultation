import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/Login';
import { Patient } from '../models/Patient';
import { Doctor } from '../models/Doctor';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  patientUser:Patient = null;
  doctorUser:Doctor = null;

  async patientLogIn(login:Login){
    const patient:Patient = await this.http.post<Patient>(`http://localhost:8080/patients/login`, login).toPromise();
    this.patientUser = patient;
  }

  async patientSignUp(patient:Patient){
    patient = await this.http.post<Patient>(`http://localhost:8080/patients`, patient).toPromise();
    this.patientUser = patient;
  }

  async doctorLogIn(login:Login){
    const doctor:Doctor = await this.http.post<Doctor>(`http://localhost:8080/doctors/login`,login).toPromise();
    this.doctorUser = doctor;
  }

  async doctorSignUp(doctor:Doctor){
    doctor = await this.http.post<Doctor>(`http://localhost:8080/doctors/login`,doctor).toPromise();
    this.doctorUser = doctor;
  }
}
