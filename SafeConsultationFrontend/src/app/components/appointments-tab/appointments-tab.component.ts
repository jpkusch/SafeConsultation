import { Component, OnInit } from '@angular/core';
import { LoginService } from './../../services/login.service';
import { DoctorService } from './../../services/doctor.service';
import { PatientService } from './../../services/patient.service';
import { Patient } from './../../models/Patient';
import { Doctor } from './../../models/Doctor';
import { Appointment } from './../../models/Appointment';
import { HttpClient } from '@angular/common/http';
import {ViewMoreComponent} from '../view-more/view-more.component'

@Component({
  selector: 'app-appointments-tab',
  templateUrl: './appointments-tab.component.html',
  styleUrls: ['./appointments-tab.component.css']
})
export class AppointmentsTabComponent implements OnInit {

  doctorView:boolean;
  patientView:boolean;
  appointments:Array<Appointment> = [];
  patients:Array<Patient> = [];
  doctors:Array<Doctor> = [];
  loginDoctor:Doctor =null;
  loginPatient:Patient = null;

  constructor(private httpClient: HttpClient, private loginService:LoginService, private doctorService:DoctorService, private patientService:PatientService) {

   }

  async ngOnInit(): Promise<void> {
    await this.getLoginDoctor();
    await this.getLoginPatient();

    if(this.loginDoctor===null){
      await this.getDoctorByPatient();
    }
    else{
      await this.getPatientsByDoctor();
    }

  }
  
  async getLoginDoctor(){
     this.loginDoctor = await this.loginService.doctorUser;
  }

  async getLoginPatient(){
    this.loginPatient = await this.loginService.patientUser;
 }
  
 async getPatientsByDoctor(){
    this.patients = await this.doctorService.getPatientsByDoctor(this.loginDoctor.did);
    for(let p of this.patients){
      for(let a of p.appointments){
        a.patient = p;
        this.appointments.push(a);
    }}
    return this.appointments;
  }

  async getDoctorByPatient(){
    this.doctors = await this.patientService.getDoctorByPatient(this.loginPatient.pid)
    for(let d of this.doctors){
      for(let a of d.appointments){
        a.doctor = d;
        this.appointments.push(a);
    }}
    return this.appointments;
  }

  clickBtn(aid:number){
      //alert(ViewMoreComponent);
      console.log(aid);
  }
  
  
 /*     this.loginDoctor = this.doctorService.getDoctorById(value);


  async getDoctorById(did: number): Promise<Doctor> {
    const url: string = `http://localhost:8080/doctors/${did}`;
    const doctor: Doctor = await this.httpClient.get<Doctor>(url).toPromise();
    return doctor;
  }




 // patientUser:Patient = this.loginService.patientUser;
  //doctorUser:Doctor = this.loginService.doctorUser;
  //userName:string = this.doctorUser.username;

 /* logInUser(){
    if(this.patientUser.pid === null && this.doctorUser.did === null){
      this.doctorView = false;
      this.patientView = false;
    }
    else if(this.patientUser.pid !== null && this.doctorUser.did === null){
      this.doctorView = false;
      this.patientView = true;
    }    else if(this.patientUser.pid === null){
      this.doctorView = true;
      this.patientView = false;
      this.allDoctorsAppoint();
  }

    
  }

  async allDoctorsAppoint():Promise<void>{
    this.appointments = await this.doctorService.getAppointmentsByDoctor(this.doctorUser.did);
    }

  /*async getDoctorById():Promise<void>{
      this.doctor = await this.doctorService.getDoctorById(1);
      }





      async getDoctorById(did: number): Promise<Doctor> {
        const url: string = `http://localhost:8080/doctors/${did}`;
        const doctor: Doctor = await this.httpClient.get<Doctor>(url).toPromise();
        return doctor;
    
      }*/


}

