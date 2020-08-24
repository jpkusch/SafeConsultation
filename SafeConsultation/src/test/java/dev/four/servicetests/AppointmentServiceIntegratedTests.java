package dev.four.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.services.AppointmentService;
import dev.four.services.DoctorService;
import dev.four.services.PatientService;

@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
@TestMethodOrder(OrderAnnotation.class) 
@Transactional
class AppointmentServiceIntegratedTests {

	@Autowired
	AppointmentService aserv;
	
	@Autowired
	DoctorService dserv;
	
	@Autowired
	PatientService pserv;
	
	@Test
	@Order(1)
	@Rollback
	void createAppointment() {
		Doctor doctor = dserv.getDoctorById(1);
		Patient patient = pserv.getPatientById(1);
		
		Appointment appointment = new Appointment(0, "cold", "reserved", LocalDateTime.now(), "", "", "zoommeeting.com", doctor, patient);
		aserv.createAppointment(appointment);
		
		Assertions.assertNotEquals(appointment.getAid(), 0);
	}
	
	@Test
	@Order(2)
	@Rollback
	void getAppointmentById() {		
		Appointment appointment = aserv.getAppointmentById(3);
		Assertions.assertEquals(appointment.getStatus(), "reserved");
		Assertions.assertEquals(appointment.getDoctor().getDid(), 3);
		Assertions.assertEquals(appointment.getPatient().getPid(), 4);
	}

	@Test
	@Order(3)
	@Rollback
	void updateAppointment() {		
		Appointment appointment = aserv.getAppointmentById(3);
		appointment.setStatus("cancelled");
		appointment = aserv.updateAppointment(appointment);
		Assertions.assertEquals(appointment.getStatus(), "cancelled");
	}
	
}
