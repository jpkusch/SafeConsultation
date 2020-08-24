package dev.four.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.PatientService;

@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
@TestMethodOrder(OrderAnnotation.class) 
@Transactional
class PatientServiceIntegratedTests {

	@Autowired
	PatientService pserv;

	@Test
	@Order(1)
	@Rollback
	void createPatient() {
		Patient patient = new Patient(0, "username2", "password2", 40, 100, 72, "O-Neg");
		pserv.createPatient(patient);
		Assertions.assertNotEquals(patient.getPid(),0);
	}
	
	
	@Test
	@Order(2)
	@Rollback
	void getPatient() {
		Patient patient = pserv.getPatientById(1);
		Assertions.assertEquals(patient.getUsername(), "princessPeach");
	}
	
	@Test
	@Order(3)
	@Rollback
	void updatePatient() {
		Patient patient = new Patient(1, "princessPeach", "OkeyDokey", 24, 5, 105, "O");
		pserv.updatePatient(patient);
		Patient update = pserv.getPatientById(1);
		Assertions.assertEquals(update.getAge(), 24);
	}
	
	@Test
	@Order(4)
	@Rollback
	void login() {
		LoginDTO login = new LoginDTO("princessPeach", "OkeyDokey");
		Patient patient = pserv.logIn(login);
		Assertions.assertEquals(patient.getAge(), 23);
	}
	
	@Test
	@Order(5)
	@Rollback
	void createDuplicatePatient() {
		Patient patient = new Patient(0, "princessPeach", "OkeyDokey", 40, 100, 72, "O-Neg");
		pserv.createPatient(patient);
		Assertions.assertEquals(patient.getPid(), 0);
	}
	
	@Test
	@Order(6)
	@Rollback
	void badLogin() {
		LoginDTO login = new LoginDTO("George", "OkeyDokey");
		Patient patient = pserv.logIn(login);
		Assertions.assertEquals(patient, null);
	}
	
	@Test
	@Order(7)
	@Rollback
	void getAllDoctorsByPatient() {
		Patient patient = pserv.getPatientById(1);
		List<Doctor> doctors = pserv.getAllDoctorByPatient(patient);
		Assertions.assertEquals(doctors.size(), 2);
	}
}
