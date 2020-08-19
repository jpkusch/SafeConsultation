import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Doctor} from '../models/Doctor'
import {Patient} from '../models/Patient'


export class Appointment { 

	aid: number;
	symptoms: string;
	status: string;
	aptTime: Date;
	diagnosis: string;
	treatment: string;
	meetingLink: string;
	doctor: Doctor;
	patient: Patient;

  constructor (aid:number, symptoms: string, status: string, aptTime: Date, diagnosis: string,
	treatment: string, meetingLink: string, doctor: Doctor, patient: Patient) {
	this.aid = aid;
	this.symptoms = symptoms;
	this.status = status;
	this.aptTime = aptTime;
	this.diagnosis = diagnosis;
	this.treatment = treatment;
	this.meetingLink = meetingLink;
	this.doctor = doctor;
	this.patient = patient;
}
  }



