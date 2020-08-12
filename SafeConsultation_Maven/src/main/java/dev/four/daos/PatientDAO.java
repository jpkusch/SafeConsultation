package dev.four.daos;

import java.util.List;

import dev.four.entities.Patient;

public interface PatientDAO {
	
	// Create
	Patient createPatient(Patient patient);
	
	// Read
	Patient getPatientById(int id);
	List<Patient> getPatientsByDoctorId(int it);
	Patient getPatientByUsername(String username);
	
	// Update
	Patient updatePatient(Patient patient);

}
