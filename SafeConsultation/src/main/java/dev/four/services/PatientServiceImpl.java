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
import dev.four.repositories.PatientRepository;

@Component
@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository prep;
	
	@Override
	public Patient createPatient(Patient patient) {
		return prep.save(patient);
	}

	@Override
	public Patient getPatientById(int id) {
		Patient patient = prep.findById(id).orElse(null);
		return patient; 
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return prep.save(patient);
	}

	@Override
	public Patient logIn(LoginDTO loginInfo) {
		List<Patient> patients = prep.findByUsername(loginInfo.getUsername());
		if (patients != null && patients.size() > 0) {
			Patient patient = prep.findByUsername(loginInfo.getUsername()).get(0);
			// if returned patient's login info matches entered login info return patient
			if(patient.getUsername().equals(loginInfo.getUsername()) && patient.getPassword().equals(loginInfo.getPassword())) {
				return patient;
			}
		}
		return null;
	}

	@Override
	public List<Doctor> getAllDoctorByPatient(Patient patient) {
		List<Appointment> appointments =  patient.getAppointments();
		Set<Doctor> uniqueDoctors = new HashSet<Doctor>();
		for (Appointment appointment : appointments) {
			uniqueDoctors.add(appointment.getDoctor());
		}
		
		return new ArrayList<Doctor>(uniqueDoctors);
	}
	

}
