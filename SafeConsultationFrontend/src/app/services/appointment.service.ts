import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Appointment} from '../models/Appointment';
import {Patient} from '../models/Patient'

@Injectable({
  providedIn: 'root'
})

export class AppointmentService {

  constructor(private http:HttpClient) { }

  async createAppointment(appointment: Appointment):Promise<Appointment>{
      
    const appoint:Appointment = await this.http.post<Appointment>("http://localhost:8080/appointments", appointment).toPromise();
    return appoint;
  }

  async getAppointmentById(aid: number):Promise<Appointment>{
    const appoint:Appointment = await this.http.get<Appointment>(`http://localhost:8080/appointments/${aid}`).toPromise();
    return appoint;
  }


  async updateAppointment(appointment: Appointment):Promise<Appointment>{
    
    const appoint:Appointment = await this.http.put<Appointment>("http://localhost:8080/appointments",appointment).toPromise();
    return appoint;
  }
}
