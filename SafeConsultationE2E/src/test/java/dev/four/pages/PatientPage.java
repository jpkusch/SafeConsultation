package dev.four.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {
	
	WebDriver driver;
	
	public PatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
