package dev.four.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.four.pages.DoctorPage;
import dev.four.pages.LoginPage;
import dev.four.runners.Runner;

public class DoctorSteps {
	
	public static LoginPage loginpage = Runner.loginpage;
	public static DoctorPage doctorpage = Runner.doctorpage;
	public static WebDriver driver = Runner.driver;
	

	
/*	@Given("^The User is on the doctor page$")
	public void the_User_is_on_the_doctor_page() throws Throwable {
		
		driver.get("http://localhost:4200/doctor");
		
	}*/

	@When("^The User clicks the appointment tab button$")
	public void the_User_clicks_the_appointment_tab_button() throws Throwable {
	    doctorpage.DoctorAppointmentButton.click();
	}

	@Then("^The app tab is open$")
	public void the_appointments_tab_is_open() throws Throwable {
		Assert.assertEquals(doctorpage.doctorTable.isDisplayed(), true);
	}

	@When("^The User clicks the more info button$")
	public void the_User_clicks_the_more_info_button() throws Throwable {
		 doctorpage.ViewMore.click();
	}

	@Then("^The update appointments popup appears$")
	public void the_update_appointment_popup_appears() throws Throwable {
		Assert.assertEquals(doctorpage.DoctorViewMorePopup.isDisplayed(), true);
		
	}

	@When("^The User clicks cancel appointment$")
	public void the_User_clicks_cancel_appointment() throws Throwable {
		doctorpage.doctorCancelBtn.click();
		
	}

	@Then("^Appointment \"([^\"]*)\" has status cancelled$")
	public void appointment_has_status_cancelled(String arg1) throws Throwable {
		Assert.assertEquals(doctorpage.DoctorSpecialty.getText(), "Cancelled");
	}

	@When("^The User clicks the patient tab button$")
	public void the_User_clicks_the_patient_tab_button() throws Throwable {
		doctorpage.DoctorPatientsButton.click();
	}

	@Then("^The patient tab is open$")
	public void the_patient_tab_is_open() throws Throwable {
		Assert.assertEquals(doctorpage.DoctorPatientTab.isDisplayed(), true);
		
	}

	@Then("^the first patient is \"([^\"]*)\"$")
	public void the_first_patient_is(String arg1) throws Throwable {
		Assert.assertEquals(doctorpage.FirstPatiant.getText(), "Toad");
	}

	@When("^the User clicks the account information tab button$")
	public void the_User_clicks_the_account_information_tab_button() throws Throwable {
		doctorpage.DoctorAccountButton.click();
		
	}

	@When("^The User types \"([^\"]*)\" into the specialty field$")
	public void the_User_types_into_the_specialty_field(String arg1) throws Throwable {
		doctorpage.specialtyDoctor.sendKeys("Pediatrician");
		
	}

	@When("^The User click the update button$")
	public void the_User_click_the_update_button() throws Throwable {
		doctorpage.updateAccountDoctor.click();
	}

	@Then("^The User's specialty is \"([^\"]*)\"$")
	public void the_User_s_specialty_is(String arg1) throws Throwable {
		Assert.assertEquals(doctorpage.specialtyDoctor.getText(), "Pediatrician");
	}



}
