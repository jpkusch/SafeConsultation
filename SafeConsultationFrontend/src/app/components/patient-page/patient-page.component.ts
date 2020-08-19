import { Component, OnInit } from '@angular/core';
import {Patient} from '../../models/Patient';
import {PatientService} from '../../services/patient.service';

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  appTabOpen: boolean = true;
  patTabOpen: boolean = false;
  accTabOpen: boolean = false;

  constructor(private patientService:PatientService) { }

  patient:Patient;

  ngOnInit(): void {
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
