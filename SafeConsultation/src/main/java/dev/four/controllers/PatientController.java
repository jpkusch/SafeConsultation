package dev.four.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.PatientService;

@Component
@RestController
@CrossOrigin("*")
public class PatientController {
	
	@Autowired
	PatientService pserv;
	
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient patient) {
		return pserv.createPatient(patient);
	}
	
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public Patient getPatientById(@PathVariable int id) {
		return pserv.getPatientById(id);
	}
	
	@RequestMapping(value = "/patients/{id}/appointments", method = RequestMethod.GET)
	public List<Appointment> getAppointmentsByPatient(@PathVariable int id) {
		return pserv.getPatientById(id).getAppointments();
	}
	
	@RequestMapping(value = "/patients", method = RequestMethod.PUT)
	public Patient updatePatient(@RequestBody Patient patient) {
		return pserv.updatePatient(patient);
	}
	
	@RequestMapping(value = "/patients/login", method = RequestMethod.POST)
	public Patient logInPatient(@RequestBody LoginDTO ldto) {
		return pserv.logIn(ldto);
	}
	
	@RequestMapping(value = "/patients/{id}/doctors", method = RequestMethod.GET)
	public List<Doctor> getAllDoctorbyPatients(@PathVariable int id) {
		Patient patient = pserv.getPatientById(id);
		return this.pserv.getAllDoctorByPatient(patient);
	}

}
