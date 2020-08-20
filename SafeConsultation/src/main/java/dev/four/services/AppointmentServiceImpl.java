package dev.four.services;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Appointment> getAppointmentByDoctor(int id) {
		List<Appointment> appointments = (List<Appointment>) ar.findAll();
		List<Appointment> doctorAppointments = new ArrayList<Appointment>();
		for(Appointment app : appointments) {
			if(app.getDoctor().getDid() == id) {
				doctorAppointments.add(app);
			}
		}
		return doctorAppointments;
	}

	@Override
	public List<Appointment> getAppointmentByPatient(int id) {
		List<Appointment> appointments = (List<Appointment>) ar.findAll();
		List<Appointment> patientAppointments = new ArrayList<Appointment>();
		for(Appointment app : appointments) {
			if(app.getPatient().getPid() == id) {
				patientAppointments.add(app);
			}
		}
		return patientAppointments;
	}

}
