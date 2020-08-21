package dev.four.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.four.pages.PatientPage;
import dev.four.runners.Runner;

public class PatientSteps {
	
	public static PatientPage patientpage = Runner.patientpage;
	public static WebDriver driver = Runner.driver;
	
	@When("^The User clicks the doctor tab button$")
	public void the_User_clicks_the_doctor_tab_button() throws Throwable {
	    patientpage.doctorsTabButton.click();
	}

	@Then("^The doctor tab is open$")
	public void the_doctor_tab_is_open() throws Throwable {
		Assert.assertTrue(patientpage.docsTab.getAttribute("innerHTML").equals("Browse Doctors"));
	}

	@When("^The User clicks the make an appointment button$")
	public void the_User_clicks_the_make_an_appointment_button() throws Throwable {
	    patientpage.tomakeApptButton.click();
	}

	@Then("^The make appointment popup appears$")
	public void the_make_appointment_popup_appears() throws Throwable {
		Assert.assertTrue(patientpage.makeApptSection.getAttribute("innerHTML").equals("Make an Appointment"));
	}

	@When("^The User types \"([^\"]*)\" into the symptoms field$")
	public void the_User_types_into_the_symptoms_field(String arg1) throws Throwable {
	    patientpage.symptomsfield.sendKeys(arg1);
	}
	
	@When("^The User selects the date for the appointment$")
	public void the_User_selects_the_date_for_the_appointment() throws Throwable {
	    patientpage.dateTime.sendKeys("8/20/2020");
	}

	@When("^The User clicks the submit make appointment button$")
	public void the_User_clicks_the_submit_make_appointment_button() throws Throwable {
	    patientpage.createAppt.click();
	}


	@Then("^An alert pops up to confirm appointment$")
	public void an_alert_pops_up_to_confirm_appointment() throws Throwable {
		Assert.assertTrue(driver.switchTo().alert().getText().equals("Your appointment has been booked!"));
		
	}
	
	@Given("^The User is on the Patient Page$")
	public void the_User_is_on_the_patient_page() throws Throwable {
		patientpage.acctInfoButton.click();
	}
	
	@When("^The User clicks the appointment tab button$")
	public void the_User_clics_the_appointment_tab_button() throws Throwable {
		patientpage.apptsTabButton.click();
	}
	
	@Then("^The appointments tab is open$")
	public void the_appointment_tab_is_open() throws Throwable {
		Assert.assertTrue(patientpage.userInfo.getAttribute("innerHTML").equals("User Information"));
	}
	
	@When("^The User clicks the more info button$")
	public void the_User_clicks_the_more_info_button() throws Throwable {
		patientpage.appMoreInfoButton.click();
	}
	
	@Then("^The update appointment popup appears$")
	public void the_update_appointment_popup_appears() throws Throwable {
		Assert.assertTrue(patientpage.updateApptPopUp.getAttribute("innerHTML").equals("View More"));
	}
	
	@When("^The User clicks cancel appointment$")
	public void the_User_clicks_cancel_appointment() throws Throwable {
		patientpage.cancelApptButton.click();
	}
	
	@When("^The user confirms cancel$")
	public void the_User_confirms_cancel() throws Throwable {
		driver.switchTo().alert().accept();
	}
	
	@Then("^Appointment has status cancelled$")
	public void appointment_has_status_cancelled() throws Throwable {
		Assert.assertTrue(patientpage.apptStatus.getAttribute("innerHTML").equals("Status: Cancelled"));
	}
	
	@Given("^The User is on the Patient Page again$")
	public void the_User_is_on_the_patient_page_again() throws Throwable {
		patientpage.acctInfoButton.click();
	}
	
	@When("^The User clicks the update info button$")
	public void the_User_clicks_the_update_info_button() throws Throwable {
		patientpage.goToUpdateButton.click();
	}
	
	
	@Then("^The account info tab is open$")
	public void the_account_info_tab_is_open(String arg1) throws Throwable {
		Assert.assertTrue(patientpage.infoToUpdate.getAttribute("innerHTML").equals("User Information"));
	}
	
	@When("^The User types \"([^\"]*)\" into the blood type field$")
	public void the_User_types_into_the_blood_type_field(String arg1) throws Throwable {
		patientpage.bloodTypeField.sendKeys(arg1);
	}

	@When("^The User clicks the update button$")
	public void the_User_clicks_the_update_button() throws Throwable {
		patientpage.updateButton.click();
	}

	@Then("^The User's blood type is \"([^\"]*)\"$")
	public void the_User_s_blood_type_is(String arg1) throws Throwable {
		Assert.assertTrue(patientpage.bloodType.getAttribute("innerHTML").equals("AB+"));
	}

}
