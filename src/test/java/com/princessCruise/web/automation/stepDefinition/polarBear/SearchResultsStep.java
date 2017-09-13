package com.princessCruise.web.automation.stepDefinition.polarBear;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.polarBear.*;
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
 * The Class PlanAcruiseStep.
 */
@CucumberOptions(features="C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\src\\test\\resources\\testFeature\\polarBear\\SearchResults.feature",plugin = "json:C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\target\\cucumber-report-composite.json")

public class SearchResultsStep extends TestEngineWeb{
	
	/** The Search results page obj. */
	private SearchResultsPage SearchResultsPageObj;
	
	/** The action lib. */
	public ActionsLibrary actionLib;	
	
	/** The extent logs. */
	private ExtentLogs extentLogs = new ExtentLogs();
	
	/** The sheet path. */
	protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/polarBear/polarBear.xlsx";
	
	/** The sheet name. */
	protected String sheetName = "SearchResults";
	
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
	 * Search results.
	 */
	@Test(groups = "smoke", description = "Search Results Page")
    public void SearchResults() {
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
		extentLogs.info(scenario.getName().toString()+" Scenario", "Starts");
		System.out.println("This is before scenario: "+ scenario.getName().toString());
		extentLogs.info(scenario.getName().toString()+" Scenario", "Starts");
		SearchResultsPageObj = new SearchResultsPage(CommonVariables.CommonDriver.get());
		actionLib = CommonVariables.getActionLib();
	}
	
	/**
	 * Itineraries text should appear as a result.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^Itineraries text should appear as a result$")
	public void itineraries_text_should_appear_as_a_result() throws Throwable {
		SearchResultsPageObj.verifyItineraries();
	}
	
	
	/**
	 * Verify the presence of view results button and click on view results button.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^verify the presence of View Results button and Click on View Results Button$")
	public void verify_the_presence_of_View_Results_button_and_Click_on_View_Results_Button() throws Throwable {
		SearchResultsPageObj.clickOnViewResultButon();
	}


	/**
	 * Click on the view results button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on the View results button$")
	public void click_on_the_View_results_button() throws Throwable {
		SearchResultsPageObj.clickOnViewResultButon();
	}
	
	
	/**
	 * Click on the cruise details button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on the Cruise Details button$")
	public void click_on_the_cruiseDetails_button() throws Throwable {
		SearchResultsPageObj.clickOnCruiseDetailsButon();
	
	}
	/**
	 * Verify the presence of cruise details button and click on the cruise deatils button.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^verify the presence of cruiseDetails button and Click on the Cruise Deatils button$")
	public void verify_the_presence_of_cruiseDetails_button_and_Click_on_the_Cruise_Deatils_button() throws Throwable {
		SearchResultsPageObj.clickOnCruiseDetailsButon();
	}

	
	/**
	 * Pricing is per person double occupancy text should appear as result.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Pricing is per person, double occupancy… text should appear as result$")
	public void pricing_is_per_person_double_occupancy_text_should_appear_as_result() throws Throwable {
		SearchResultsPageObj.verifyPricingText();
	}
	
	/**
	 * Click on refine search button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on 'Refine Search' Button$")
	public void click_on_Refine_Search_Button() throws Throwable {
		SearchResultsPageObj.clickOnRefineSearchButon();		
	   
	}


	

}