package dev.four.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.four.entities.Appointment;
import dev.four.services.AppointmentService;


@Component
@RestController
public class AppointmentController {
	
	@Autowired
	//private AppointmentService aserv;
	
	@RequestMapping(value = "/appointments", method = RequestMethod.POST)
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return null;
	}
	
	@RequestMapping(value = "/appointments/{id}", method = RequestMethod.GET)
	public Appointment getAppointmentById(@PathVariable int id) {
		return null;
	}

	@RequestMapping(value = "/appointments", method = RequestMethod.PUT)
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		return null;
	}
}
