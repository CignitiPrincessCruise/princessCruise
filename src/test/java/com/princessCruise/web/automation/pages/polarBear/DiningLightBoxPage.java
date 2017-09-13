package com.princessCruise.web.automation.pages.polarBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

/**
 * The Class DiningLightBoxPage.
 */
public class DiningLightBoxPage {
	
	/** The ddn dining option anytime din. */
	public static By ddnDiningOptionAnytimeDin = By.id("type-anytime");
	
	/** The ddn dining option trad din. */
	public static By ddnDiningOptionTradDin = By.id("type-traditional");
	
	/** The ddn dining time. */
	public static By ddnDiningTime = By.id("dining-time");
	
	/** The ddn table size. */
	public static By ddnTableSize = By.id("table-size");
	
	/** The choosea dffroombtn. */
	public static By chooseaDffroombtn = By.xpath("//[@id='select-stateroom']/div/button[2]");
	
	/** The btn deck option club. */
	public static By btnDeckOption_Club = By.cssSelector("#deck-9-A-M #deck-9-A-M-wrapper #group-C746>a");

	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("100000"));
	
	/**
	 * Instantiates a new dining light box page.
	 *
	 * @param driver the driver
	 */
	public DiningLightBoxPage(WebDriver driver)
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
	
	/**
	 * Select dining option.
	 *
	 * @param element the element
	 * @throws Throwable the throwable
	 */
	public void selectDiningOption(By element) throws Throwable{
		try
		{			
			actionLib.FindElement(element, timeoutInSecond).click();
			extentLogs.pass("Dining Option", "'Dining Option DropDown' Dining Option Value Found.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

	}
	
	/**
	 * Select dining time.
	 *
	 * @param diningTime the dining time
	 * @throws Throwable the throwable
	 */
	public void selectDiningTime(String diningTime) throws Throwable{
		try
		{
		actionLib.FindElement(ddnDiningTime, timeoutInSecond).click();
		actionLib.selectBySendkeys(ddnDiningTime, diningTime,"Dining Time");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		extentLogs.pass("Dining Time", "'Dining Time DropDown' Dining Time Value Found.");
	}
	
	/**
	 * Select dining table size.
	 *
	 * @param diningTableSize the dining table size
	 * @throws Throwable the throwable
	 */
	public void selectDiningTableSize(String diningTableSize) throws Throwable{
		try
		{
		actionLib.selectByVisibleText(ddnTableSize, diningTableSize, "Dining Table Size");	
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		extentLogs.pass("Dining Table Size", "'Dining Table Size DropDown' Dining Table Size Value Found.");
	}
	
	/**
	 * Select different stateroom.
	 *
	 * @param element the element
	 * @throws Throwable the throwable
	 */
	public void selectDifferentStateroom(By element) throws Throwable{
		
		try
		{
			if(actionLib.IsElementVisible(chooseaDffroombtn)) {
				actionLib.FindElement(chooseaDffroombtn, timeoutInSecond).click();
				actionLib.FindElement(StateroomPage.btnDeckOption, timeoutInSecond).click();
				selectDiningOption(element);
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
				
	}
	
	/**
	 * Close the dinning and stateroom page.
	 *
	 * @throws Throwable the throwable
	 */
	public void Close_the_Dinning_and_stateroom_page() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnpopUpClose));
			extentLogs.pass("Closed the Dining and Stateroom Page", "Closed the Dining and Stateroom Page is successful");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Closed the Dining and Stateroom Page", "Closed the Dining and Stateroom Page is Unsuccessful");
		}
	}
	
	/**
	 * Select other stateroom.
	 */
	public void Select_other_Stateroom(){
		
		try
		{
			System.out.println("Entered select other stateroom");
			
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnDeckOption_Club));
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnDeckOption_Club));
			extentLogs.pass("Select stateroom ", "Selecting the stateroom is successful.");
		}	
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click stateroom", "Selecting the stateroom is Unsuccessful.");
		}
	}	
	
		
}
