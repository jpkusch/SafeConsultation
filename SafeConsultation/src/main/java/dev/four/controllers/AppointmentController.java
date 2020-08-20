package dev.four.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.four.entities.Appointment;
import dev.four.services.AppointmentService;
import dev.four.services.AppointmentServiceImpl;


@Component
@RestController
@CrossOrigin("*")
public class AppointmentController {
	
	@Autowired
	AppointmentService aserv;
	
	@RequestMapping(value = "/appointments", method = RequestMethod.POST)
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		appointment.setStatus("reserved");
		return this.aserv.createAppointment(appointment);
	}
	
	@RequestMapping(value = "/appointments/{id}", method = RequestMethod.GET)
	public Appointment getAppointmentById(@PathVariable int id) {
		return this.aserv.getAppointmentById(id);
	}

	@RequestMapping(value = "/appointments", method = RequestMethod.PUT)
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		return this.aserv.updateAppointment(appointment);
	}
}

