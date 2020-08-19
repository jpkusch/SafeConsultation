import { Component, OnInit } from '@angular/core';
import {Patient} from '../../models/Patient';
import {PatientService} from '../../services/patient.service';
import {LoginService} from '../../services/login.service'

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {
  appTabOpen: boolean = true;
  patTabOpen: boolean = false;
  accTabOpen: boolean = false;
  constructor(private patientService:PatientService, private loginService:LoginService) { }

  browseDoctors:Boolean = false;
  accountInfo:Boolean = true;
  appointments:Boolean = false;
  updateInfo:Boolean = false;

  enteredHeight:number;
  enteredWeight:number;
  enteredBloodType:string;
  enteredAge:number;

  patient:Patient = this.loginService.patientUser;
  patientIn:Patient;

  async ngOnInit():Promise<void> {

    this.patient = await this.loginService.patientUser;

  }

  goToAccountInfo(){
    this.accountInfo = true;
    this.browseDoctors = false;
    this.appointments = false;
    this.updateInfo = false;
  }

  goToBrowseDoctors(){
    this.browseDoctors = true;
    this.accountInfo = false;
    this.appointments = false;
    this.updateInfo = false;
  }

  goToAppointments(){
    this.appointments = true;
    this.accountInfo = false;
    this.browseDoctors = false;
    this.updateInfo = false;
  }

  goToUpdateInfo(){
    this.updateInfo = true;
    this.accountInfo = false;
    this.appointments = false;
    this.browseDoctors = false;
  } 

  async getLoggedPatient(){


  }

  async updatePatient(patientIn:Patient):Promise<void>{

    patientIn.height = this.enteredHeight;
    patientIn.weight = this.enteredWeight;
    patientIn.bloodType = this.enteredBloodType;
    patientIn.age = this.enteredAge;

    this.patient = await this.patientService.updatePatient(patientIn);
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
