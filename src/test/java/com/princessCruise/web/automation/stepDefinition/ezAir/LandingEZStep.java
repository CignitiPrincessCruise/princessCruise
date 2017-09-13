package com.princessCruise.web.automation.stepDefinition.ezAir;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.fileutils.ExcelReader;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.ezAir.LandingEZ;
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
 * The Class LandingEZStep.
 */
@CucumberOptions(features="C:\\PrincessCruises_31_08_2017\\princessCruise\\src\\test\\resources\\testFeature\\ezAir\\LandingEZ.feature",plugin = "json:C:\\PrincessCruises_31_08_2017\\princessCruise\\target\\cucumber-report-composite.json")

public class LandingEZStep extends TestEngineWeb {
	
	/** The landing EZ. */
	private LandingEZ landingEZ;	
	
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The header. */
	private String locationURL,direction,classValue,maxStops,airline,sortBy,header;
	
	/** The sheet path. */
	protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/ezAir/TestData.xlsx";
	
	/** The sheet name. */
	protected String sheetName = "LandingEZ";
	
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
	 * Landing EZ air.
	 */
	@Test(groups = "smoke", description = "Landing EZ Air")
	public void landingEZAir() {
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
		this.locationURL = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Url");
		this.direction = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Direction");
		this.classValue = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Class");
		this.maxStops = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Stops");
		this.airline = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Airline");
		this.sortBy = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Sort");
		this.header = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "LandingPageHeader");
		landingEZ = new LandingEZ(CommonVariables.CommonDriver.get());
		actionLib = CommonVariables.getActionLib();
	}
	
	/**
	 * Launch E Z air application.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^Launch EZ Air Application$")
	public void launch_EZ_Air_Application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		actionLib.OpenUrl(locationURL);
	}
	
	/**
	 * Landing page should display.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Landing page should display$")
	public void landing_page_should_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingEZ.verifyLandingPageIsDisplayed(header);
	}

	/**
	 * Tell us who you are are are booking for should list all guests from polar booking.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Tell us who you are are are booking for Should list all guests from Polar booking$")
	public void tell_us_who_you_are_are_are_booking_for_Should_list_all_guests_from_Polar_booking() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingEZ.verifyAllGuests(LandingEZ.chkGuest1);
		landingEZ.verifyAllGuests(LandingEZ.chkGuest2);
	}


	/**
	 * Direction dropdown should default to departure and return.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Direction dropdown Should default to Departure and Return$")
	public void direction_dropdown_Should_default_to_Departure_and_Return() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFlightOptionDropDowns(LandingEZ.ddnDirection, direction);
	}

	/**
	 * Class should default to economy.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Class	Should default to Economy$")
	public void class_Should_default_to_Economy() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFlightOptionDropDowns(LandingEZ.ddnClass, classValue);
	}
	
	/**
	 * Maximum stops should defaults to any.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Maximum Stops	Should defaults to Any$")
	public void maximum_Stops_Should_defaults_to_Any() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyDropDownDefaultValue(maxStops,LandingEZ.ddnMaxStops);
	}
	
	/**
	 * Airline should default to all.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Airline	Should default to All$")
	public void airline_Should_default_to_All() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFlightOptionDropDowns(LandingEZ.ddnAirline, airline);
	}
	
	/**
	 * Return to dropdown is not null.
	 *
	 * @throws Throwable the throwable
	 */
	/*@Then("^Departure To dropdown and Return From dropdown$")
	public void departure_To_dropdown_and_Return_From_dropdown() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyDepartureToAndReturnFromDropDown();
	}*/
	@Then("^Return To dropdown is not null$")
	public void return_To_dropdown_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.getToCity(LandingEZ.txtBoxReturnTo);	
	}
	
	/**
	 * Cruise deprature and arrive on box is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Cruise Deprature and Arrive On Box is not null$")
	public void cruise_Deprature_and_Arrive_On_Box_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFieldValue(LandingEZ.txtBoxArriveOn);
		landingEZ.verifyFieldValue(LandingEZ.lblCruiseDeparture);
	}

	/**
	 * Cruise return and leave on box is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Cruise Return	and Leave On Box is not null$")
	public void cruise_Return_and_Leave_On_Box_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFieldValue(LandingEZ.txtBoxLeaveOn);
		landingEZ.verifyFieldValue(LandingEZ.lblCruiseReturn);
	}
	
	/**
	 * Departure arrive by dropdown is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Departure Arrive by dropdown is not null$")
	public void departure_Arrive_by_dropdown_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFieldValue(LandingEZ.ddnArriveBy);
	}

	/**
	 * Return leave at dropdown is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Return Leave at dropdown is not null$")
	public void return_Leave_at_dropdown_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFieldValue(LandingEZ.ddnLeaveAt);
	}

	/**
	 * Click on search button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click On Search Button$")
	public void click_On_Search_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.clickOnSearchButton();
		

	}
	
	/**
	 * Verify the application is redirecting to waiting page.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Verify the application is redirecting to waiting page$")
	public void verify_the_application_is_redirecting_to_waiting_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingEZ.verifyEZAirLogo();
	}
	
	/**
	 * Departure to dropdown and return from dropdown.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Departure To dropdown	and Return From dropdown$")
	public void departure_To_dropdown_and_Return_From_dropdown() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyDepartureToAndReturnFromDropDown();
	}
	
	/**
	 * Adds the another flight link should drop down more boxes in order to add a stopover.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Add another flight link Should drop down more boxes in order to add a stopover$")
	public void add_another_flight_link_Should_drop_down_more_boxes_in_order_to_add_a_stopover() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyRetAndDepAddFlight(LandingEZ.departureFormFields, LandingEZ.btnDepAddFlight);
		Thread.sleep(5000);
		landingEZ.verifyRetAndDepAddFlight(LandingEZ.returnFormFields, LandingEZ.btnRetAddFlight);
	}
	
	/**
	 * Select your depart flight should display home airport to port city and date.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Select Your Depart Flight	Should display home airport to port city and date$")
	public void select_Your_Depart_Flight_Should_display_home_airport_to_port_city_and_date() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFromPortAndToPortAndDate("Departure",LandingEZ.lblFromAndToCity);
	}
	
	/**
	 * Select your return flight should display port city to home city and date.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Select Your Return Flight	Should display port city to home city and date$")
	public void select_Your_Return_Flight_Should_display_port_city_to_home_city_and_date() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFromPortAndToPortAndDate("Return",LandingEZ.lblRetFromAndToCity);
	}
	
	/**
	 * Currency fares in XX X should be correct currency displaying.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Currency- Fares in XXX Should be correct currency displaying$")
	public void currency_Fares_in_XXX_Should_be_correct_currency_displaying() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyCurrencyFares();
	}
	
	/**
	 * Departure from box is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Departure  From box is not null$")
	public void departure_From_box_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.getToCity(LandingEZ.ddnDepFrom);	
	}

	/**
	 * Departure to dropdown is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Departure To dropdown is not null$")
	public void departure_To_dropdown_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.getFromCity(LandingEZ.ddnDepTo);
	}

	/**
	 * Return from dropdown is not null.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Return From dropdown is not null$")
	public void return_From_dropdown_is_not_null() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.getFromCity(LandingEZ.ddnReturnFrom);
	}


	/**
	 * Gets the default return from and to city value.
	 *
	 * @return the default return from and to city value
	 * @throws Throwable the throwable
	 */
	@When("^Get Default Return From and To City Value$")
	public void get_Default_Return_From_and_To_City_Value() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.getFromCity(LandingEZ.ddnReturnFrom);
		landingEZ.getToCity(LandingEZ.txtBoxReturnTo);	

	}

	/**
	 * Steps bar should display one to five.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Steps Bar	Should display One to five$")
	public void steps_Bar_Should_display_One_to_five() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyStepBar();
	}
	
	/**
	 * Gets the default departure from and to city value.
	 *
	 * @return the default departure from and to city value
	 * @throws Throwable the throwable
	 */
	@When("^Get Default Departure From and To City Value$")
	public void get_Default_Departure_From_and_To_City_Value() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.getFromCity(LandingEZ.ddnDepTo);
		landingEZ.getToCity(LandingEZ.ddnDepFrom);	
	}
	
	/**
	 * Flights found should display correct number of flight options listed on page.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^flights found Should display correct number of flight options listed on page$")
	public void flights_found_Should_display_correct_number_of_flight_options_listed_on_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyNoOfFlightsFound();
	}
	
	/**
	 * Sort by dropdown should default to fare low to high.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Sort by dropdown Should default to Fare low to high$")
	public void sort_by_dropdown_Should_default_to_Fare_low_to_high() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyDropDownDefaultValue(sortBy,LandingEZ.ddnSortBy);
	}
	
	/**
	 * What are flexible and restricted fares link should be able to click and have a lightbox display.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^What are Flexible and Restricted Fares Link Should be able to click and have a lightbox display$")
	public void what_are_Flexible_and_Restricted_Fares_Link_Should_be_able_to_click_and_have_a_lightbox_display() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.clickOnWhatAreFlexAndRestFares();
	}

	/**
	 * Filters should be sectioned with fare type stops departure time and airlines.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Filters	Should be sectioned with Fare Type, Stops, Departure Time, and Airlines$")
	public void filters_Should_be_sectioned_with_Fare_Type_Stops_Departure_Time_and_Airlines() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFilters();
	}

	/**
	 * Flight options should display airline name flight schedule and duration.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Flight options Should display Airline name, flight schedule and duration$")
	public void flight_options_Should_display_Airline_name_flight_schedule_and_duration() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyFlightOptions();
	}

	/**
	 * Click show details light box should display with a breakdown of flight schedule.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click show details Light box should display with a breakdown of flight schedule$")
	public void click_show_details_Light_box_should_display_with_a_breakdown_of_flight_schedule() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.clickOnShowDetails();
	}

	/**
	 * Click fare restrictions light box should display the descriptions of flexible and restricted fare types.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click fare restrictions	Light box should display the descriptions of flexible and restricted fare types$")
	public void click_fare_restrictions_Light_box_should_display_the_descriptions_of_flexible_and_restricted_fare_types() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.clickOnFareRestrictions();
	}
	
	/**
	 * Fare card should diplay round trip for flexible type.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Fare Card	Should Diplay round trip for Flexible type$")
	public void fare_Card_Should_Diplay_round_trip_for_Flexible_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyDataIsDisplayed(LandingEZ.lblFlexibleFareCard);
	}
	
	/**
	 * Fare card should diplay non refundable for restricted type.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Fare Card	Should Diplay non refundable for restricted type$")
	public void fare_Card_Should_Diplay_non_refundable_for_restricted_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyDataIsDisplayed(LandingEZ.lblRestrictedFareCard);
	}

	/**
	 * Click select on flexible fare card should be taken to return flight options.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click Select on flexible fare card Should be taken to Return Flight options$")
	public void click_Select_on_flexible_fare_card_Should_be_taken_to_Return_Flight_options() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyReturnFlightPage(LandingEZ.btnDepFlexibleSelect);
	}
	
	/**
	 * Click select on restricted fare card should be taken to return flight options.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click Select on restricted fare card Should be taken to Return Flight options$")
	public void click_Select_on_restricted_fare_card_Should_be_taken_to_Return_Flight_options() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifyReturnFlightPage(LandingEZ.btnDepRestrictedSelect);
	}
	
	/**
	 * Click select on fare card should be taken to summary page.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Click Select on fare card Should be taken to Summary page$")
	public void click_Select_on_fare_card_Should_be_taken_to_Summary_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifySummaryPage(LandingEZ.btnRetFlexibleSelect);
	}
	
	/**
	 * Click select on restricted fare card should be taken to summary page.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Click Select on restricted fare card Should be taken to Summary page$")
	public void click_Select_on_restricted_fare_card_Should_be_taken_to_Summary_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		landingEZ.verifySummaryPage(LandingEZ.btnRetRestrictedSelect);
	}

}
