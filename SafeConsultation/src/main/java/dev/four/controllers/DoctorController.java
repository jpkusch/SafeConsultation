package dev.four.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.DoctorService;

@Component
@RestController
@CrossOrigin("*")
public class DoctorController {
	
	@Autowired
	DoctorService dserv;
	
	@RequestMapping(value = "/doctors", method = RequestMethod.POST)
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return this.dserv.createDoctor(doctor);
	}
	
	@RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
	public Doctor getDoctorById(@PathVariable int id) {
		return this.dserv.getDoctorById(id);
	}
	
	@RequestMapping(value = "/doctors/{id}/appointments", method = RequestMethod.GET)
	public List<Appointment> getAppointmentsByDoctor(@PathVariable int id) {
		Doctor doctor = this.dserv.getDoctorById(id);
		List<Appointment> appointmentsByDr = doctor.getAppointments();
		return appointmentsByDr;
	}
	
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public List<Doctor> getAllDoctors(){
		return this.dserv.getAllDoctors();
	}
	
	@RequestMapping(value = "/doctors/{id}/patients", method = RequestMethod.GET)
	public List<Patient> getAllPatientsByDoctor(@PathVariable int id) {
		Doctor doctor = dserv.getDoctorById(id);
		return this.dserv.getAllPatientsByDoctor(doctor);
	}
	
	@RequestMapping(value = "/doctors", method = RequestMethod.PUT)
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return this.dserv.updateDoctor(doctor);
	}
	
	@RequestMapping(value = "/doctors/login", method = RequestMethod.POST)
	public Doctor logInDoctor(@RequestBody LoginDTO ldto) {
		return this.dserv.logIn(ldto);
	}
	
	
	

}
