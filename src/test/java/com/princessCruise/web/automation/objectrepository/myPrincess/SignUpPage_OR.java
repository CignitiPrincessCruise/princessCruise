package com.princessCruise.web.automation.objectrepository.myPrincess;

import org.openqa.selenium.By;

public class SignUpPage_OR {
	public static By iFrameSignUp= By.xpath(".//*[@class='mfp-iframe']");
	public static By iFrameSignUPCongratulations = By.xpath(".//*[@class='mfp-iframe']");	
	public static By txtFirstName = By.id("firstName");
	public static By txtLastName = By.id("lastName");
	public static By txtEmailId = By.id("email");
	public static By chkDestination = By.name("q212");
	public static By radTravelAgent = By.xpath(".//*[@name='q194']");
	public static By btnSendMeOffers = By.id("special-offers-btn");
	public static By btnContinue = By.xpath(".//*[@id='continue-to-reg']");
	//error messages objects
	public static By errFirstname = By.xpath(".//*[@class='invalid form-field-msg'][@for='firstName']");
	public static By errLastname = By.xpath(".//*[@class='invalid form-field-msg'][@for='lastName']");
	public static By errEmail = By.xpath(".//*[@class='invalid form-field-msg']");

}
