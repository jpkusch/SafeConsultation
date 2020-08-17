import { LoginService } from './../../services/login.service';
import { DoctorService } from './../../services/doctor.service';
import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/models/Doctor';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  loggedInDoctor: Doctor = null;
  appTabOpen: boolean = true;
  patTabOpen: boolean = false;
  accTabOpen: boolean = false;


  constructor(private doctorService: DoctorService, private loginService: LoginService) { }

  ngOnInit(): void {
    // use login service to get loggedInDoctor
  }

  clickTab(tabName: string): void {
    this.appTabOpen = false;
    this.patTabOpen = false;
    this.accTabOpen = false;

    if (tabName === 'Appointments') {
      this.appTabOpen = true;
    } else if (tabName === 'Patients') {
      this.patTabOpen = true;
    } else if (tabName === 'Account') {
      this.accTabOpen = true;
    }

  }

}
