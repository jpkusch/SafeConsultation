package dev.four.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
import dev.four.repositories.DoctorRepository;

@SpringBootTest
@Transactional
@TestMethodOrder(OrderAnnotation.class)
class DoctorRepoTests {
	
	@Autowired
	DoctorRepository docrep;

	@Test
	@Order(1)
	@Commit
	void createDoctor() {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();	
		Doctor doctor = new Doctor(0, "drMario", "HereWeGo!", "Pediatrician", drAppointments);
		docrep.save(doctor);
		Assertions.assertNotEquals(0, doctor.getDid());
	}
	
	@Test
	@Order(2)
	void getDoctorById() {
		
		Doctor drMario = docrep.findById(1).get();
		Assertions.assertEquals(1, drMario.getDid());
	}
	
	@Test
	@Order(3)
	void getDrByUsername() {
		
		List<Doctor> drsByName = docrep.findByUsername("drMario");
		Assertions.assertEquals(1, drsByName.size());
	}
	
	@Test
	@Order(4)
	@Commit
	void getAllDoctors() {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();	
		Doctor doctor = new Doctor(0, "drLuigi", "MammaMia!", "Psychiatrist", drAppointments);
		docrep.save(doctor);
		List<Doctor> allDrs = (List<Doctor>) docrep.findAll();
		Assertions.assertEquals(2, allDrs.size());
	}
	
	@Test
	@Order(5)
	@Commit
	void updateDoctor() {
		
		Doctor drMario = docrep.findById(1).get();
		drMario.setPassword("It'same:Mario!");
		docrep.save(drMario);
		Doctor updatedDr = docrep.findById(1).get();
		Assertions.assertEquals("It'same:Mario!", updatedDr.getPassword());
	}
	
	@Test
	@Order(6)
	@Commit
	void deleteDoctorById() {
		
		docrep.deleteById(1);
		Doctor deletedDr = docrep.findById(1).orElse(null);
		Assertions.assertEquals(null, deletedDr);
	}

}
