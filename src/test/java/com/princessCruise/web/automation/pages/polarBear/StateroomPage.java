package com.princessCruise.web.automation.pages.polarBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;


/**
 * The Class StateroomPage.
 */
public class StateroomPage {

	/** The btn cruise detail. */
	public static By btnCruiseDetail = By.xpath("//button[text()='Cruise Details']");
	
	/** The btn select A room. */
	public static By btnSelectARoom = By.xpath("//button/span[@class='xs-hidden sm-hidden']");
	
	/** The btn select stateroom type. */
	public static By btnSelectStateroomType = By.xpath("//[@id='roomTypes']/span");
	
	/** The btn no of guests. */
	public static By btnNoOfGuests = By.xpath("//div[text()='Guests']/preceding-sibling::div[text()='2']/parent::button");
	
	/** The btn meta stateroom. */
	public static By btnMetaStateroom = By.cssSelector("#Suite>button");
	
	/** The btn sub meta stateroom. */
	public static By btnSubMetaStateroom = By.xpath("//div[text()='Owners Suite']/../following-sibling::div//button[contains(text(),'Select from')]");
	
	/** The btn stateroom location. */
	public static By btnStateroomLocation = By.xpath("//div[@class='section-choose']//button[@id='pick-stateroom']");
	
	/** The btn zone location. */
	public static By btnZoneLocation = By.xpath("//section[@id='step-1-balcony']//div[@id='section-location']//label[text()='Aft']/preceding-sibling::input[@id='zone-aft']");
	
	/** The btn deck group. */
	public static By btnDeckGroup = By.xpath("//div[@id='section-deck']//div[@id='deck-groups']//div[@id='A-M']//span[text()='Deck 9']/preceding-sibling::input");
	
	/** The btn deck option. */
	public static By btnDeckOption = By.cssSelector("#deck-9-A-M #deck-9-A-M-wrapper #group-C735>a");
	
	/** The ddn cabin. */
	public static By ddnCabin = By.xpath("//div[@class='stateroom-gallery-nav']//a[@class='stateroom-gallery-thumb selected']");
	
	/** The ddn bed configuration. */
	public static By ddnBedConfiguration = By.id("bed-code");
	
	/** The btn any time dining. */
	public static By btnAnyTimeDining = By.xpath("//fieldset[@id='dining-options']//strong[text()='Anytime Dining: ']/../preceding-sibling::input");
	
