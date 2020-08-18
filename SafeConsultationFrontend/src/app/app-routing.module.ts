import { PatientPageComponent } from './components/patient-page/patient-page.component';
import { DoctorPageComponent } from './components/doctor-page/doctor-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'login', component: LoginPageComponent},
  {path: 'doctor', component: DoctorPageComponent},
  {path: 'patient', component: PatientPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
