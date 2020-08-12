package dev.four.services;

import dev.four.entities.Appointment;

public interface AppointmentService {
	
	Appointment createAppointment(Appointment appointment);
	
	Appointment getAppointmentById(int id);
	
	Appointment updateAppointment(Appointment appointment);

}
