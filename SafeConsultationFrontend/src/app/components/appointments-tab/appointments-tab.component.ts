import { Component, OnInit } from '@angular/core';
import { LoginService } from './../../services/login.service';
import { DoctorService } from './../../services/doctor.service';
import { PatientService } from './../../services/patient.service';
import { AppointmentService } from './../../services/appointment.service';
import { Patient } from './../../models/Patient';
import { Doctor } from './../../models/Doctor';
import { Appointment } from './../../models/Appointment';
import { HttpClient } from '@angular/common/http';
import {ViewMoreComponent} from '../view-more/view-more.component'
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';


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

  dataSource = null;
  displayedColumns: string[] = [];

  constructor(private appointService:AppointmentService, private  dialog:  MatDialog, private httpClient: HttpClient, private loginService:LoginService, private doctorService:DoctorService, private patientService:PatientService) {

   }

  async ngOnInit(): Promise<void> {
    await this.getLoginDoctor();
    await this.getLoginPatient();

    if(this.loginDoctor===null){
      await this.getAppointmentByPatient();
    }
    else{
      await this.getAppointmentByDoctor();
    }

    this.dataSource = new MatTableDataSource<Appointment>(this.appointments);
    if (this.loginDoctor) {
      this.displayedColumns = ['ID', 'Patient', 'Status', 'Date', 'Time', 'MoreInfo'];
    } else if (this.loginPatient) {
      this.displayedColumns = ['ID', 'Doctor', 'Status', 'Date', 'Time', 'MoreInfo'];
    }
  }

  async getLoginDoctor(){
     this.loginDoctor = await this.loginService.doctorUser;
  }

  async getLoginPatient(){
    this.loginPatient = await this.loginService.patientUser;
 }

 async getAppointmentByDoctor(){
   this.appointments = await this.appointService.getAppointmentByDoctor(this.loginDoctor.did);
 }

 async getAppointmentByPatient(){
  this.appointments = await this.appointService.getAppointmentByPatient(this.loginPatient.pid);
}

 /*async getPatientsByDoctor(){
    this.patients = await this.doctorService.getPatientsByDoctor(this.loginDoctor.did);
    for(let p of this.patients){
      console.log(p)
      for(let a of p.appointments){
        //console.log(a.doctor.did)
        //if(a.doctor.did === this.loginDoctor.did){
        a.patient = p;
        this.appointments.push(a);
    }}
    return this.appointments;
  }

  async getDoctorByPatient(){
    this.doctors = await this.patientService.getDoctorByPatient(this.loginPatient.pid)
    for(let d of this.doctors){
      console.log(d)
      for(let a of d.appointments){
        a.doctor = d;
        this.appointments.push(a);
    }}
    return this.appointments;
  }*/

  clickBtn(aid:number, userID:number){
      this.dialog.open(ViewMoreComponent,{ data:  { aid:aid, userID: userID}});
  }



}

