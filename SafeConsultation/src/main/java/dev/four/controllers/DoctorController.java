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
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.DoctorService;

@Component
@RestController
public class DoctorController {
	
	//@Autowired
	//DoctorService dserv;
	
	@RequestMapping(value = "/doctors", method = RequestMethod.POST)
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return null;
	}
	
	@RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
	public Doctor getDoctorById(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value = "/doctors/{id}/appointments", method = RequestMethod.GET)
	public List<Appointment> getAppointmentsByDoctor(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public List<Doctor> getAllDoctors(){
		return null;
	}
	
	@RequestMapping(value = "/doctors/{id}/patients", method = RequestMethod.GET)
	public List<Patient> getAllPatientsByDoctor(@PathVariable int id) {
		return null;
	}
	
	@RequestMapping(value = "/doctors", method = RequestMethod.PUT)
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return null;
	}
	
	@RequestMapping(value = "/doctors/login", method = RequestMethod.POST)
	public Doctor logInDoctor(@RequestBody LoginDTO ldto) {
		return null;
	}

}
