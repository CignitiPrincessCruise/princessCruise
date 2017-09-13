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
 * The Class SearchLandingPage.
 */
public class SearchLandingPage {

	/** The lnk plan A cruise. */
	public static By lnkPlanACruise = By.cssSelector(".navbar-menu.clearfix>li:nth-child(1)>a");
	
	/** The ddn destination. */
	public static By ddnDestination = By.cssSelector("#destination-0");
	
	/** The ddn departure port. */
	public static By ddnDeparturePort = By.cssSelector("#embarkport-0");
	
	/** The ddn length of cruise. */
	public static By ddnLengthOfCruise = By.cssSelector("#duration-0");
	
	/** The btn show more option. */
	public static By btnShowMoreOption = By.cssSelector(".plain-text-btn.show-more-btn");
	
	/** The ddn ship. */
	public static By ddnShip = By.cssSelector("#ship-0");
	
	/** The ddn itinerary ports. */
	public static By ddnItineraryPorts = By.cssSelector("#itinerary-port-0");
	
	/** The ddn staterooms. */
	public static By ddnStaterooms= By.cssSelector("#stateroom-0");
	
	/** The ddn no of guests. */
	public static By ddnNoOfGuests= By.cssSelector("#passenger-0");
	
	/** The btn view results. */
	public static By btnViewResults = By.cssSelector("#view");
	
	/** The btn month input. */
	public static By btnMonthInput = By.cssSelector("span[class='button-checkbox filter-date-checkbox']>input");
	
	/** The btn month label. */
	public static By btnMonthLabel = By.cssSelector("span[class='button-checkbox filter-date-checkbox']>label");
	
	/** The btnpop up close. */
	public static By btnpopUpClose = By.cssSelector("[title='Close (Esc)']");
	
	/** The btncruistour. */
	public static By btncruistour = By.id("tour-a");
	
	/** The ddn length of cruisetour. */
	public static By ddnLengthOfCruisetour = By.xpath("//*[@id='land-duration-0']");
	
	/** The ddntrvlseq. */
	public static By ddntrvlseq = By.xpath("//*[@id='travelsequence-0']");
	
	/** The ddncruisetourcat. */
	public static By ddncruisetourcat = By.xpath("//*[@id='subtrade-0']");
	
	/** The ddnintrprices. */
	public static By ddnintrprices = By.xpath("//[@id='stateroom-0']");
	
	/** The btn cruisedbefore. */
	public static By btnCruisedbefore = By.xpath("//*[@id='cruised-with-princess']");
	
	/** The btnresetfilters. */
	public static By btnresetfilters = By.xpath("//*[@id='search-results']/div/button[2]");
	
	/** The btn cruise detail. */
	public static By btnCruiseDetail = By.xpath("//button[text()='Cruise Details']");
	
	/** The btn select A room. */
	public static By btnSelectARoom = By.xpath("//button/span[@class='xs-hidden sm-hidden']");
	
	/** The btn no of guests. */
	public static By btnNoOfGuests = By.xpath("//div[text()='Guests']/preceding-sibling::div[text()='2']/parent::button");
	
	/** The btn meta stateroom. */
	public static By btnMetaStateroom = By.cssSelector("#Suite>button");
	
	/** The btn sub meta stateroom. */
	public static By btnSubMetaStateroom = By.xpath("//div[text()='Owners Suite']/../following-sibling::div//button[contains(text(),'Select from')]");
	
	/** The btn stateroom location. */
	public static By btnStateroomLocation = By.cssSelector("#section-choose .section-choose #pick-stateroom");
	
	/** The btndestinationdefault. */
	public static By btndestinationdefault = By.xpath("//select[@id='destination-0']/option[1]");
	
