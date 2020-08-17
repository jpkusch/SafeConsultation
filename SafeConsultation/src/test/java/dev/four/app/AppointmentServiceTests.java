package dev.four.app;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.repositories.AppointmentRepository;
import dev.four.services.AppointmentService;
import dev.four.services.AppointmentServiceImpl;


@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = dev.four.services.AppointmentServiceImpl.class)
class AppointmentServiceTests {

	
	@MockBean 
	AppointmentRepository ar;
	
	@Autowired
	AppointmentServiceImpl as;
	

	@Test
	@Order(1)
	void createAppointment() {
		Doctor doctor = new Doctor(1, "Dr. Mario", "Mariopass", "Cardiologist", new ArrayList<Appointment>());
		Patient patient = new Patient(2, "John", "Johnpass", 30, 5.6, 170.1, "A");
		LocalDateTime date = LocalDateTime.now();
		Appointment appointment = new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient);
		Mockito.when(as.createAppointment(appointment)).thenReturn(new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient));		
		Appointment app = as.createAppointment(appointment);
		Assertions.assertEquals(app.getAid(), 1);
	}
	
	@Test
	@Order(2)
	void getAppointmentById() {
		Doctor doctor = new Doctor(1, "Dr. Mario", "Mariopass", "Cardiologist", new ArrayList<Appointment>());
		Patient patient = new Patient(2, "John", "Johnpass", 30, 5.6, 170.1, "A");
		LocalDateTime date = LocalDateTime.now();
		Appointment appointment = new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient);
		Mockito.when(ar.findById(1)).thenReturn(Optional.of(appointment));		
		Appointment app = as.getAppointmentById(1);
		Assertions.assertEquals(app.getAid(), 1);

	}
	
	@Test
	@Order(2)
	void updateAppointment() {
		Doctor doctor = new Doctor(1, "Dr. Mario", "Mariopass", "Cardiologist", new ArrayList<Appointment>());
		Patient patient = new Patient(2, "John", "Johnpass", 30, 5.6, 170.1, "A");
		LocalDateTime date = LocalDateTime.now();
		Appointment appointment = new Appointment(1, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient);
		Mockito.when(as.updateAppointment(appointment)).thenReturn(new Appointment(2, "cough", "submit", date, "Not diagnosed", "Nothing", "link", doctor, patient));		
		Appointment app = as.updateAppointment(appointment);
		Assertions.assertEquals(app.getAid(), 2);
	}

}
