package dev.four.services;

import java.util.List;

import dev.four.entities.Appointment;

public interface AppointmentService {
	
	Appointment createAppointment(Appointment appointment);
	
	Appointment getAppointmentById(int id);
	
	List<Appointment> getAppointmentByDoctor(int id);
	List<Appointment> getAppointmentByPatient(int id);
	
	Appointment updateAppointment(Appointment appointment);

}