	/** The btndepaturedefault. */
	public static By btndepaturedefault = By.xpath("//select[@id='embarkport-0']/option[1]");
	
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("100000"));
	
	/**
	 * Instantiates a new search landing page.
	 *
	 * @param driver the driver
	 */
	public SearchLandingPage(WebDriver driver)
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
	
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.lnkPlanACruise));
				extentLogs.pass("click plan a cruise button", "Clicked on Plan A Cruise link Successfully.");
			} catch(Throwable e){
				e.printStackTrace();
				extentLogs.fail("click plan a cruise button", "Clicked on Plan A Cruise link is Unsuccessful");
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
				extentLogs.fail("click show more option button", "Clicked on Show More Option Button is UnSuccessful");
			}
		}
	}
	
	/**
	 * Click on view results.
	 */
	public void clickOnViewResults() {
		if(actionLib.IsElementVisible(SearchLandingPage.btnViewResults)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnViewResults));
				
				if(actionLib.IsElementDisplayInCurrentView(SearchLandingPage.btnpopUpClose)) {
					
					actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnpopUpClose));
				}
				extentLogs.pass("click View Results button", "Clicked on View Results Button Successfully.");
				
			} catch(Throwable e) {
				e.printStackTrace();
				extentLogs.fail("click View Results button", "Clicked on View Results Button is UnSuccessful");
			}
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
				extentLogs.pass("Select the Month", "Month Selected Successfully.");
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception);
			extentLogs.fail("Select the Month", "Month Selection is unsuccessful");
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
				extentLogs.pass("Destination", "'Destination DropDown' Destination Value Found.");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Destination", "'Destination DropDown' Destination Value is not  Found.");
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
	 * Select ship.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectShip(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnShip)) {
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
			if(actionLib.IsElementVisible(SearchLandingPage.ddnStaterooms)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnStaterooms, value, "Staterooms DropDown");
				extentLogs.pass("Staterooms DropDown", "'Staterooms DropDown' Staterooms Value is Found.");
			}
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
	 * Search cruisetours tab.
	 */
	public void SearchCruisetoursTab() {
		
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btncruistour));
				extentLogs.pass("click on search cruisetour tab", "Clicked on search cruise tour tab Successfully.");
			} catch(Throwable e){
				e.printStackTrace();
				extentLogs.fail("click on search cruisetour tab", "Clicked on search cruise tour tab is UnSuccessful");
			}
		
	}
	
	/**
	 * Select lengthof cruisetour.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectLengthofCruisetour(String value) throws Throwable{
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.ddnLengthOfCruisetour)) {
				actionLib.selectByVisibleText(SearchLandingPage.ddnLengthOfCruisetour, value, "Length of Cruise tour DropDown");
				extentLogs.pass("Length of Cruise tour", "Selected value from Length of Cruise tour dropdown");
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Length of Cruise tour", "Failed to Select the value from Length of Cruise tour dropdown");
		}
		
	}
	
	/**
	 * Select travel sequence.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectTravelSequence(String value) throws Throwable{
		try
		{
				actionLib.selectByVisibleText(SearchLandingPage.ddntrvlseq, value, "Travel sequence DropDown");
				extentLogs.pass("Travel Sequence", "Selected value from travel sequence dropdown");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Travel Sequence", "Failed to Select the value from travel sequence dropdown");
		}
		
	}
	
	/**
	 * Select cruisetour category.
	 *
	 * @param value the value
	 * @throws Throwable the throwable
	 */
	public void selectCruisetourCategory(String value) throws Throwable{
		try
		{
				actionLib.selectByVisibleText(SearchLandingPage.ddncruisetourcat, value, "Travel sequence DropDown");
				extentLogs.pass("Cruise Category", "Selected value from cruise category dropdown");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			extentLogs.fail("Cruise Category", "Failed to Select value from cruise category dropdown");
		}
	}
	
	/**
	 * Click on the cruisedbefore CB.
	 */
	public void clickOnTheCruisedbeforeCB(){
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.btnCruisedbefore)) {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnCruisedbefore));
				extentLogs.pass("click on search cruisebefore Checkbox", "clicking on search cruisebefore Checkbox Successfully.");
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception);
			extentLogs.fail("click on search cruisebefore Checkbox", "clicking on search cruisebefore Checkbox is unSuccessful");
		}
	}	

	/**
	 * Click on reset filters.
	 */
	public void clickOnResetFilters(){
		try
		{
			if(actionLib.IsElementVisible(SearchLandingPage.btnresetfilters)) {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnresetfilters));	
				extentLogs.pass("click on Reset Filters Link", "clicking on Reset Filters Link Successfully.");
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception);
			extentLogs.fail("click on Reset Filters Link", "clicking on Reset Filters Link is Unsuccessful.");
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
	 * Verify defaultvalue dest.
	 *
	 * @param def_dest the def dest
	 */
	public void VerifyDefaultvalueDest(String def_dest) {
		try {
			String defaultValueText = actionLib.getElementText(btndestinationdefault, "Found Text Value");
			System.out.println(defaultValueText+" && "+def_dest);
			actionLib.compareValues(def_dest, defaultValueText, "Actual and Expected values are not same");
			extentLogs.pass("Verify Default destination value", "Successfully Verified destination value");
		} catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Verify Default destination value", "Failed to verify destination value");
		}
		
	}

	/**
	 * Verify defaultvalue dep.
	 *
	 * @param def_dep the def dep
	 */
	public void VerifyDefaultvalueDep(String def_dep) {
		try {
			String defaultValueText = actionLib.getElementText(btndepaturedefault, "Found Text Value");
			System.out.println(defaultValueText+" && "+def_dep);
			actionLib.compareValues(def_dep, defaultValueText, "Actual and Expected values are not same");
			extentLogs.pass("Verify Default departure value", "Successfully Verified departure value");
		} catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Verify Default departure value", "Failed to verify departure value");
		}
		
		
	}
	
	
}

