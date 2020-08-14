package dev.four.servicetests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Patient;
import dev.four.repositories.PatientRepository;
import dev.four.services.PatientService;

@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
public class PatientServiceMockTests {

	@MockBean
	PatientRepository prep;
	
	@Autowired
	PatientService pserv;
	
	@Test
	void createPatient() {
		Patient patient = new Patient(0, "username", "password", 40, 100, 72, "O-Neg");
		Mockito.when(prep.save(patient)).thenReturn(new Patient(1, "username", "password", 40, 100, 72, "O-Neg"));
		Assertions.assertEquals(pserv.createPatient(patient).getPid(), 1);
	}
	
	@Test
	void getPatient() {
		Patient patient = new Patient(2, "username", "password", 40, 100, 72, "O-Neg");
		Mockito.when(prep.findById(2)).thenReturn(Optional.of(patient));
		Assertions.assertEquals(pserv.getPatientById(2).getPid(), 2);
		Assertions.assertEquals(pserv.getPatientById(2).getUsername(), "username");
	}
	
	@Test
	void updatePatient() {
		Patient patient = new Patient(1, "username", "password", 40, 100, 72, "O-Neg");
		Mockito.when(prep.save(patient)).thenReturn(new Patient(1, "username", "password", 50, 120, 72, "O-Neg"));
		
		Assertions.assertEquals(pserv.updatePatient(patient).getAge(), 50);
	}
	
	@Test
	void login() {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(new Patient(1, "username", "password", 50, 120, 72, "O-Neg"));
		Mockito.when(prep.findByUsername("username")).thenReturn(patientList);
		
		Assertions.assertEquals(pserv.logIn(new LoginDTO("username", "password")).getPid(), 1);
	}
	
	@Test
	void badLogin() {
		Mockito.when(prep.findByUsername("username2")).thenReturn(null);
		
		Assertions.assertEquals(pserv.logIn(new LoginDTO("username2", "password")), null);
	}
	
}
