package com.princessCruise.web.automation.stepDefinition.myPrincess;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.fileutils.ExcelReader;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.myPrincess.OverrideLocationPage;
import com.princessCruise.web.automation.pages.myPrincess.SignUpPage;
import com.princessCruise.web.automation.utilities.CommonVariables;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;
@CucumberOptions(features="C:\\Users\\E003597\\Downloads\\princessCruise\\princessCruise\\src\\test\\resources\\testFeature\\myPrincess\\SignUp.feature",plugin = "json:C:\\Users\\E003597\\Downloads\\princessCruise\\princessCruise\\target\\cucumber-report-composite.json")
public class MP001_SignUP extends TestEngineWeb{
	
	private SignUpPage signupPg;	
	private OverrideLocationPage orLocationPg;
	public ActionsLibrary actionLib;
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private String firstName, lastName, emailId, destination, locationURL;
	protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/myPrincess/myPrincess.xlsx";
	protected String sheetName = "MP001_SignUp";
	Map<String, List<String>> testdata = null;
	private ExtentLogs extentLogs = new ExtentLogs();
	
	/**_
	 * @author nikhil bharati
	 * @param status
	 * @param reason
	 */
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}
	
	@Test(groups = "smoke", description = "Sign up feature")
    public void signUP() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }

	@After
	public void after(Scenario scenario){
		System.out.println("This is after scenario: "+ scenario.getName().toString());
		extentLogs.info(scenario.getName().toString()+" Scenario", "Ends");
	}

	@Before("@SignUp")
	public void beforeMethod(Scenario scenario) throws IOException {
		scenario.getId();
		System.out.println("This is before scenario: "+ scenario.getName().toString());
		extentLogs.info(scenario.getName().toString()+" Scenario", "Starts");		
		this.firstName = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "FirstName");
		this.lastName = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "LastName");
		this.emailId = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "EmailID");
		this.destination = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Destination");
		this.locationURL = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "LocationUrl");
		signupPg = new SignUpPage(CommonVariables.CommonDriver.get());
		orLocationPg = new OverrideLocationPage(CommonVariables.CommonDriver.get());
		actionLib = CommonVariables.getActionLib();
	}
	@Given("^a user navigates to set location page$")
	public void a_user_navigates_to_set_location_page() throws Throwable {	
	 actionLib.OpenUrl(locationURL);	 
	}

	@Given("^leaves everything as default and click on Submit$")
	public void leaves_everything_as_default_and_click_on_Submit() throws Throwable {
		System.out.println(2); 
		orLocationPg.moveFromOverrideLocation();
	}

	@Given("^user clicks on Princess Cruices logo at the header$")
	public void user_clicks_on_Princess_Cruices_logo_at_the_header() throws Throwable {
		System.out.println(3); 
	}
	
	@Given("^user is on the the main home page$")
	public void user_is_on_the_the_main_home_page() throws Throwable {
		System.out.println(4); 
	}

	@When("^the user clicks on the \"([^\"]*)\" on the header$")
	public void the_user_clicks_on_the_on_the_header(String arg1) throws Throwable {
		System.out.println(5); 
	}

	@Then("^a light box window should appear on the browser$")
	public void a_light_box_window_should_appear_on_the_browser() throws Throwable {
		System.out.println(6); 
	}

	@Then("^when the user clicks on the \"([^\"]*)\" button, error message will be displayed at the top\\.$")
	public void when_the_user_clicks_on_the_button_error_message_will_be_displayed_at_the_top(String arg1) throws Throwable {
		System.out.println(7); 
	}

	/**
	 * @author nikhil bharati
	 * @throws Throwable
	 * @test case id: MP001_SignUP
	 */
	//@Test(description = "MP001_SignUP")
	public void MP_001_SignUP() throws Throwable {
		try {
			signupPg = new SignUpPage(CommonVariables.CommonDriver.get());
			signupPg.fillSignUp(firstName, lastName, emailId, destination);			
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Customer Search Using Customer#.";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("EM001CSUsingCustomerNo ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	}

}
