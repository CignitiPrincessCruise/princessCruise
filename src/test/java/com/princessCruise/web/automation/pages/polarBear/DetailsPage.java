package com.princessCruise.web.automation.pages.polarBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

/**
 * The Class DetailsPage.
 */
public class DetailsPage {


	/** The btn cruise detail. */
	public static By btnCruiseDetail = By.xpath("//button[text()='Cruise Details']");
	
	/** The btn select A room. */
	public static By btnSelectARoom = By.xpath("//button/span[@class='xs-hidden sm-hidden']");
	
	/** The btn select stateroom type. */
	public static By btnSelectStateroomType = By.id("roomTypes");
	
	/** The btnselectroom. */
	public static By btnselectroom = By.xpath("//div[@id='container']//div[@id='suite']//button[@class='button green-btn select-stateroom-btn font-size-btn']");
	
	/** The btnchangedate. */
	public static By btnchangedate  = By.xpath("//div[@id='container']//select[@id='meta-departure-date-select']");
	
	/** The btn cruise details. */
	public static By btnCruiseDetails = By.xpath("//div[@class='result-box']//button[@id='select-cruise-details-H780']");	
	
	/** The txtstatromm. */
	public static By txtstatromm = By.xpath("//div[@id='content']//header/div[3]/div/h1");
 
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("100000"));
	
	/**
	 * Instantiates a new details page.
	 *
	 * @param driver the driver
	 */
	public DetailsPage(WebDriver driver)
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
	 * Click on cruise detail.
	 *
	 * @throws Throwable the throwable
	 */
	public void clickOnCruiseDetail() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnCruiseDetail));
			extentLogs.pass("click Cruise Details button", "Clicked on Cruise Details Button successfully.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click Cruise Details button", "Clicking on Cruise Details Button is Unsuccessful.");
		}
	}
	
	
	/**
	 * Click on select A room.
	 *
	 * @throws Throwable the throwable
	 */
	public void clickOnSelectARoom() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnSelectARoom));
			extentLogs.pass("click Select A Room button", "Clicked on Select A Room Button successfully.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click Select A Room button", "Clicking on Select A Room Button is Unsuccessful.");
		}
	}
	
	/**
	 * Click on select stateroom type.
	 *
	 * @throws Throwable the throwable
	 */
	public void clickOnSelectStateroomType() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnSelectStateroomType));
			extentLogs.pass("click on Stateroom Tab", "Clicked on Stateroom tab is successful.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click on Stateroom Tab", "Clicking on Stateroom tab is Unsuccessful.");
		}
	}
	
	/**
	 * Click on select stateroom.
	 *
	 * @throws Throwable the throwable
	 */
	public void clickOnSelectStateroom() throws Throwable{
		
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnselectroom));
			extentLogs.pass("click on Stateroom", "Clicked on Stateroom is successful.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click on Stateroom", "Clicking on Stateroom is Unsuccessful.");
		}
		
	}
	
	
	/**
	 * Click on change date dropdown.
	 *
	 * @throws Throwable the throwable
	 */
	public void clickOnChangeDateDropdown() throws Throwable{
		
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnchangedate));
			extentLogs.pass("click on Select a Date Dropdown", "Click on Select a Date Dropdown is successful.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Click on Select a Date Dropdown", "Clicking on Select a Date Dropdown Unsuccessful.");
		}
		
	}
	
	/**
	 * Click on cruise details buton.
	 */
	public void clickOnCruiseDetailsButon() {
		if(actionLib.IsElementVisible(btnCruiseDetails)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnCruiseDetails));
				extentLogs.pass("Click on Cruise Details button", "Clicked on Cruise Details successfully.");
				
			} catch(Throwable e) {
				extentLogs.fail("Click on Cruise Details button", "Clicked on Cruise Details successfully.");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Select new date.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectNewDate(String value) throws Throwable{
		try
		{
			actionLib.selectBySendkeys(btnchangedate, value, "Select a Date");
			extentLogs.pass("Select a Date", "Selected a new date successfully.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Select a Date", "Selecting new date is Unsuccessful.");
		}
		
	}
	
	/**
	 * Verifyvalues.
	 *
	 * @param text the text
	 */
	public void Verifyvalues(String text) {
		try {
			String value = actionLib.getElementText(DetailsPage.txtstatromm, "Stateroom Selection");
			System.out.println(text+" && "+value);
			actionLib.compareValues(text, value, "Actual and Expected values are not same");
			extentLogs.pass("Verify Stateroom Selection Text", "Successfully Verified Stateroom Selection Text");
		} catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Verify Stateroom Selection Text", "Failed to Verify Stateroom Selection Text");
		}
		
		
	}
	

}
