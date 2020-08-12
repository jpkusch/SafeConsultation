package dev.four.services;

import java.util.List;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;

public interface DoctorService {
	
	Doctor createDoctor(Doctor doctor);
	
	Doctor getDoctorById(int id);
	Doctor getAllDoctors();
	
	Doctor updateDoctor(Doctor doctor);
	
	boolean logIn(LoginDTO loginInfo);
	List<Patient> getAllPatientsByDoctor(Doctor doctor);

}
