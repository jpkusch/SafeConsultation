package dev.four.servicetests;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import dev.four.repositories.DoctorRepository;
import dev.four.services.DoctorService;

@TestMethodOrder(OrderAnnotation.class)
public class DoctorServiceIntegratedTests {
	


}
