package dev.four.entities;

import java.time.LocalDateTime;

public class Appointment {
	
	private int aid;
	private String symptoms;
	private String status;
	private LocalDateTime aptTime;
	private String diagnosis;
	private String treatment;
	private String meetingLink;
	private Doctor doctor;
	private Patient patient;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int aid, String symptoms, String status, LocalDateTime aptTime, String diagnosis,
			String treatment, String meetingLink, Doctor doctor, Patient patient) {
		super();
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

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getAptTime() {
		return aptTime;
	}

	public void setAptTime(LocalDateTime aptTime) {
		this.aptTime = aptTime;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getMeetingLink() {
		return meetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", symptoms=" + symptoms + ", status=" + status + ", aptTime=" + aptTime
				+ ", diagnosis=" + diagnosis + ", treatment=" + treatment + ", meetingLink=" + meetingLink + ", doctor="
				+ doctor + ", patient=" + patient + "]";
	}

}
