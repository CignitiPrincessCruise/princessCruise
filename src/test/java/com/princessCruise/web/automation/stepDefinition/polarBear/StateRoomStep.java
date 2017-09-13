package com.princessCruise.web.automation.stepDefinition.polarBear;

import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.fileutils.ExcelReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.polarBear.DiningLightBoxPage;
import com.princessCruise.web.automation.pages.polarBear.StateroomPage;
import com.princessCruise.web.automation.utilities.CommonVariables;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * The Class StateRoomStep.
 */
@CucumberOptions(features="C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\src\\test\\resources\\testFeature\\polarBear\\StateRoom_Dinning.feature",plugin = "json:C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\target\\cucumber-report-composite.json")
public class StateRoomStep extends TestEngineWeb{

		/** The stateroom obj. */
		private StateroomPage stateroomObj;
		
		/** The dining light box. */
		private DiningLightBoxPage diningLightBox;
		
		/** The action lib. */
		public ActionsLibrary actionLib;
		
		/** The time. */
		private String stateroomType, stateroomTypeTwins, size, time;
		
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
		@Test(groups = "smoke", description = "Stateroom Page")
		public void StateRoom() {
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
			this.stateroomType = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "roomType");
			this.stateroomTypeTwins = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "stateroomTypeTwins");
			this.size = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "DiningSize");
			this.time = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "DiningTime");
			stateroomObj = new StateroomPage(CommonVariables.CommonDriver.get());
			diningLightBox = new DiningLightBoxPage(CommonVariables.CommonDriver.get());
			actionLib = CommonVariables.getActionLib();
		}
		
		/**
		 * Select number of guests.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Number Of Guests$")
		public void Select_Number_Of_Guests() throws Throwable {
			stateroomObj.selectNoOfGuests();
		}

		/**
		 * Select stateroom type and location.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Stateroom Type and Location$")
		public void Select_Stateroom_Type_and_Location() throws Throwable {
			stateroomObj.selectStateRoom();
		}


		/**
		 * Select zone location.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Zone Location$")
		public void Select_Zone_Location() throws Throwable {
			stateroomObj.selectZoneLocation();
		}

		/**
		 * Select deck and stateroom.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Deck and Stateroom$")
		public void Select_Deck_and_Stateroom() throws Throwable {
			stateroomObj.selectDeckGroupAndLocation();
		}

		/**
		 * Select a cabin.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select a Cabin$")
		public void Select_a_Cabin() throws Throwable {
			stateroomObj.selectCabin();
		}

		

		/**
		 * Check if user is able to select bed configuration.
		 *
		 * @throws Throwable the throwable
		 */
		@Then("^Check if user is able to Select Bed Configuration$")
	    public void check_if_user_is_able_to_Select_Bed_Configuration() throws Throwable {
				stateroomObj.selectRoom(stateroomType);
			}
	

		/**
		 * Check if user is able to select bed configuration twins.
		 *
		 * @throws Throwable the throwable
		 */
		@Then("^Check if user is able to select Bed Configuration twins$")
		public void check_if_user_is_able_to_select_Bed_Configuration_twins() throws Throwable {
			stateroomObj.selectRoom(stateroomTypeTwins);
		}

		/**
		 * Select any time dining button.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Any Time Dining Button$")
		public void Select_Any_Time_Dining_Button() throws Throwable {
			diningLightBox.selectDiningOption(DiningLightBoxPage.ddnDiningOptionAnytimeDin);
		}

		/**
		 * Select traditional dining button.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Traditional Dining Button$")
		public void Select_Traditional_Dining_Button() throws Throwable {
			diningLightBox.selectDiningOption(DiningLightBoxPage.ddnDiningOptionTradDin);
		}
		
		/**
		 * Select dining time.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Dining Time$")
		public void Select_Dining_Time() throws Throwable {
			diningLightBox.selectDiningTime(time);
		}

		/**
		 * Select dining table size.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select Dining Table Size$")
		public void Select_Dining_Table_Size() throws Throwable {
			diningLightBox.selectDiningTableSize(size);
		}
		
		/**
		 * Close the dinning and stateroom page.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Close the Dinning and stateroom page$")
		public void Close_the_Dinning_and_stateroom_page() throws Throwable {
			diningLightBox.Close_the_Dinning_and_stateroom_page();
		}
		
		/**
		 * Select other stateroom.
		 *
		 * @throws Throwable the throwable
		 */
		@When("^Select other Stateroom$")
		public void Select_other_Stateroom() throws Throwable {
			diningLightBox.Select_other_Stateroom();
		}

		
		
		/**
		 * Check if user is able to select club class dinning option.
		 *
		 * @throws Throwable the throwable
		 */
		@Then("^Check if user is able to Select Club class dinning option$")
		public void check_if_user_is_able_to_Select_Club_class_dinning_option() throws Throwable {
			diningLightBox.selectDiningOption(DiningLightBoxPage.ddnDiningOptionAnytimeDin);
		}
		
		/**
		 * Select the I require an accessible statroom check box.
		 *
		 * @throws Throwable the throwable
		 */
		@Then("^Select the 'I require an accessible statroom' Check Box$")
		public void select_the_I_require_an_accessible_statroom_Check_Box() throws Throwable {
			stateroomObj.SelectaccessiblestatroomCheckBox();
		}

		
		/**
		 * Click accept terms continue button.
		 *
		 * @throws Throwable the throwable
		 */
		@Then("^Click 'Accept Terms & Continue' button$")
		public void click_Accept_Terms_Continue_button() throws Throwable {
		   
		}
		
		/**
		 * Click decline button.
		 *
		 * @throws Throwable the throwable
		 */
		@Then("^Click 'Decline' button$")
		public void click_Decline_button() throws Throwable {
		    
		}
		
}
