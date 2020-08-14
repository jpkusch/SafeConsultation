package dev.four.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Appointment;
import dev.four.entities.Patient;
import dev.four.services.PatientService;

@Component
@RestController
public class PatientController {
	
	@Autowired
	PatientService pserv;
	
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient patient) {
		return null;
	}
	
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public Patient getPatientById(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value = "/patients/{id}/appointments", method = RequestMethod.GET)
	public List<Appointment> getAppointmentsByPatient(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value = "/patients", method = RequestMethod.PUT)
	public Patient updatePatient(@RequestBody Patient patient) {
		return null;
	}
	
	@RequestMapping(value = "/patients/login", method = RequestMethod.POST)
	public Patient logInPatient(@RequestBody LoginDTO ldto) {
		return null;
	}

}
