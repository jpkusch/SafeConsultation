package dev.four.controllertests;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.PatientService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
class PatientControllerMockTests {

	@MockBean
	PatientService pserv;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void getPatient() throws Exception {
		Patient patient = new Patient(1, "username", "password", 40, 100, 72, "O-Neg");
		Mockito.when(pserv.getPatientById(1)).thenReturn(new Patient(1, "username", "password", 40, 100, 72, "O-Neg"));
		
		ResultActions ra = mvc.perform(get("/patients/1"));
		ra.andExpect(status().isOk());
	}

	@Test
	void getAppointments() throws Exception {
		List<Appointment> appointments = new ArrayList<Appointment>();
		Patient patient = new Patient(1, "username", "password", 40, 100, 72, "O-Neg");
		Doctor doctor = new Doctor(1, "username", "password", "specialty", new ArrayList<Appointment>());
		Appointment appointment = new Appointment(1, "symptoms", "status", LocalDateTime.now(), "diagnosis", "treatment", "meeting link1", doctor, patient);
		appointments.add(appointment);
		patient.setAppointments(appointments);
		doctor.setAppointments(appointments);
		
		Mockito.when(pserv.getPatientById(1)).thenReturn(patient);
		
		ResultActions ra = mvc.perform(get("/patients/1/appointments"));
		ra.andExpect(status().isOk());
	}
	
	
}
