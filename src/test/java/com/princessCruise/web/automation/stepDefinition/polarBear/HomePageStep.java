package com.princessCruise.web.automation.stepDefinition.polarBear;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.fileutils.ExcelReader;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.polarBear.SearchLandingPage;
import com.princessCruise.web.automation.pages.polarBear.HomePage;
import com.princessCruise.web.automation.utilities.CommonVariables;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * The Class PB001_HomePage.
 */
@CucumberOptions(features="C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\src\\test\\resources\\testFeature\\polarBear\\HomePage.feature",plugin = "json:C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\target\\cucumber-report-composite.json")
public class HomePageStep extends TestEngineWeb{
	
	/** The Home pg. */
	private HomePage HomePg;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The App url. */
	private String MonthYear, Destination, DepartureEndPort, CruiseLength, AppUrl;
	
	/** The sheet path. */
	protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/polarBear/polarBear.xlsx";
	
	/** The sheet name. */
	protected String sheetName = "HomePage";
	
	/** The testdata. */
	Map<String, List<String>> testdata = null;
	
	/** The extent logs. */
	private ExtentLogs extentLogs = new ExtentLogs();
	

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
	 * Home page.
	 */
	@Test(groups = "smoke", description = "Home page")
    public void HomePage() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }

	/**
	 * After.
	 *
	 * @param scenario the scenario
	 */
	@After
	public void after(Scenario scenario){
		System.out.println("This is after scenario: "+ scenario.getName().toString());
		extentLogs.info(scenario.getName().toString()+" Scenario", "Ends");
	}

	/**
	 * Before method.
	 *
	 * @param scenario the scenario
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Before
	public void beforeMethod(Scenario scenario) throws IOException {
		scenario.getId();
		System.out.println("This is before scenario: "+ scenario.getName().toString());
		extentLogs.info(scenario.getName().toString()+" Scenario", "Starts");
		this.MonthYear = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "month_Year");
		this.Destination = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "destination");
		this.DepartureEndPort = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Departure_EndPort");
		this.CruiseLength = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Cruise_Length");
		this.AppUrl = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "URL");
		HomePg = new HomePage(CommonVariables.CommonDriver.get());
		actionLib = CommonVariables.getActionLib();
	}	

	/**
	 * User navigates to home page.
	 *
	 * @throws Throwable the throwable
	 */
	
	@Given("^Navigate to www\\.princess\\.com and validate text on the home page")
	public void navigate_to_www_princess_com() throws Throwable {
		 
		actionLib.isTextPresentOnPage("Princess Cruises");
	}
	
	
	/**
	 * Click month year any drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click Month/Year: Any Drop Down$")
	public void click_Month_Year_Any_Drop_Down() throws Throwable {
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(HomePage.month_Year));
	}
	
	/**
	 * Fills the month year details.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^fills the Month/Year details$")
	public void fills_the_Month_Year_details() throws Throwable {
		HomePg.SelectTheDataFromMonthYearDropDown(MonthYear);
	}

	/**
	 * Click destination any drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click Destination: Any Drop Down$")
	public void click_Destination_Any_Drop_Down() throws Throwable {
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(HomePage.destination));
	}

	/**
	 * Fills the destination details.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^fills the Destination details$")
	public void fills_the_Destination_details() throws Throwable {
		HomePg.SelectTheDataFromDestinationYearDropDown(Destination);
	}
	
	/**
	 * Click departure end port.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click Departure/End Port$")
	public void click_Departure_End_Port() throws Throwable {
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(HomePage.Departure_EndPort));
	}
	
	/**
	 * Fills the departure end details.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^fills the Departure/End details$")
	public void fills_the_Departure_End_details() throws Throwable {
		HomePg.SelectTheDataFromDepartureEndDropDown(DepartureEndPort);
	}

	/**
	 * Click on cruise length any.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Cruise Length: Any$")
	public void click_on_Cruise_Length_Any() throws Throwable {
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(HomePage.CruiseLength));
	}

	/**
	 * Fills the cruise length details.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^fills the Cruise Length details$")
	public void fills_the_Cruise_Length_details() throws Throwable {
		HomePg.SelectTheDataFromCruiseLengthDropDown(CruiseLength);
	}
	
	/**
	 * Click view results button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click 'View Results' Button$")
	public void click_View_Results_Button() throws Throwable {
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(HomePage.viewresultsbtn));
		if(actionLib.IsElementDisplayInCurrentView(SearchLandingPage.btnpopUpClose)) {
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnpopUpClose));
		}
	}

	/**
	 * Validate text on the results page.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^validate cruise details button on the Results page$")
	public void validate_cruise_details_button_on_the_Results_page() throws Throwable {
		HomePg.VerifyButtonPresence(HomePage.cruisedetailsbtn);
	}

	
}

