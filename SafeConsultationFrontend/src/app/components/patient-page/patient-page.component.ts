import { Component, OnInit } from '@angular/core';
import {Patient} from '../../models/Patient';
import {PatientService} from '../../services/patient.service';

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  constructor(private patientService:PatientService) { }

  patient:Patient;

  ngOnInit(): void {
  }

}
