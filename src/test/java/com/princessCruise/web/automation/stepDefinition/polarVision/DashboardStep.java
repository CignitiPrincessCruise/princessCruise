package com.princessCruise.web.automation.stepDefinition.polarVision;

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
import com.princessCruise.web.automation.pages.polarVision.Dashboard;
import com.princessCruise.web.automation.utilities.CommonVariables;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;
// TODO: Auto-generated Javadoc

/**
 * The Class DashboardStep.
 */
@CucumberOptions(features="C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\src\\test\\resources\\testFeature\\polarVision\\Dashboard.feature",plugin = "json:C:\\Users\\E003919\\Desktop\\Pavan\\Pavan\\21082017\\princessCruise\\target\\cucumber-report-composite.json")

public class DashboardStep extends TestEngineWeb { 
	
		/** The dashboard. */
		private Dashboard dashboard;	
		
		/** The action lib. */
		public ActionsLibrary actionLib;
		
		/** The password. */
		private String locationURL,userName,password;
		
		/** The sheet path. */
		protected String sheetPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/polarVision/PolarVision.xlsx";
		
		/** The sheet name. */
		protected String sheetName = "Dashboard";
		
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
		 * Dashboard.
		 */
		@Test(groups = "smoke", description = "Dashboard")
		public void Dashboard() {
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
			this.userName = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Username");
			this.password = ExcelReader.fn_GetCellData(this.sheetPath, this.sheetName, 1, "Password");
			
			actionLib = CommonVariables.getActionLib();
		}

			/**
			 * Launch the polar vision application.
			 *
			 * @throws Throwable the throwable
			 */
			@Given("^Launch the Polar Vision Application$")
			public void launch_the_Polar_Vision_Application() throws Throwable {
				actionLib.OpenUrl(locationURL);
			}

			/**
			 * Enter username and password.
			 *
			 * @throws Throwable the throwable
			 */
			@Given("^Enter Username and Password$")
			public void enter_Username_and_Password() throws Throwable {
			  dashboard.enterUsernameAndPassword(userName,password);
			}

			/**
			 * I click on sign in button.
			 *
			 * @throws Throwable the throwable
			 */
			@When("^I Click on SignIn Button$")
			public void i_Click_on_SignIn_Button() throws Throwable {
			    // Write code here that turns the phrase above into concrete actions
				dashboard.clickOnSignInButton();
			}
		
}
