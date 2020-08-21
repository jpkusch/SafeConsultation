package dev.four.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {
	
	WebDriver driver;
	
	public PatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="browseDrs")
	public WebElement doctorsTabButton;
	
	@FindBy(id="docsTab")
	public WebElement docsTab;
	
	@FindBy(id="doc2")
	public WebElement tomakeApptButton;
	
	@FindBy(id="makeApptSection")
	public WebElement makeApptSection;
	
	@FindBy(id="symptomsfield")
	public WebElement symptomsfield;
	
	@FindBy(id="dateTime")
	public WebElement dateTime;
	
	@FindBy(id="createAppt")
	public WebElement createAppt;
	
	@FindBy(id="acctInfo")
	public WebElement acctInfoButton;
	
	@FindBy(id="goToAppts")
	public WebElement apptsTabButton;
	
	@FindBy(id="userInfo")
	public WebElement userInfo;
	
	@FindBy(id="doc2")
	public WebElement appMoreInfoButton;
	
	@FindBy(id="viewmore")
	public WebElement updateApptPopUp;
	
	@FindBy(id="cancelApptButton")
	public WebElement cancelApptButton;
	
	
	@FindBy(id="apptStatus")
	public WebElement apptStatus;
	
	@FindBy(id="goToUpdate")
	public WebElement goToUpdateButton;
	
	@FindBy(id="infoToUpdate")
	public WebElement infoToUpdate;
	
	@FindBy(id="enteredblood")
	public WebElement bloodTypeField;
	
	@FindBy(id="updateUserInfo")
	public WebElement updateButton;
	
	@FindBy(id="bloodType")
	public WebElement bloodType;
	
	// Other Objects
	@FindBy(id="patientTitle")
	public WebElement patientTitle;
}
