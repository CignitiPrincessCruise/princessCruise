package com.princessCruise.web.automation.pages;

import org.openqa.selenium.WebDriver;
import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.objectrepository.BasePage_OR;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;


public class BasePage extends BasePage_OR
{
	public WebDriver driver;
	public ActionsLibrary actionLib;
	public ExtentLogs extentLogs=new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public BasePage(WebDriver driver)
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

}