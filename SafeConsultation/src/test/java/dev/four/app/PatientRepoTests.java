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
import dev.four.entities.Patient;
import dev.four.repositories.PatientRepository;

@SpringBootTest
@Transactional
@TestMethodOrder(OrderAnnotation.class)
class PatientRepoTests {
	
	@Autowired
	PatientRepository patrep;

	@Test
	@Order(1)
	@Commit
	void createPatient() {
		
		Patient patient = new Patient(0, "princessPeach", "OkeyDokey", 23, 5, 105, 'O');
		patrep.save(patient);
		Assertions.assertNotEquals(0, patient.getPid());
	}
	
	@Test
	@Order(2)
	void getPatientById() {
		
		Patient peach = patrep.findById(1).get();
		Assertions.assertEquals(1, peach.getPid());
	}
	
	@Test
	@Order(3)
	void getPatientByUsername() {
		
		List<Patient> sameName = patrep.findByUsername("princessPeach");
		Assertions.assertEquals(1, sameName.size());
	}
	
	@Test
	@Order(4)
	void getAllPatients() {
		
		Patient toad = new Patient(0, "Toad", "Bingo!I'mthebest", 5, 3.31, 77.1618, 'A');
		patrep.save(toad);
		List<Patient> allPatients = (List<Patient>) patrep.findAll();
		Assertions.assertEquals(2, allPatients.size());
	}
	
	@Test
	@Order(5)
	@Commit
	void updatePatient() {
		
		Patient peach = patrep.findById(1).get();
		peach.setPassword("Mario'scake");
		patrep.save(peach);
		Patient updatedPeach = patrep.findById(1).get();
		Assertions.assertEquals("Mario'scake", updatedPeach.getPassword());
	}
	
	@Test
	@Order(6)
	@Commit
	void deletePatient() {
		
		Patient peach = patrep.findById(1).get();
		patrep.delete(peach);
		Patient deletedPatient = patrep.findById(1).orElse(null);
		Assertions.assertEquals(null, deletedPatient);
	}

}
