import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import {Patient} from '../../models/Patient';
import {DoctorService} from '../../services/doctor.service';
import { Doctor } from 'src/app/models/Doctor';

@Component({
  selector: 'app-patient-tab',
  templateUrl: './patient-tab.component.html',
  styleUrls: ['./patient-tab.component.css']
})
export class PatientTabComponent implements OnInit {

  constructor(private doctorService: DoctorService, private loginService: LoginService) { }

  doctor: Doctor = null;
  patients: Array<Patient> = [];

  ngOnInit(): void {
    this.initializeDoctor();
    this.initializePatients();
  }

  async initializePatients(): Promise<void> {
    this.patients = await this.doctorService.getPatientsByDoctor(this.doctor.did);
  }

  initializeDoctor(): void {
    this.doctor = this.loginService.doctorUser;
  }

}
