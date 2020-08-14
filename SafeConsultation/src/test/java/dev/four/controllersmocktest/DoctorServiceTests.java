package dev.four.controllersmocktest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;

import dev.four.services.DoctorService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.four.app.SafeConsultationApplication.class)
class DoctorServiceTests {
	
	@MockBean
	DoctorService dserv;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void createDoctor() {
		fail("Not yet implemented");
	}
	
	@Test
	void getDoctorById() {
		fail("Not yet implemented");
	}
	
	@Test
	void getAllDoctors() {
		fail("Not yet implemented");
	}
	
	@Test
	void getAllPatientsByDoctor() {
		fail("Not yet implemented");
	}
	
	@Test
	void updateDoctor() {
		fail("Not yet implemented");
	}
	
	@Test
	void logInDoctor() {
		fail("Not yet implemented");
	}

}
