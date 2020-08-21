package dev.four.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorPage {

	WebDriver driver;
	
	public DoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
<<<<<<< HEAD
	
	// Buttons
		@FindBy(name="patient")
		public WebElement patientButton;
		
		@FindBy(name="doctor")
		public WebElement doctorButton;
		
		@FindBy(id="loginBtn")
		public WebElement loginButton;
		
		@FindBy(id="loginPageBtn")
		public WebElement loginPageButton;
		
		@FindBy(id="DoctorAppointmentButton")
		public WebElement DoctorAppointmentButton;
		
		@FindBy(id="DoctorPatientsButton")
		public WebElement DoctorPatientsButton;
		
		@FindBy(id="DoctorAccountButton")
		public WebElement DoctorAccountButton;
		
		@FindBy(id="doc3")
		public WebElement ViewMore;
		
		@FindBy(id="doctorCancelBtn")
		public WebElement doctorCancelBtn;
		
		@FindBy(id="specialtyDoctor")
		public WebElement specialtyDoctor;
		
		@FindBy(id="updateAccountDoctor")
		public WebElement updateAccountDoctor;
		
		@FindBy(id="doctorTable")
		public WebElement doctorTable;
		
		@FindBy(id="doctortdstatus3")
		public WebElement DoctorSpecialty;
		
		@FindBy(id="DoctorViewMorePopup")
		public WebElement DoctorViewMorePopup;
		
		@FindBy(id="DoctorPatientTab")
		public WebElement DoctorPatientTab;
		
		@FindBy(id="trdc1")
		public WebElement FirstPatiant;
		
		
		
		
		
		// Fields
		@FindBy(id="usernameField")
		public WebElement usernameField;
		
		@FindBy(id="passwordField")
		public WebElement passwordField;
				
		// Other Objects
		@FindBy(id="signupTitle")
		public WebElement signupTitle;
		
=======
	// Other Objects
	@FindBy(id="doctorTitle")
	public WebElement doctorTitle;
>>>>>>> eefbd9a58debebbdfb82f9c748497efd60b7ce77

	
}
