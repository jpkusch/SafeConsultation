package dev.four.app;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.four.controllers.AppointmentController;
import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.AppointmentService;
import dev.four.services.AppointmentServiceImpl;


@AutoConfigureMockMvc
@SpringBootTest(classes = dev.four.controllers.AppointmentController.class)
class AppointmentControllerTests {

	@MockBean 
	AppointmentService as;
	
	@Autowired
	MockMvc mvc; 
	
	
	/*@Test
	@Order(1)
	void createAppointment() throws Exception {
		Doctor doctor = new Doctor(1, "Dr. Mario", "Mariopass", "Cardiologist", new ArrayList<Appointment>());
		Patient patient = new Patient(2, "John", "Johnpass", 30, 5.6, 170.1, 'A');
		LocalDateTime date = LocalDateTime.now();
		Appointment appointment = new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient);
		
		Mockito.when(as.createAppointment(appointment)).thenReturn(new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient));			
		
		ResultActions ra = mvc.perform(post("/appointments").contentType
				(MediaType.APPLICATION_JSON)
				//content("{"aid":1,"symptoms":"cough","status":"submit","aptTime":"date","diagnosis":"Not diagnosed","treatment":"Nothing","meetingLink":"link","doctor":"doctor","patient":"patient"}")
				.content("1, cough, submit, date, Not diagnosed, Nothing, link, doctor, patient")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
				
		
		//ra.andExpect(content().string("1, cough, submit, date, Not diagnosed, Nothing, link, doctor, patient"));
		
		

	}*/
	
	@Test
	@Order(2)
	
	void getAppointmentById() throws Exception {
		Doctor doctor = new Doctor(1, "Dr. Mario", "Mariopass", "Cardiologist", new ArrayList<Appointment>());
		Patient patient = new Patient(2, "John", "Johnpass", 30, 5.6, 170.1, 'A');
		LocalDateTime date = LocalDateTime.now();
		//Appointment appointment = new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient);
		
		Mockito.when(as.getAppointmentById(1)).thenReturn(new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient));
		

		ResultActions ra = mvc.perform(get("/appointments/1"));
		ra.andExpect(status().isOk());

	}
	
	@Test
	@Order(2)
	void updateAppointment() throws Exception {
		ResultActions ra = mvc.perform(post("/appointments"));
		ra.andExpect(status().isOk());
	}

}
