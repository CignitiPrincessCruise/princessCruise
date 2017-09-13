package com.princessCruise.web.automation.pages.polarBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;


/**
 * The Class HomePage.
 */
public class HomePage {
	
	/** The month year. */
	public static By month_Year = By.id("month");
	
	/** The destination. */
	public static By destination = By.id("destination");
	
	/** The Departure end port. */
	public static By Departure_EndPort = By.id("port");
	
	/** The Cruise length. */
	public static By CruiseLength = By.id("duration");
	
	/** The viewresultsbtn. */
	public static By viewresultsbtn = By.id("view-results");
	
	/** The cruisedetailsbtn. */
	public static By cruisedetailsbtn = By.id("select-cruise-details-S813N");

	
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The test case status. */
	public Boolean testCaseStatus = false;
	
	/** The test case failure reason. */
	public String testCaseFailureReason = "";
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	
	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public HomePage(WebDriver driver)
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

	/**
	 * Timeout.
	 *
	 * @param time the time
	 * @return the optional
	 */
	public Optional<Long> timeout(Integer time)
	{
		return Optional.of(Long.parseLong(String.valueOf(time)));
	}
	
	/**
	 * Test case status.
	 *
	 * @param status the status
	 * @param reason the reason
	 */
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}
	
	
	/**
	 * Select the data from month year drop down.
	 *
	 * @param inputdata the inputdata
	 */
	public void SelectTheDataFromMonthYearDropDown(String inputdata){
		try {
				actionLib.selectByVisibleText(month_Year, inputdata, "Month / Year: Any");	
				extentLogs.pass("Select value from Month/year drop down","Successfully selected the value from Month/year drop down");
			} catch (Throwable e) {
				e.printStackTrace();
				testCaseStatus = false;
				testCaseFailureReason = "Failed to the select the "+inputdata+"";
				TestCaseStatus(testCaseStatus,testCaseFailureReason);
				extentLogs.fail("Select value from Month/year drop down","Selecting the value from Month/year drop down is unsuccessful");
			}
	}
	
	/**
	 * Select the data from destination year drop down.
	 *
	 * @param inputdata the inputdata
	 */
	public void SelectTheDataFromDestinationYearDropDown(String inputdata){
			try {
				actionLib.selectByVisibleText(destination, inputdata, "Destination: Any");	
				extentLogs.pass("Select value from Destination drop down","Successfully selected the value from Destination drop down");				
			} catch (Throwable e) {
				e.printStackTrace();
				testCaseStatus = false;
				testCaseFailureReason = "Failed to the select the "+inputdata+"";
				extentLogs.fail("Select value from Destination drop down","Selecting the value from Destination drop down is Unsuccessful");
			}
	}
	
	/**
	 * Select the data from departure end drop down.
	 *
	 * @param inputdata the inputdata
	 */
	public void SelectTheDataFromDepartureEndDropDown(String inputdata){
			try {
				actionLib.selectByVisibleText(Departure_EndPort, inputdata, "Departure / End Port: Any");		
				extentLogs.pass("Select value from Departure drop down","Successfully selected the value from Departure drop down");
			} catch (Throwable e) {
				e.printStackTrace();
				testCaseStatus = false;
				testCaseFailureReason = "Failed to the select the "+inputdata+"";
				TestCaseStatus(testCaseStatus,testCaseFailureReason);
				extentLogs.fail("Select value from Departure drop down","Selecting the value from Departure drop down is Unsuccessful");
			}
	}
	
	/**
	 * Select the data from cruise length drop down.
	 *
	 * @param inputdata the inputdata
	 */
	public void SelectTheDataFromCruiseLengthDropDown(String inputdata){
			try {
				actionLib.selectByVisibleText(CruiseLength, inputdata, "Cruise Length: Any");	
				extentLogs.pass("Select value from Cruise Length drop down","Successfully selected the value from Cruise Length drop down");
			} catch (Throwable e) {
				e.printStackTrace();
				testCaseStatus = false;
				testCaseFailureReason = "Failed to the select the "+inputdata+"";
				extentLogs.fail("Select value from Cruise Length drop down","Selected the value from Cruise Length drop down is Unsuccessful");
			}			
	}

		
	/**
	 * Verify button presence.
	 *
	 * @param cruisedetails the cruisedetails
	 */
	public void VerifyButtonPresence(By cruisedetails){
		actionLib.WebdriverWaitForPage();
		if (actionLib.IsElementVisible(cruisedetailsbtn)) {
			extentLogs.pass("CruiseDetails Button Found","CruiseDetails Button found the in the Search Results Page");
		}else{
			extentLogs.fail( "CruiseDetails Button Not Found","CruiseDetails Button Not found the in the Search Results Page");
		} 
	}
	
	

	
} 
		
	

	

	
	
