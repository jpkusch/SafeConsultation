import { Injectable } from '@angular/core';
import { Doctor } from '../models/Doctor';
import { Appointment } from '../models/Appointment';
import { Patient } from '../models/Patient';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private httpClient: HttpClient) { }

  async createDoctor(doctorIn: Doctor): Promise<Doctor> {
    const url: string = 'http://ec2-3-131-82-174.us-east-2.compute.amazonaws.com:8080/doctors';
    const doctor: Doctor = await this.httpClient.post<Doctor>(url, JSON.stringify(doctorIn)).toPromise();
    return doctor;
  }

  async getDoctorById(did: number): Promise<Doctor> {
    const url: string = `http://ec2-3-131-82-174.us-east-2.compute.amazonaws.com:8080/doctors/${did}`;
    const doctor: Doctor = await this.httpClient.get<Doctor>(url).toPromise();
    return doctor;
  }

  async getAllDoctors(): Promise<Doctor[]> {
    const url: string = 'http://ec2-3-131-82-174.us-east-2.compute.amazonaws.com:8080/doctors';
    const doctors: Doctor[] = await this.httpClient.get<Doctor[]>(url).toPromise();
    return doctors;
  }

  async updateDoctor(doctorIn: Doctor): Promise<Doctor> {
    const url: string = 'http://ec2-3-131-82-174.us-east-2.compute.amazonaws.com:8080/doctors';
    const doctor: Doctor = await this.httpClient.put<Doctor>(url, JSON.stringify(doctorIn)).toPromise();
    return doctor;
  }

  async getPatientsByDoctor(did: number): Promise<Patient[]> {
    const url: string = `http://ec2-3-131-82-174.us-east-2.compute.amazonaws.com:8080/doctors/${did}/patients`;
    const patients: Patient[] = await this.httpClient.get<Patient[]>(url).toPromise();
    return patients;
  }

  async getAppointmentsByDoctor(did: number): Promise<Appointment[]> {
    const url: string = `http://ec2-3-131-82-174.us-east-2.compute.amazonaws.com:8080/doctors/${did}/appointments`;
    const appointments: Appointment[] = await this.httpClient.get<Appointment[]>(url).toPromise();
    return appointments;
  }
}
