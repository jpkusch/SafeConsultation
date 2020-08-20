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
  /* appTabOpen: boolean = true;
  patTabOpen: boolean = false;
  accTabOpen: boolean = false; */
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

  async updatePatient():Promise<void>{

    if(this.enteredHeight != null){
      this.patient.height = this.enteredHeight;
    }
    else{
      this.patient.height = this.patient.height;
    }

    if(this.enteredWeight != null){
      this.patient.weight = this.enteredWeight;
    }
    else{
      this.patient.weight = this.patient.weight;
    }

    if(this.enteredBloodType != null){
      this.patient.bloodType = this.enteredBloodType;
    }
    else{
      this.patient.bloodType = this.patient.bloodType;
    }
    
    if(this.enteredAge != null){
      this.patient.age = this.enteredAge;
    }
    else{
      this.patient.age =  this.patient.age;
    }
    
    this.patient = await this.patientService.updatePatient(this.patient);

    this.goToAccountInfo();
  }

/*   clickTab(tabName: string): void {
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
  } */
}
