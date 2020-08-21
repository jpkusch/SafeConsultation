package dev.four.runners;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import dev.four.pages.DoctorPage;
import dev.four.pages.LoginPage;
import dev.four.pages.PatientPage;

public class DoctorPageCucumberTests {

	public static WebDriver driver;
	public static LoginPage loginpage;
	public static DoctorPage doctorpage;
	public static PatientPage patientpage;

	@BeforeClass
	public static void setUp() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		loginpage = new LoginPage(driver);
		doctorpage = new DoctorPage(driver);
		patientpage = new PatientPage(driver);
	}

	@Test
	public void doctorUpdateAppointment() {

		driver.get("http://localhost:4200/login");
		loginpage.doctorButton.click();
		loginpage.usernameField.sendKeys("drMario");
		loginpage.passwordField.sendKeys("HereWeGo!");
		loginpage.loginButton.click();

		doctorpage.DoctorAppointmentButton.click();
		Assert.assertEquals(doctorpage.doctorTable.isDisplayed(), true);
		doctorpage.ViewMore.click();
		Assert.assertEquals(doctorpage.DoctorViewMorePopup.isDisplayed(), true);
		doctorpage.doctorCancelBtn.click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(doctorpage.DoctorStatus.getText(), "Cancelled");
	}

	@Test
	public void doctorWantsToViewPatientInfo() {
		
	    driver.get("http://localhost:4200/login");
	    loginpage.doctorButton.click();
	    loginpage.usernameField.sendKeys("drMario");
	    loginpage.passwordField.sendKeys("HereWeGo!");
	    loginpage.loginButton.click();
	
			
		doctorpage.DoctorPatientsButton.click();
		Assert.assertEquals(doctorpage.DoctorPatientTab.isDisplayed(), true);
		Assert.assertEquals(doctorpage.FirstPatiant.getText(), "Toad");
	}
	
	@Test
	public void doctorWantsToUpdateSpecialty() {
		
	    driver.get("http://localhost:4200/login");
	    loginpage.doctorButton.click();
	    loginpage.usernameField.sendKeys("drMario");
	    loginpage.passwordField.sendKeys("HereWeGo!");
	    loginpage.loginButton.click();
			
		doctorpage.DoctorAccountButton.click();
		doctorpage.specialtyDoctor.clear();
		doctorpage.specialtyDoctor.sendKeys("Pediatrition");
		doctorpage.updateAccountDoctor.click();
		Assert.assertEquals(doctorpage.specialtyDoctor.getAttribute("value"), "Pediatrition");

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
