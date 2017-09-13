package com.princessCruise.web.automation.stepDefinition.polarBear;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.fileutils.ExcelReader;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.polarBear.DetailsPage;
import com.princessCruise.web.automation.utilities.CommonVariables;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;


/**
 * The Class DetailsPageStep.
 */
@CucumberOptions(features="C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\src\\test\\resources\\testFeature\\polarBear\\DetailsPage.feature",plugin = "json:C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\target\\cucumber-report-composite.json")
public class DetailsPageStep extends TestEngineWeb{	

	/** The Details page obj. */
	private DetailsPage DetailsPageObj;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The New date. */
	public String NewDate;
	
	/** The Stateroomseltxt. */
	public String Stateroomseltxt = "Stateroom Selection";
	
	/** The sheet path. */
	protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/polarBear/polarBear.xlsx";
	
	/** The sheet name. */
	protected String sheetName = "SearchResults";
	
	/** The testdata. */
	Map<String, List<String>> testdata = null;
	
	/** The extent logs. */
	private ExtentLogs extentLogs = new ExtentLogs();

	/**
	 * State room.
	 */
	@Test(groups = "smoke", description = "Details page")
	public void Detailspage() {
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
		this.NewDate = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "NewDate");
		DetailsPageObj = new DetailsPage(CommonVariables.CommonDriver.get());
		actionLib = CommonVariables.getActionLib();
	}

	/**
	 * Click on cruise detail button.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Cruise Detail Button$")
	public void Click_on_Cruise_Detail_Button() throws Throwable {
		DetailsPageObj.clickOnCruiseDetail();
	}

	/**
	 * I click on select stateroom.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Select Stateroom$")
	public void Click_on_Select_Stateroom() throws Throwable {
		DetailsPageObj.clickOnSelectARoom();
	}

	/**
	 * Click on stateroom type tab.
	 *
	 * @throws Throwable the throwable
	 */
    @When("^Click on Stateroom Type tab$")
	public void Click_on_Stateroom_Type_tab() throws Throwable {
		DetailsPageObj.clickOnSelectStateroomType();
	}
	
	/**
	 * Validate text stateroom selection ïn stateroom page.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("^Verify text Stateroom Selection in Stateroom Page$")
	public void validate_text_Stateroom_Selection_ïn_Stateroom_Page() throws Throwable {
		DetailsPageObj.Verifyvalues(Stateroomseltxt);
	}
	
	/**
	 * Select stateroom.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Select Stateroom$")
	public void Select_Stateroom() throws Throwable {
		DetailsPageObj.clickOnSelectStateroom();		
	}
	
	/**
	 * Click on change date dropdown.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on Change Date dropdown$")
	public void click_on_Change_Date_dropdown() throws Throwable {
		DetailsPageObj.clickOnChangeDateDropdown();
	}

	/**
	 * Click on new date.
	 *
	 * @throws Throwable the throwable
	 */
	@Then("Check if user is able to select new date$")
	public void click_on_New_Date() throws Throwable {
		DetailsPageObj.selectNewDate(NewDate);		
	}
	
	/**
	 * Click on the cruise details button after new search.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^Click on the Cruise Details button after new search$")
	public void click_on_the_Cruise_Details_button_after_new_search() throws Throwable {
		DetailsPageObj.clickOnCruiseDetailsButon();	
    }

}		




