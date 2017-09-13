package com.princessCruise.web.automation.pages.polarVision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

/**
 * The Class Dashboard.
 */
public class Dashboard {
	
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	
	/**
	 * Instantiates a new dashboard.
	 *
	 * @param driver the driver
	 */
	public Dashboard(WebDriver driver)
	{
		if(CommonVariables.getDriver()==null){
			CommonVariables.setDriver(driver);
		}
		actionLib = CommonVariables.getActionLib();
		try {
			if(!ConfigManager.ArePropertiesSet.get()){
				ConfigManager.setProperties();
				ConfigManager.UpdateProperties();
			}
		} 
		catch (Exception e) {
			System.out.println("Failed to load Properties file");
		}
	}
	
	/** The txt box username. */
	public static By txtBoxUsername = By.xpath("//input[@class='form-control userid ember-text-field ember-view']");
	
	/** The txt box password. */
	public static By txtBoxPassword = By.xpath("//input[@class='form-control password ember-text-field ember-view']");
	
	/** The btn sign in. */
	public static By btnSignIn = By.xpath("//button[contains(text(),'Sign In')]");

	/**
	 * Enter username and password.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void enterUsernameAndPassword(String username,String password){
		try {
			//actionLib.waitForVisibilityOfElement(txtBoxUsername, "Waiting Page After Cliking on Search Button", 30000);
			actionLib.type(CommonVariables.CommonDriver.get().findElement(txtBoxUsername), username);
			//actionLib.waitForVisibilityOfElement(txtBoxPassword, "Waiting Page After Cliking on Search Button", 3000);
			actionLib.type(CommonVariables.CommonDriver.get().findElement(txtBoxPassword), password);
			extentLogs.pass("Username and Password", "Successfully Entered Username and Password");
		} catch (Throwable e) {
			extentLogs.fail("Username and Password", "Unable to Enter Username and Password");
			e.printStackTrace();
		}
	}
	
	/**
	 * Click on sign in button.
	 */
	public void clickOnSignInButton(){
		try {
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnSignIn), "Username");
			extentLogs.pass("Sign In Button", "Successfully Clicked on Sign In Button");
		} catch (Throwable e) {
			extentLogs.fail("Sign In Button", "Unable to Perform Click Operation Sign In Button");
			e.printStackTrace();
		}
	}

}
