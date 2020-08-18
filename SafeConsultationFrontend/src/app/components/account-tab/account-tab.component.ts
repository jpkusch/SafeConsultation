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

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.docPat();
    this.isLoaded = true;
  }

  docPat(): void {
    this.doctor = this.loginService.doctorUser;
    this.patient = this.loginService.patientUser;
  }

}
