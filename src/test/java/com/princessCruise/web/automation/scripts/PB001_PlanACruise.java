package com.princessCruise.web.automation.scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.pages.PlanACruisePage;
import com.princessCruise.web.automation.utilities.CommonVariables;

import cucumber.api.CucumberOptions;

//@CucumberOptions(features="C:\\Users\\Nixi\\Documents\\work\\princessCruise\\testFeature\\PlanACruise.feature",plugin="json:target/cucumber2.json",tags="@smoke")
public class PB001_PlanACruise extends TestEngineWeb {
	private PlanACruisePage planACruisePage;
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;	
	private ExtentLogs extenLogs = new ExtentLogs();

	/**_
	 * @author Nikhil Bharati
	 * @param status
	 * @param reason
	 */
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}
	

	@BeforeMethod(alwaysRun = true, groups = { "smoke", "regression" })
	public void beforeMethod() throws IOException {
		System.out.println("Before Method");

	}

	/**
	 * @author nikhil bharati
	 * @throws Throwable
	 * @test case id:PB001
	 */
	@Test(description = "checkFramework", groups = { "smoke ", "regression" })
	public void checkFramework() throws Throwable {
		try {
			planACruisePage = new PlanACruisePage(CommonVariables.CommonDriver.get());
			planACruisePage.testClick();
			
		}

		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Plan a Cruise.";
			String stackTrace = extenLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extenLogs.fail("checkFramework ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	}


}
