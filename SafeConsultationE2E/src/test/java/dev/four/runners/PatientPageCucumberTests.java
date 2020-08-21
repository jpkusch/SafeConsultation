package dev.four.runners;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.four.pages.DoctorPage;
import dev.four.pages.LoginPage;
import dev.four.pages.PatientPage;

public class PatientPageCucumberTests {

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
	public void userCreatesAppointment() {
		driver.get("http://localhost:4200/login");
		loginpage.patientButton.click();
		loginpage.usernameField.sendKeys("Anna O.");
		loginpage.passwordField.sendKeys("Frozen");
		loginpage.loginButton.click();
		patientpage.doctorsTabButton.click();
		patientpage.tomakeApptButton.click();
		patientpage.symptomsfield.sendKeys("TestTest");
		patientpage.dateTime.sendKeys("8/20/2020");
		patientpage.createAppt.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		
		Assert.assertTrue(alert.getText().contains("Your appointment has been booked!"));	
	}
	
	@Test
	public void userUpdatesAppointment() throws InterruptedException {
		driver.get("http://localhost:4200/login");
		loginpage.patientButton.click();
		loginpage.usernameField.sendKeys("Anna O.");
		loginpage.passwordField.sendKeys("Frozen");
		loginpage.loginButton.click();
		patientpage.apptsTabButton.click();
		patientpage.appMoreInfoButton.click();
		patientpage.cancelApptButton.click();
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Appointment has been cancelled"));
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void userUpdatesAccountInfo() {
		driver.get("http://localhost:4200/login");
		loginpage.patientButton.click();
		loginpage.usernameField.sendKeys("Anna O.");
		loginpage.passwordField.sendKeys("Frozen");
		loginpage.loginButton.click();
		patientpage.goToUpdateButton.click();
		patientpage.bloodTypeField.sendKeys("AB+");
		patientpage.updateButton.click();
		Assert.assertTrue(patientpage.bloodType.getAttribute("innerHTML").contains("AB+"));
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
