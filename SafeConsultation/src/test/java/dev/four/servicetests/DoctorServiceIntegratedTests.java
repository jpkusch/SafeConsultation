package dev.four.servicetests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.repositories.DoctorRepository;
import dev.four.services.DoctorService;

@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
@TestMethodOrder(OrderAnnotation.class) 
@Transactional
public class DoctorServiceIntegratedTests {
	
	@Autowired
	DoctorService dserv;
	
	@Test
	@Order(1)
	@Rollback
	void createDoctor() {
		List<Appointment> appointments = new ArrayList<Appointment>();
		Doctor doctor = new Doctor(0, "drMike", "betterPassword", "being cool", appointments);
		dserv.createDoctor(doctor);
		Assertions.assertNotEquals(doctor.getDid(), 0);
	}
	
	@Test
	@Order(2)
	@Rollback
	void getDoctorById() {
		Doctor doctor = dserv.getDoctorById(3);
		Assertions.assertEquals(doctor.getSpecialty(), "Neurologist");
	}

	@Test
	@Order(3)
	@Rollback
	void updateDoctor() {
		Doctor doctor = dserv.getDoctorById(1);
		doctor.setSpecialty("Pediatrician");
		doctor = dserv.updateDoctor(doctor);
		Assertions.assertEquals(doctor.getSpecialty(), "Pediatrician");
	}
	
	@Test
	@Order(4)
	@Rollback
	void getAllDoctors() {
		List<Doctor> doctors = dserv.getAllDoctors();
		Assertions.assertEquals(doctors.size(), 5);
	}
	
	@Test
	@Order(5)
	@Rollback
	void login() {
		LoginDTO login = new LoginDTO("drMario", "HereWeGo!");
		Doctor doctor = dserv.logIn(login);
		Assertions.assertEquals(doctor.getSpecialty(), "Pediatrition");
	}
	
	@Test
	@Order(6)
	@Rollback
	void getPatientsByDoctor(){
		Doctor doctor = dserv.getDoctorById(1);
		List<Patient> patients = dserv.getAllPatientsByDoctor(doctor);
		Assertions.assertEquals(patients.size(), 3);
	}
	
	@Test
	@Order(7)
	@Rollback
	void duplicateUsernameCreateDoctor() {
		List<Appointment> appointments = new ArrayList<Appointment>();
		Doctor doctor = new Doctor(0, "drMario", "betterPassword", "being cool", appointments);
		dserv.createDoctor(doctor);
		Assertions.assertEquals(doctor.getDid(), 0);
	}
	
	@Test
	@Order(8)
	@Rollback
	void invalidLogin() {
		LoginDTO login = new LoginDTO("George", "HereWeGo!");
		Doctor doctor = dserv.logIn(login);
		Assertions.assertEquals(doctor, null);
	}
}
