import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import {Patient} from '../../models/Patient';
import {DoctorService} from '../../services/doctor.service';
import { Doctor } from 'src/app/models/Doctor';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-patient-tab',
  templateUrl: './patient-tab.component.html',
  styleUrls: ['./patient-tab.component.css']
})
export class PatientTabComponent implements OnInit {

  constructor(private doctorService: DoctorService, private loginService: LoginService) { }

  doctor: Doctor = null;
  patients: Array<Patient> = [];
  dataSource = null;
  displayedColumns: string[] = [];

  async ngOnInit(): Promise<void> {
    await this.initializeDoctor();
    await this.initializePatients();
  }

  async initializePatients(): Promise<void> {
    this.patients = await this.doctorService.getPatientsByDoctor(this.doctor.did);
    this.dataSource = new MatTableDataSource<Patient>(this.patients);
    this.displayedColumns = ['patient', 'age', 'height', 'weight', 'bloodType'];
  }

  initializeDoctor(): void {
    this.doctor = this.loginService.doctorUser;
  }

}
