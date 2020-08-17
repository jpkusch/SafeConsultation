package dev.four.controllersmocktest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.DoctorService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
class DoctorControllerMockTests {
	
	@MockBean
	DoctorService dserv;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void getDoctorById() throws Exception {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();	
		Doctor doctor = new Doctor(1, "drMario", "HereWeGo!", "Pediatrician", drAppointments);
		
		Mockito.when(dserv.getDoctorById(1)).thenReturn(doctor);
		
		ResultActions ra = mvc.perform(get("/doctors/1"));
		ra.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void getAllDoctors() throws Exception {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();	
		Doctor doctor = new Doctor(1, "drMario", "HereWeGo!", "Pediatrician", drAppointments);
		Doctor anotherdoc = new Doctor(2, "drLuigi", "MammaMia!", "Psychiatrist", drAppointments);
		
		List<Doctor> alldocs = new ArrayList<Doctor>();
		alldocs.add(doctor);
		alldocs.add(anotherdoc);
		
		Mockito.when(dserv.getAllDoctors()).thenReturn(alldocs);
		
		ResultActions ra = mvc.perform(get("/doctors"));
		ra.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void getAllPatientsByDoctor() throws Exception {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();	
		Doctor doctor = new Doctor(1, "drMario", "HereWeGo!", "Pediatrician", drAppointments);
		
		Patient patient = new Patient(1, "princessPeach", "OkeyDokey", 23, 5, 105, "O");
		Patient toad = new Patient(2, "Toad", "Bingo!I'mthebest", 5, 3.31, 77.1618, "A");
		
		Appointment appointment = new Appointment(1, "nose running, coughing, heavy breathing & fever", "reserved", LocalDateTime.now(), "", "", "zoom.com", doctor, toad);
		Appointment anotherAppointment = new Appointment(2, "hallucinations, deliria", "reserved", LocalDateTime.now(), "", "", "zoom.com", doctor, patient);
		
		Mockito.when(dserv.getDoctorById(1)).thenReturn(doctor);
		
		ResultActions ra = mvc.perform(get("/doctors/1/patients"));
		ra.andExpect(status().is2xxSuccessful());
	}	
	
	@Test
	void getAppointmentsByDoctor() throws Exception {
		
		List<Appointment> drAppointments = new ArrayList<Appointment>();	
		Doctor doctor = new Doctor(1, "drMario", "HereWeGo!", "Pediatrician", drAppointments);
		
		Patient patient = new Patient(1, "princessPeach", "OkeyDokey", 23, 5, 105, "O");
		Patient toad = new Patient(2, "Toad", "Bingo!I'mthebest", 5, 3.31, 77.1618, "A");
		
		Appointment appointment = new Appointment(1, "nose running, coughing, heavy breathing & fever", "reserved", LocalDateTime.now(), "", "", "zoom.com", doctor, toad);
		Appointment anotherAppointment = new Appointment(2, "hallucinations, deliria", "reserved", LocalDateTime.now(), "", "", "zoom.com", doctor, patient);
		
		drAppointments.add(appointment);
		drAppointments.add(anotherAppointment);
		
		Mockito.when(dserv.getDoctorById(1)).thenReturn(doctor);
		
		ResultActions ra = mvc.perform(get("/doctors/1/appointments"));
		ra.andExpect(status().is2xxSuccessful());
	}

}