	/** The btn accesscheckbox. */
	public static By btnAccesscheckbox = By.xpath("//*[@id='view-ada']");
	/*public static By btnNoOfGuestsAccess = By.xpath("");
	public static By btnMetaStateroomAccess = By.cssSelector("#Suite>button");
	public static By btnSubMetaStateroomAccess = By.xpath("//div[text()='Owners Suite']/../following-sibling::div//button[contains(text(),'Select from')]");
	public static By btnStateroomLocationAccess = By.xpath("//div[@class='section-choose']//button[@id='pick-stateroom']");
	public static By btnZoneLocationAccess = By.xpath("//section[@id='step-1-balcony']//div[@id='section-location']//label[text()='Aft']/preceding-sibling::input[@id='zone-aft']");
	public static By btnDeckOptionAccess = By.cssSelector("#deck-9-A-M #deck-9-A-M-wrapper #group-C73>a");*/
	
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("100000"));
	
	/**
	 * Instantiates a new stateroom page.
	 *
	 * @param driver the driver
	 */
	public StateroomPage(WebDriver driver)
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
	 * Click on plan A cruise.
	 */
	public void clickOnPlanACruise() {
		if(actionLib.IsElementVisible(SearchLandingPage.lnkPlanACruise)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.lnkPlanACruise));
				extentLogs.pass("click plan a cruise button", "Clicked on Plan A Cruise link Successfully.");
			} catch(Throwable e){
				e.printStackTrace();
				extentLogs.fail("click plan a cruise button", "Clicking on Plan A Cruise link is Unsuccessful.");
			}
		}
	}
	
	/**
	 * Select destination.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectDestination(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnDestination)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnDestination, value, "Destination DropDown");
				extentLogs.pass("Destination", "'Destination DropDown' Destination Value is Found.");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Destination", "'Destination DropDown' Destination Value is not Found.");
		}
		
	}
	
	/**
	 * Select departure port.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectDeparturePort(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnDeparturePort)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnDeparturePort, value, "Departure Port");
				extentLogs.pass("Departure", "'Departure Port DropDown' Departure Port Value Found.");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Departure", "'Departure Port DropDown' Departure Port Value is not Found.");
		}
	
	}
	
	/**
	 * Select length of cruise.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectLengthOfCruise(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnLengthOfCruise)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnLengthOfCruise, value, "Length of Cruise DropDown");
				extentLogs.pass("Length of Cruise", "'Length of Cruise DropDown' Length of Cruise Value Found.");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Length of Cruise", "'Length of Cruise DropDown' Length of Cruise Value is not Found.");
		}
	}
	
	/**
	 * Click on show more options.
	 */
	public void clickOnShowMoreOptions() {
		if(actionLib.IsElementVisible(SearchLandingPage.btnShowMoreOption)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnShowMoreOption));
				extentLogs.pass("click show more option button", "Clicked on Show More Option Button Successfully.");
			} catch(Throwable e) {
				e.printStackTrace();
				extentLogs.fail("click show more option button", "Clicking on Show More Option Button is Unsuccessful.");
			}
		}
	}
	
	
	/**
	 * Select itinerary port.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectItineraryPort(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnItineraryPorts)) 
			{
			actionLib.selectByVisibleText(SearchLandingPage.ddnItineraryPorts, value, "Itinerary Ports");
			extentLogs.pass("Itinerary Ports", "'Itinerary Ports DropDown' Itinerary Ports Value Found.");				
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Itinerary Ports", "'Itinerary Ports DropDown' Itinerary Ports Value is not Found.");
		}
		
	}
	
	/**
	 * Select stateroom.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectStateroom(String value) throws Throwable{
		try
		{

				actionLib.selectByVisibleText(SearchLandingPage.ddnStaterooms, value, "Staterooms DropDown");
				extentLogs.pass("Staterooms DropDown", "'Staterooms DropDown' Staterooms Value Found.");
			
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Staterooms DropDown", "'Staterooms DropDown' Staterooms Value is not Found.");
		}
		
	}
	
	/**
	 * Select guests.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectGuests(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnNoOfGuests)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnNoOfGuests, value, "No Of Guests DropDown");
				extentLogs.pass("No Of Guests DropDown", "'No Of Guests DropDown' No Of Guests Value Found.");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("No Of Guests DropDown", "'No Of Guests DropDown' No Of Guests Value is not Found.");
		}
		
	}
	
	/**
	 * Select ship.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectShip(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnLengthOfCruise)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnShip, value, "Ship DropDown");
				extentLogs.pass("Ship", "'Ship DropDown' Ship Value Found.");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Ship", "'Ship DropDown' Ship Value is not Found.");
		}
		
	}
	
	
	/**
	 * Select no of guests.
	 *
	 * @throws Throwable the throwable
	 */
	public void selectNoOfGuests() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnNoOfGuests));
			extentLogs.pass("No Of Guests", "'No Of Guests DropDown' No Of Guests Value Found.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("No Of Guests", "'No Of Guests DropDown' No Of Guests Value is not Found.");
		}
		
	}
	
	/**
	 * Select state room.
	 *
	 * @throws Throwable the throwable
	 */
	public void selectStateRoom() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnMetaStateroom));
			actionLib.waitForElementPresent(btnSubMetaStateroom, 5000);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnSubMetaStateroom));
			actionLib.waitForElementPresent(btnStateroomLocation, 10000);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnStateroomLocation));
			extentLogs.pass("Selected State Room ", "State Room Selection is successfully.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Selected State Room ", "State Room Selection is Unsuccessful.");
		}		
	}
	
	/**
	 * Click on the month.
	 */
	public void clickOnTheMonth(){
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.btnMonthInput)) {
				java.util.List<WebElement> Months = CommonVariables.CommonDriver.get().findElements(SearchLandingPage.btnMonthInput);
				java.util.List<WebElement> MonthsList = CommonVariables.CommonDriver.get().findElements(SearchLandingPage.btnMonthLabel);
				for (int i=0;i<=Months.size();i++)
				{
					if(Months.get(i).isEnabled())
					{
						MonthsList.get(i).click();
						break;
					}
				}
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception);
		}
	}
	
	/**
	 * Click on view results.
	 */
	public void clickOnViewResults() {
		if(actionLib.IsElementVisible(SearchLandingPage.btnViewResults)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnViewResults));
				extentLogs.pass("click View Results button", "Clicked on View Results Button Successfully.");
				if(actionLib.IsElementVisible(SearchLandingPage.btnpopUpClose)) {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnpopUpClose));
				}
				
			} catch(Throwable e) {
				e.printStackTrace();
				extentLogs.fail("click View Results button", "Clicked on View Results Button is UnSuccessful.");
			}
		}
	}
	
	/**
	 * Select zone location.
	 *
	 * @throws Throwable the throwable
	 */
	public void selectZoneLocation() throws Throwable{
		try
		{
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnZoneLocation));
			extentLogs.pass("click Zone Location button", "Clicked on Zone Location Button successfully.");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click Zone Location button", "Clicked on Zone Location Button is Unsuccessful.");
		}
	}
	
	/**
	 * Select deck group and location.
	 *
	 * @throws Throwable the throwable
	 */
	public void selectDeckGroupAndLocation() throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(btnDeckGroup)){
			actionLib.WaitForElementVisible(btnDeckOption, 10000);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnDeckGroup));
			actionLib.WaitForElementVisible(btnDeckOption, 5000);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnDeckOption));
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnDeckOption));
			extentLogs.pass("click Deck Group And Location button", "Clicked on Deck Group And Location Button successfully.");
			}	
			
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("click Deck Group And Location button", "Clicked on Deck Group And Location Button is Unsuccessful.");
		}
	}
	
	/**
	 * Select cabin.
	 *
	 * @throws Throwable the throwable
	 */
	public void selectCabin() throws Throwable{
		try
		{
			actionLib.FindElement(ddnCabin, timeoutInSecond).click();
			extentLogs.pass("Cabin", "'Cabin DropDown'Cabin Value is Found.");
			
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Cabin", "'Cabin DropDown'Cabin Value is not Found.");
		}
		
	}
	
	/**
	 * Select room.
	 *
	 * @param roomType the room type
	 * @throws Throwable the throwable
	 */
	public void selectRoom(String roomType) throws Throwable{
		try
		{
				actionLib.selectByVisibleText(ddnBedConfiguration, roomType, "Bed Configuration");
				extentLogs.pass("Bed Configuration", "Selected Bed Configuration Value successfully.");
		
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Bed Configuration", "Failed to Select Bed Configuration Value");
		}
	}
	
	/**
	 * Selectaccessiblestatroom check box.
	 */
	public void SelectaccessiblestatroomCheckBox(){
		try
		{
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnAccesscheckbox));	
				extentLogs.pass("Select accessible statroom CheckBox", "Selecting the accessible statroom CheckBox is Successfully.");
		
		}
		catch (Exception exception)
		{
			System.out.println(exception);
			extentLogs.fail("Select accessible statroom CheckBox", "Selecting the accessible statroom CheckBox is UnSuccessful.");
		}
	}	
	
	
	
}
