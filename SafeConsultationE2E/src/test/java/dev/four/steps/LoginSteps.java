package dev.four.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.four.pages.DoctorPage;
import dev.four.pages.LoginPage;
import dev.four.pages.PatientPage;
import dev.four.runners.Runner;

public class LoginSteps {
	
	public static LoginPage loginpage = Runner.loginpage;
	public static DoctorPage doctorpage = Runner.doctorpage;
	public static PatientPage patientpage = Runner.patientpage;
	public static WebDriver driver = Runner.driver;
	
	@Given("^The User is on the login page$")
	public void the_User_is_on_the_login_page() throws Throwable {
		driver.get("http://localhost:4200/login");
	}

	@When("^The User clicks the patient button$")
	public void the_User_clicks_the_patient_button() throws Throwable {
	    loginpage.patientButton.click();
	}

	@When("^The User clicks the signup button$")
	public void the_User_clicks_the_signup_button() throws Throwable {
	    loginpage.signupPageButton.click();
	}

	@Then("^The signup page is open$")
	public void the_signup_page_is_open() throws Throwable {
	    Assert.assertTrue(loginpage.signupTitle.getAttribute("innerHTML").equals("Signup Page"));
	}

	@When("^The User types \"([^\"]*)\" into the create username field$")
	public void the_User_types_into_the_create_username_field(String arg1) throws Throwable {
	    loginpage.usernameField.sendKeys(arg1);
	}

	@When("^The User types \"([^\"]*)\" into the create password field$")
	public void the_User_types_into_the_create_password_field(String arg1) throws Throwable {
	    loginpage.passwordField.sendKeys(arg1);
	}

	@When("^The User types \"([^\"]*)\" into the create age field$")
	public void the_User_types_into_the_create_age_field(String arg1) throws Throwable {
	    loginpage.ageField.sendKeys(arg1);
	}
	
	@When("^The User types \"([^\"]*)\" into the create weight field;$")
	public void the_User_types_into_the_create_weight_field(String arg1) throws Throwable {
	   loginpage.weightField.sendKeys(arg1);
	}

	@When("^The User types \"([^\"]*)\" into the create height field;$")
	public void the_User_types_into_the_create_height_field(String arg1) throws Throwable {
	    loginpage.heightField.sendKeys(arg1);
	}

	@When("^The User types \"([^\"]*)\" into the create blood type field;$")
	public void the_User_types_into_the_create_blood_type_field(String arg1) throws Throwable {
	    loginpage.bloodTypeField.sendKeys(arg1);
	}

	@When("^The User clicks the submit signup button$")
	public void the_User_clicks_the_submit_signup_button() throws Throwable {
		loginpage.signupButton.click();
	}

	@When("^The User types \"([^\"]*)\" into the login username field$")
	public void the_User_types_into_the_login_username_field(String arg1) throws Throwable {
	    loginpage.usernameField.sendKeys(arg1);
	}

	@When("^The User types \"([^\"]*)\" into the login password field$")
	public void the_User_types_into_the_login_password_field(String arg1) throws Throwable {
	    loginpage.passwordField.sendKeys(arg1);
	}

	@When("^The user clicks the login button$")
	public void the_user_clicks_the_login_button() throws Throwable {
	    loginpage.loginButton.click();
	}

	@When("^The User clicks the doctor button$")
	public void the_User_clicks_the_doctor_button() throws Throwable {
	    loginpage.doctorButton.click();
	}

	@When("^The User types \"([^\"]*)\" into the create specialty field$")
	public void the_User_types_into_the_create_specialty_field(String arg1) throws Throwable {
	    loginpage.specialtyField.sendKeys(arg1);
	}

	@Then("^The User is on the Doctor Page$")
	public void the_User_is_on_the_Doctor_Page() throws Throwable {
		Assert.assertTrue(doctorpage.doctorTitle.getAttribute("innerHTML").equals("Doctor Page"));
	}

	@Then("^The User is on the Patient Page$")
	public void the_User_is_on_the_Patient_Page() throws Throwable {
		Assert.assertTrue(patientpage.patientTitle.getAttribute("innerHTML").equals("Patient Page"));
	}
}
