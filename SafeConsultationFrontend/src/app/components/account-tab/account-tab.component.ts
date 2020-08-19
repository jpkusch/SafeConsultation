import { PatientService } from './../../services/patient.service';
import { DoctorService } from './../../services/doctor.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/models/Patient';
import { Doctor } from 'src/app/models/Doctor';

@Component({
  selector: 'app-account-tab',
  templateUrl: './account-tab.component.html',
  styleUrls: ['./account-tab.component.css']
})
export class AccountTabComponent implements OnInit {

  doctor: Doctor = null;
  patient: Patient = null;
  isLoaded: boolean = false;

  constructor(private loginService: LoginService, private doctorService: DoctorService, private patientService: PatientService) { }

  ngOnInit(): void {
    this.docPat();
    this.isLoaded = true;
  }

  docPat(): void {
    this.doctor = this.loginService.doctorUser;
    this.patient = this.loginService.patientUser;
  }

  updateUser(): void {
    if (this.doctor) {
      this.doctorService.updateDoctor(this.doctor);
      this.loginService.doctorUser = this.doctor;
    } else if (this.patient) {
      this.patientService.updatePatient(this.patient);
      this.loginService.patientUser = this.patient;
    }
  }

}
