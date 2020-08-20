package dev.four.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Buttons
	@FindBy(name="patient")
	public WebElement patientButton;
	
	@FindBy(name="doctor")
	public WebElement doctorButton;
	
	@FindBy(id="signupBtn")
	public WebElement signupButton;
	
	@FindBy(id="signupPageBtn")
	public WebElement signupPageButton;
	
	@FindBy(id="loginBtn")
	public WebElement loginButton;
	
	@FindBy(id="loginPageBtn")
	public WebElement loginPageButton;
	
	
	
	// Fields
	@FindBy(id="usernameField")
	public WebElement usernameField;
	
	@FindBy(id="passwordField")
	public WebElement passwordField;
	
	@FindBy(id="ageField")
	public WebElement ageField;
	
	@FindBy(id="weightField")
	public WebElement weightField;
	
	@FindBy(id="heightField")
	public WebElement heightField;
	
	@FindBy(id="bloodTypeField")
	public WebElement bloodTypeField;
	
	@FindBy(id="specialtyField")
	public WebElement specialtyField;
	
	// Other Objects
	@FindBy(id="signupTitle")
	public WebElement signupTitle;
	
	@FindBy(id="loginTitle")
	public WebElement loginTitle;
	


}
