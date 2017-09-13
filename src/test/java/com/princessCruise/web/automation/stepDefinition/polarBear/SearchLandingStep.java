package com.princessCruise.web.automation.stepDefinition.polarBear;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.fileutils.ExcelReader;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.polarBear.SearchLandingPage;
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
 * The Class SearchLandingStep.
 */
@CucumberOptions(features="C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\src\\test\\resources\\testFeature\\polarBear\\SearchLanding.feature",plugin = "json:C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\target\\cucumber-report-composite.json")
public class SearchLandingStep extends TestEngineWeb{

	/** The search landingobj. */
	private SearchLandingPage searchLandingobj;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The location URL. */
	private String destination,departure,length,lengthofcrustour,Travelsequence,cruisecategory,ship,shipfrtour,itinerary,stateroom,guest,locationURL,def_dest,def_dep;
	
	/** The sheet path. */
	protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/polarBear/polarBear.xlsx";
	
	/** The sheet name. */
	protected String sheetName = "SearchResults";
	
	/** The testdata. */
	Map<String, List<String>> testdata = null;
	
	/** The extent logs. */
	private ExtentLogs extentLogs = new ExtentLogs();

	/**
	 * Search landing.
	 */
	@Test(groups = "smoke", description = "Search Landing page")
	public void SearchLanding() {
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
	@Before()
	public void beforeMethod(Scenario scenario) throws IOException {
		scenario.getId();
		System.out.println("This is before scenario: "+ scenario.getName().toString());
		extentLogs.info(scenario.getName().toString()+" Scenario", "Starts");		
		this.destination = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Destination");
		this.departure = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Departure");
		this.length = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Length");
		this.lengthofcrustour = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Lengthofcruisetour");
		this.Travelsequence = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Travelsequence");
		this.cruisecategory = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "CruiseCategory");
		this.ship = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Ship");
		this.shipfrtour = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "shiptour");
		this.itinerary = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Itinerary");
		this.stateroom = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Stateroom");
		this.locationURL = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Url");
		this.guest = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Guest");
		this.def_dest = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Default_Des");
		this.def_dep = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Default_Dep");
		searchLandingobj = new SearchLandingPage(CommonVariables.CommonDriver.get());
		actionLib = CommonVariables.getActionLib();
	}


	/**
	 * Launch princess cruises.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^Launch Princess Cruises$")
	public void launch_Princess_Cruises() throws Throwable {
		actionLib.OpenUrl(locationURL);
	}

	/**
	 * Click on plan A cruise.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^Click on Plan A Cruise$")
	public void click_on_Plan_A_Cruise() throws Throwable {
		searchLandingobj.clickOnPlanACruise();
	}

	/**
	 * Select the destination from destination drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the Destination from Destination DropDown$")
	public void select_the_Destination_from_Destination_DropDown() throws Throwable {
		searchLandingobj.selectDestination(destination);
	}

	/**
	 * Select the departure from departure drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the Departure from Departure Drop Down$")
	public void select_the_Departure_from_Departure_Drop_Down() throws Throwable {
		searchLandingobj.selectDeparturePort(departure);
	}

	/**
	 * Select the length of cruise from length cruise drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the Length of Cruise from Length Cruise Drop Down$")
	public void select_the_Length_of_Cruise_from_Length_Cruise_Drop_Down() throws Throwable {
		searchLandingobj.selectLengthOfCruise(length);
	}

	/**
	 * Click on show more otions.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Show More Otions$")
	public void click_on_Show_More_Otions() throws Throwable {
		searchLandingobj.clickOnShowMoreOptions();
	}

	/**
	 * Select ship from ship drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select Ship from Ship DropDown$")
	public void select_Ship_from_Ship_DropDown() throws Throwable {
		searchLandingobj.selectShip(ship);
	}

	/**
	 * Select ship from ship drop down in cruisetours tab.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select Ship from Ship DropDown in Cruisetours Tab$")
	public void Select_Ship_from_Ship_DropDown_in_Cruisetours_Tab() throws Throwable {
		searchLandingobj.selectShip(shipfrtour);
	}
	
	/**
	 * Select the itinerary port from itinerary port drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the Itinerary Port from Itinerary Port Drop Down$")
	public void select_the_Itinerary_Port_from_Itinerary_Port_Drop_Down() throws Throwable {
		searchLandingobj.selectItineraryPort(itinerary);
	}

	/**
	 * Select the stateroom from state room drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the Stateroom from StateRoom Drop Down$")
	public void select_the_Stateroom_from_StateRoom_Drop_Down() throws Throwable {
		searchLandingobj.selectStateroom(stateroom);
	}

	/**
	 * Select the no of guests from guests drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the No of Guests from  Guests Drop Down$")
	public void select_the_No_of_Guests_from_Guests_Drop_Down() throws Throwable {
		searchLandingobj.selectGuests(guest);
	}

	/**
	 * Select A month from the calender.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select A Month From the Calender$")
	public void select_A_Month_From_the_Calender() throws Throwable {
		searchLandingobj.clickOnTheMonth();
	}

	/**
	 * Click on view results button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on View Results Button$")
	public void click_on_View_Results_Button() throws Throwable {
		searchLandingobj.clickOnViewResults();
	}
	
	/**
	 * Navigate back.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Navigate Back$")
	public void navigate_Back() throws Throwable {
		actionLib.NavigateBack();
	}

	/**
	 * Click on cruised with princess before checkbox.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Cruised with Princess before checkbox$")
	public void click_on_Cruised_with_Princess_before_checkbox() throws Throwable {
		searchLandingobj.clickOnTheCruisedbeforeCB();
	}

	/**
	 * Click on reset filters link.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Reset Filters Link$")
	public void click_on_Reset_Filters_Link() throws Throwable {
		searchLandingobj.clickOnResetFilters();
	}

	/**
	 * Click on search cruisetours tab.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Search Cruisetours Tab$")
	public void click_on_Search_Cruisetours_Tab() throws Throwable {
		searchLandingobj.SearchCruisetoursTab();
	}

	/**
	 * Select the length of cruisetour from length cruisetour drop down.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select the Length of Cruisetour from Length Cruisetour Drop Down$")
	public void select_the_Length_of_Cruisetour_from_Length_Cruisetour_Drop_Down() throws Throwable {
		searchLandingobj.selectLengthofCruisetour(lengthofcrustour);
	}

	/**
	 * Select travel sequence from travel sequence dropdown.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select Travel Sequence from Travel Sequence dropdown$")
	public void select_Travel_Sequence_from_Travel_Sequence_dropdown() throws Throwable {
		searchLandingobj.selectTravelSequence(Travelsequence);
	}

	/**
	 * Select cruisetour category from cruisetour categories dropdown.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select Cruisetour Category from Cruisetour Categories dropdown$")
	public void select_Cruisetour_Category_from_Cruisetour_Categories_dropdown() throws Throwable {
		searchLandingobj.selectCruisetourCategory(cruisecategory);
	}
	
	/**
	 * Verify the default values in destination and departure dropdown.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^verify the default values in Destination and Departure dropdown$")
	public void verify_the_default_values_in_Destination_and_Departure_dropdown() throws Throwable {
	    try
		{
	    	searchLandingobj.VerifyDefaultvalueDest(def_dest);
	    	searchLandingobj.VerifyDefaultvalueDep(def_dep);
		    extentLogs.pass("Verify default vaules", "Default values set to corresponding fields");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Verify default vaules", "Default values not set to corresponding fields");
		}
		
	}
}