package dev.four.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import dev.four.dtos.LoginDTO;
import dev.four.entities.Appointment;
import dev.four.entities.Doctor;
import dev.four.entities.Patient;
import dev.four.repositories.DoctorRepository;
import dev.four.services.DoctorService;

@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class) 
class DoctorServiceMockTests {	
	@MockBean
	DoctorRepository drepo;
	
	@Autowired
	DoctorService dserv;
	
	private Patient patient = new Patient(1, "FakePat", "FakerPass", 1000, 72, 458.00, "A+");
	private LocalDateTime time = LocalDateTime.now();
	
	private Doctor doctorToMake = new Doctor(0, "McFake", "Faker", "Fakiology", new ArrayList<Appointment>());
	private Doctor doctor = new Doctor(1, "McFake", "Faker", "Fakiology", new ArrayList<Appointment>());
	private Appointment docAppointment = new Appointment(1, "Cough", "Completed", time, "Cold", "Over the counter cold medicine", "meet.com", doctor, patient);
	private Doctor badDoctor = new Doctor(70, "McBad", "Bader", "Badiology", new ArrayList<Appointment>());
	private Doctor updateDoctor = new Doctor(0, "McFakerson", "Faker", "Fakiology", new ArrayList<Appointment>());
	private List<Doctor> allDoctors = new ArrayList<Doctor>();

	@Test
	void test() {
		List<Appointment> appt = doctor.getAppointments();
		appt.add(docAppointment);
		doctor.setAppointments(appt);
		Mockito.when(drepo.save(doctorToMake)).thenReturn(doctor);
		
		Mockito.when(drepo.findById(1)).thenReturn(Optional.of(doctor));
		Mockito.when(drepo.save(updateDoctor)).thenReturn(updateDoctor);
		
		Mockito.when(drepo.findByUsername("McFake")).thenReturn(doctor);
	}
	
	@Test
	void testCreate() {
		Mockito.when(drepo.save(doctorToMake)).thenReturn(doctor);
		Doctor doc = dserv.createDoctor(doctorToMake);
		Assertions.assertEquals(doc.getDid(), doctor.getDid());
		
	}
	
	@Test
	void testUpdate() {
		Mockito.when(drepo.save(updateDoctor)).thenReturn(updateDoctor);
		Doctor doc = dserv.updateDoctor(updateDoctor);
		Assertions.assertEquals(doc.getUsername(), updateDoctor.getUsername());
	}
	
	@Test
	void testGetById() {
		Mockito.when(drepo.findById(1)).thenReturn(Optional.of(doctor));
		Doctor doc = dserv.getDoctorById(1);
		Assertions.assertEquals(doc.getDid(), doctor.getDid());
	}
	
	@Test
	void testGetAllDoctors() {
		allDoctors.add(doctor);
		Mockito.when(drepo.findAll()).thenReturn(allDoctors);
		List<Doctor> doc = dserv.getAllDoctors();
		Assertions.assertEquals(doc.size(), allDoctors.size());
	}
	
	@Test
	void testLogin() {
		Mockito.when(drepo.findByUsername("McFake")).thenReturn(doctor);
		Doctor doc = dserv.logIn(new LoginDTO("McFake", "Faker"));
		Assertions.assertEquals(doc.getDid(), doctor.getDid());
	}
	
	@Test
	void testBadUsernameLogin() {
		Mockito.when(drepo.findByUsername("McFake")).thenReturn(doctor);
		Doctor doc = dserv.logIn(new LoginDTO("McReal", "Faker"));
		Assertions.assertNull(doc);
	}
	
	@Test
	void testBadPasswordLogin() {
		Mockito.when(drepo.findByUsername("McFake")).thenReturn(doctor);
		Doctor doc = dserv.logIn(new LoginDTO("McFake", "Fakest"));
		Assertions.assertNull(doc);
	}
	
	@Test
	void getAllPatientsByDoctor() {
		List<Appointment> appt = doctor.getAppointments();
		appt.add(docAppointment);
		doctor.setAppointments(appt);
		List<Patient> pat = dserv.getAllPatientsByDoctor(doctor);
		Assertions.assertEquals(pat.get(0).getPid(), patient.getPid());
	}
}
