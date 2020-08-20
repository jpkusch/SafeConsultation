import { Component, OnInit } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA, MatDialog} from  '@angular/material/dialog';
import {Inject, Injectable} from  '@angular/core';
import { Router} from '@angular/router';
import { Appointment } from './../../models/Appointment';
import { AppointmentService } from './../../services/appointment.service';
import { PatientService } from './../../services/patient.service';
import { DoctorService } from './../../services/doctor.service';
import { LoginService } from './../../services/login.service';
import { Patient } from 'src/app/models/Patient';
import { Doctor } from 'src/app/models/Doctor';



@Component({
  selector: 'app-view-more',
  templateUrl: './view-more.component.html',
  styleUrls: ['./view-more.component.css']
})

export class ViewMoreComponent implements OnInit {

  appointment:Appointment = null;
  patient:Patient = null;
  doctor:Doctor = null;
  diagnosis:string;
  treatment:string;
  loginDoctor:Doctor;
  loginPatient:Patient;



  constructor(public loginService:LoginService, public patientService:PatientService, public doctorService:DoctorService, public appointService:AppointmentService, public router: Router, private  dialogRef:  MatDialogRef<ViewMoreComponent>, @Inject(MAT_DIALOG_DATA) public  data:  any) {
  }

  async ngOnInit(): Promise<void> {

    await this.getAppointmentById();

    console.log(this.data.userID);

    if(this.router.url === '/doctor'){
      await this.getPatientByID();
      await this.getLoginDoctor();
    } 
    else if(this.router.url === '/patient'){
      await this.getDoctoryID();
      await this.getLoginPatient();
    }
    console.log(this.doctor);
    console.log(this.patient);
  }



      async getLoginDoctor(){
        this.loginDoctor = await this.loginService.doctorUser;
      }

      async getLoginPatient(){
        this.loginPatient = await this.loginService.patientUser;
      }


    async getAppointmentById(){
      this.appointment = await this.appointService.getAppointmentById(this.data.aid);
  }

  async getPatientByID(){
    this.patient = await this.patientService.getPatientById(this.data.userID);
  }

  async getDoctoryID(){
    this.doctor = await this.doctorService.getDoctorById(this.data.userID);
  }
  
  public  closeMe() {
    this.dialogRef.close();
}

    async rescheduleAppDoctor(){
      prompt("Enter date")
      console.log(this.appointment.aptTime);
      this.appointment.aptTime = prompt.arguments;
      //this.appointment.doctor = this.loginDoctor;
      //this.appointment.patient = this.patient;
      await this.appointService.updateAppointment(this.appointment);
    }

    async rescheduleAppPatient(){
      prompt("Enter date")
      console.log(this.appointment.aptTime);
      console.log(prompt);
     // let date:string = prompt();
     // let d:Date = Date(date);
     // this.appointment.aptTime = date;
    //  this.appointment.patient = this.loginPatient;
    //  this.appointment.doctor = this.doctor;
      await this.appointService.updateAppointment(this.appointment);
    }

    async cancelAppDoctor(){
      alert("Are you sure?")
      this.appointment.status = "Cancelled";
     // this.appointment.doctor = this.loginDoctor;
     // this.appointment.patient = this.patient;
     console.log(this.appointment);
      await this.appointService.updateAppointment(this.appointment);
    }

    async cancelAppPatient(){
      alert("Are you sure?")
      this.appointment.status = "Cancelled";
     // this.appointment.patient = this.loginPatient;
      //this.appointment.doctor = this.doctor;
      console.log(this.appointment);
      await this.appointService.updateAppointment(this.appointment);
    }

    async prescription(){
      alert("Are you sure?")
      this.appointment.diagnosis = this.diagnosis;
      this.appointment.treatment = this.treatment;
     // this.appointment.doctor = this.loginDoctor;
     // this.appointment.patient = this.patient;
      await this.appointService.updateAppointment(this.appointment);
    }



}
