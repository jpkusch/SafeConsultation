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
	
	@FindBy(id="2")
	public WebElement tomakeApptButton;
	
	@FindBy(id="symptomsfield")
	public WebElement symptomsfield;
	
	@FindBy(id="dateTime")
	public WebElement dateTime;
	
	@FindBy(id="createAppt")
	public WebElement createAppt;
	
	

}
