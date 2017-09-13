package com.princessCruise.web.automation.pages.myPrincess;

import org.openqa.selenium.WebDriver;

import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.objectrepository.myPrincess.OverrideLocation_OR;
import com.princessCruise.web.automation.objectrepository.myPrincess.SignUpPage_OR;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

public class OverrideLocationPage extends OverrideLocation_OR {
	public WebDriver driver;
	public ActionsLibrary actionLib;
	public ExtentLogs extentLogs=new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public OverrideLocationPage(WebDriver driver)
	{
		if(CommonVariables.getDriver()==null){
			CommonVariables.setDriver(driver);
		}
		actionLib = CommonVariables.getActionLib();
		try {
			if(!ConfigManager.ArePropertiesSet.get()){
				ConfigManager.setProperties();
				ConfigManager.UpdateProperties();
			}
		} 
		catch (Exception e) {
			System.out.println("Failed to load Properties file");
		}
	}

	public Optional<Long> timeout(Integer time)
	{
		return Optional.of(Long.parseLong(String.valueOf(time)));
	}
	
	public void moveFromOverrideLocation() {
		if(actionLib.IsElementVisible(OverrideLocation_OR.btnSubmit)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(OverrideLocation_OR.btnSubmit));
				extentLogs.pass("click Submit button", "Clicked on Submit Button successfully.");
			} catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}


}
