package dev.four.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private int aid;
	
	@Column(name = "symptoms")
	private String symptoms;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "apt_time")
	private LocalDateTime aptTime;
	
	@Column(name = "diagnosis")
	private String diagnosis;
	
	@Column(name = "treatment")
	private String treatment;
	
	@Column(name = "meeting_link")
	private String meetingLink;
	
	@ManyToOne
	@JoinColumn(name="d_id")
	@JsonBackReference(value="doctorParent")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="p_id")
	@JsonBackReference(value="patientParent")
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
