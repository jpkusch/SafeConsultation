package dev.four.services;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Patient;

public interface PatientService {
	
	Patient createPatient(Patient patient);
	
	Patient getPatientById(int id);
	
	Patient updatePatient(Patient patient);
	
	boolean logIn(LoginDTO loginInfo);

}
