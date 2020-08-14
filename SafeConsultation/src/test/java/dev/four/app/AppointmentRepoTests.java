package dev.four.app;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.repositories.AppointmentRepository;
import dev.four.repositories.DoctorRepository;
import dev.four.repositories.PatientRepository;

@SpringBootTest
@Transactional
@TestMethodOrder(OrderAnnotation.class)
class AppointmentRepoTests {

	@Autowired
	AppointmentRepository apprep;
	
	@Autowired
	DoctorRepository docrep;
	
	@Autowired
	PatientRepository patrep;
	
	@Test
	@Order(1)
	@Commit
	void createAppointment() {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();
		Doctor doctor = new Doctor(0, "drMario", "HereWeGo!", "Pediatrician", drAppointments);
		docrep.save(doctor);
		
		Patient patient = new Patient(0, "princessPeach", "OkeyDokey", 23, 5, 105, "O");
		patrep.save(patient);
		
		Appointment appointment = new Appointment(0, "nose running, coughing, heavy breathing & fever", "reserved", LocalDateTime.now(), "", "", "zoom.com", doctor, patient);
		apprep.save(appointment);
		Assertions.assertNotEquals(0, appointment.getAid());
	}
	
	@Test
	@Order(2)
	void getAccountById() {
		
		Appointment appointment = apprep.findById(1).get();
		Assertions.assertEquals(1, appointment.getAid());
	}
	
	@Test
	@Order(3)
	@Commit
	void getAllAppointments() {
		
		Doctor doctor = docrep.findById(1).get();
		Patient patient = patrep.findById(1).get();
		
		Appointment anotherAppointment = new Appointment(0, "hallucinations, deliria", "reserved", LocalDateTime.now(), "", "", "zoom.com", doctor, patient);
		apprep.save(anotherAppointment);
		
		List<Appointment> allAppointments = (List<Appointment>) apprep.findAll();
		
		Assertions.assertEquals(2, allAppointments.size());
	}
	
	@Test
	@Order(4)
	@Commit
	void updateAppointment() {
		
		Appointment appointment = apprep.findById(1).get();
		appointment.setStatus("confirmed");
		apprep.save(appointment);
		Appointment appointmentConfirmed = apprep.findById(1).get();
		Assertions.assertEquals("confirmed", appointmentConfirmed.getStatus());
	}
	
	@Test
	@Order(5)
	@Commit
	void deleteAppointment() {
		
		Appointment appointment = apprep.findById(2).get();
		apprep.delete(appointment);
		Appointment deletedAppointment = apprep.findById(2).orElse(null);
		Assertions.assertEquals(null, deletedAppointment);
	}

}
