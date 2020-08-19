package dev.four.services;

import java.util.List;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;

public interface PatientService {
	
	Patient createPatient(Patient patient);
	
	Patient getPatientById(int id);
	
	Patient updatePatient(Patient patient);
	
	Patient logIn(LoginDTO loginInfo);
	
	List<Doctor> getAllDoctorByPatient (Patient patient);

}
