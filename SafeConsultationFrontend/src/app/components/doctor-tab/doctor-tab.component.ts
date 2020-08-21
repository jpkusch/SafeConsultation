import { Component, OnInit } from '@angular/core';
import {Doctor} from '../../models/Doctor'
import {DoctorService} from '../../services/doctor.service'
import {Appointment} from '../../models/Appointment'
import {AppointmentService} from '../../services/appointment.service'
import {Patient} from '../../models/Patient';
import {LoginService} from '../../services/login.service'



@Component({
  selector: 'app-doctor-tab',
  templateUrl: './doctor-tab.component.html',
  styleUrls: ['./doctor-tab.component.css']
})
export class DoctorTabComponent implements OnInit {

  constructor(private doctorService:DoctorService, private appointmentService:AppointmentService, private loginService:LoginService) { }

  showAllDrs:Boolean = true;
  makeApptTab:Boolean = false;

  alldoctors:Array<Doctor> = [];
  appointment:Appointment;

  enteredSymptoms:string;
  selectedDateTime: Date;
  selectedDoctor:Doctor;
  loggedInPatient:Patient = this.loginService.patientUser;


  ngOnInit(): void {
    this.showAllDoctors();
  }

  async showAllDoctors():Promise<void>{
    this.alldoctors = await this.doctorService.getAllDoctors();
  }

  async goToMakeAppointment(did:number):Promise<void>{

    this.makeApptTab = true;
    this.showAllDrs = false;
    this.selectedDoctor = await this.doctorService.getDoctorById(did);
  }

  async makeAppointment():Promise<void>{
    
    let newAppointment = new Appointment(0, this.enteredSymptoms, "", this.selectedDateTime, "", "", "zoom.com", this.selectedDoctor, this.loggedInPatient);

    this.appointment = await this.appointmentService.createAppointment(newAppointment);

    alert("Your appointment has been booked!");

    this.makeApptTab = false;
    this.showAllDrs = true;
  }

}
