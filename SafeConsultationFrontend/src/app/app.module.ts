import { LoginService } from './services/login.service';
import { PatientService } from './services/patient.service';
import { DoctorService } from './services/doctor.service';
import { AppointmentService } from './services/appointment.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MatRadioModule } from '@angular/material/radio'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import { MatButtonModule } from '@angular/material/button'
import {MatTableModule} from '@angular/material/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { PatientPageComponent } from './components/patient-page/patient-page.component';
import { DoctorPageComponent } from './components/doctor-page/doctor-page.component';
import { HeaderComponent } from './components/header/header.component';
import { AppointmentsTabComponent } from './components/appointments-tab/appointments-tab.component';
import { AccountTabComponent } from './components/account-tab/account-tab.component';
import { DoctorTabComponent } from './components/doctor-tab/doctor-tab.component';
import { PatientTabComponent } from './components/patient-tab/patient-tab.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { fromEventPattern } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    PatientPageComponent,
    DoctorPageComponent,
    HeaderComponent,
    AppointmentsTabComponent,
    AccountTabComponent,
    DoctorTabComponent,
    PatientTabComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule
  ],
  providers: [AppointmentService, DoctorService, PatientService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
