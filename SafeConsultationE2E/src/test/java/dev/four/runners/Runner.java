package dev.four.runners;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.four.pages.DoctorPage;
import dev.four.pages.LoginPage;
import dev.four.pages.PatientPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue="dev.four.steps")
public class Runner {

	public static WebDriver driver;
	public static LoginPage loginpage;
	public static DoctorPage doctorpage;
	public static PatientPage patientpage;

	@BeforeClass
	public static void setUp() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage = new LoginPage(driver);
		doctorpage = new DoctorPage(driver);
		patientpage = new PatientPage(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
