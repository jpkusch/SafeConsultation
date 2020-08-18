import { Component, OnInit } from '@angular/core';
import {Patient} from '../../models/Patient';
import {PatientService} from '../../services/patient.service';

@Component({
  selector: 'app-patient-tab',
  templateUrl: './patient-tab.component.html',
  styleUrls: ['./patient-tab.component.css']
})
export class PatientTabComponent implements OnInit {

  constructor(private patientService:PatientService) { }

  patient:Patient;
  patients:Array<Patient>;

  ngOnInit(): void {
  }

}
