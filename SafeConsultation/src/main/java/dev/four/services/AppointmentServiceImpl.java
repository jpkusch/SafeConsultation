package dev.four.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.four.entities.Appointment;
import dev.four.repositories.AppointmentRepository;

@Component
@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository ar;

	public Appointment createAppointment(Appointment appointment) {
		return ar.save(appointment);
	}

	public Appointment getAppointmentById(int id) {
		Appointment appointment = ar.findById(id).get();
		return appointment;
	}

	public Appointment updateAppointment(Appointment appointment) {
		return ar.save(appointment);
	}

}
