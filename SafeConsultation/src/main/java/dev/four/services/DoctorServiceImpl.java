package dev.four.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.repositories.DoctorRepository;

@Component
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository drepo;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		return drepo.save(doctor);
	}

	@Override
	public Doctor getDoctorById(int id) {
		return drepo.findById(id).get();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return (List<Doctor>) drepo.findAll();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return drepo.save(doctor);
	}

	@Override
	public Doctor logIn(LoginDTO loginInfo) {
		List<Doctor> doctors = drepo.findByUsername(loginInfo.getUsername());
		if (doctors != null && doctors.size() > 0) {
			Doctor doctor = doctors.get(0);
			if (doctor != null && doctor.getPassword().equals(loginInfo.getPassword())) {
				return doctor;
			}
		}
		return null;
	}
	

	@Override
	public List<Patient> getAllPatientsByDoctor(Doctor doctor) {
		List<Appointment> appointments =  doctor.getAppointments();
		Set<Patient> uniquePatients = new HashSet<Patient>();
		for (Appointment appointment : appointments) {
			uniquePatients.add(appointment.getPatient());
		}
		
		return new ArrayList<Patient>(uniquePatients);
	}

}
