package com.princessCruise.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.base.Optional;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.objectrepository.PlanACruise_OR;
import com.princessCruise.web.automation.utilities.CommonVariables;


public class PlanACruisePage extends BasePage{
	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public PlanACruisePage(WebDriver driver) {
		super(driver);
		//if (!actionLib.GetURl().contains("find/search.do")) {
		//	throw new IllegalStateException("This is not the 'Plan A Cruise' page.");
		//}
	}
	public void testClick(){
		actionLib.Click(CommonVariables.CommonDriver.get().findElement(PlanACruise_OR.PlanACruise),2);
	}

}
