import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../models/Patient';
import { Appointment } from '../models/Appointment';
import { Login } from '../models/Login'

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http:HttpClient) { }

  async createPatient(patientIn:Patient):Promise<Patient>{
    
    const patient:Patient = await this.http.post<Patient>("http://localhost:8080/patients", patientIn).toPromise();
    return patient;
  }

  async getPatientById(pid:number):Promise<Patient>{

    const patient:Patient = await this.http.get<Patient>(`http://localhost:8080/patients/${pid}`).toPromise();
    return patient;
  }

  async getAppointmentsByPatient(pid:number):Promise<Array<Appointment>>{
    
    const appointments:Array<Appointment> = await this.http.get<Array<Appointment>>(`http://localhost:8080/patients/${pid}/appointments`).toPromise();
    return appointments;
  }

  async updatePatient(patientIn:Patient):Promise<Patient>{

    const patient:Patient = await this.http.put<Patient>("http://localhost:8080/patients", patientIn).toPromise();
    return patient;
  }

  async logInPatient(dto:Login):Promise<Patient>{

    const patient:Patient = await this.http.post<Patient>("http://localhost:8080/patients/login", dto).toPromise();
    return patient;
  }
}
