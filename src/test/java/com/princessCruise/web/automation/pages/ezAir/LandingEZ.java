package com.princessCruise.web.automation.pages.ezAir;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

/**
 * The Class LandingEZ.
 */
public class LandingEZ {
	
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	
	/**
	 * Instantiates a new landing EZ.
	 *
	 * @param driver the driver
	 */
	public LandingEZ(WebDriver driver)
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
	
	/** The from cityvalue. */
	public String fromCityvalue;
	
	/** The to city value. */
	public String toCityValue;
	
	/** The chk guest 1. */
	public static By chkGuest1 = By.xpath("//div[@id='ez-search-unbooked']//input[@id='ez-guest-id-01']");
	
	/** The chk guest 2. */
	public static By chkGuest2 = By.xpath("//div[@id='ez-search-unbooked']//input[@id='ez-guest-id-02']");
	
	/** The ddn direction. */
	public static By ddnDirection = By.xpath("//select[@id='ez-search-direction']/option[@selected='selected']");
	
	/** The ddn class. */
	public static By ddnClass = By.xpath("//select[@id='ez-search-class']/option[@selected='selected']");
	
	/** The ddn max stops. */
	public static By ddnMaxStops = By.xpath("//select[@id='ez-search-nonstop']");
	
	/** The ddn airline. */
	public static By ddnAirline = By.xpath("//select[@id='ez-search-airline']/option[@selected='selected']");
	
	/** The lbl dep to city. */
	public static By lblDepToCity = By.xpath("//span[@id='ez-search-dpt-city-title']");
	
	/** The ddn dep to. */
	public static By ddnDepTo = By.xpath("//select[@id='ez-search-dpt-to-singlecity']//option[@selected='selected']");
	
	/** The ddn dep from. */
	public static By ddnDepFrom = By.xpath("//input[@id='ez-search-dpt-from-singlecity-extended']");
	
	/** The txt box return to. */
	public static By txtBoxReturnTo = By.cssSelector("#ez-search-rtn-to-singlecity-extended");
	
	/** The ddn return from. */
	public static By ddnReturnFrom = By.xpath("//select[@id='ez-search-rtn-from-singlecity']//option[@selected='selected']");
	
	/** The btn search. */
	public static By btnSearch = By.xpath("//button[@id='search-submit-btn']");
	
	/** The departure form fields. */
	public static By departureFormFields = By.cssSelector("#ez-search-dpt-body #ez-search-dpt-fields div[class^='ez-search'] .row>span");
	
	/** The return form fields. */
	public static By returnFormFields = By.cssSelector("#ez-search-rtn-body #ez-search-rtn-fields div[class^='ez-search'] .row>span");
	
	/** The btn dep add flight. */
	public static By btnDepAddFlight = By.xpath("//button[@id='ez-search-dpt-add']");
	
	/** The btn ret add flight. */
	public static By btnRetAddFlight = By.xpath("//button[@id='ez-search-rtn-add']");
	
	/** The txt box arrive on. */
	public static By txtBoxArriveOn = By.xpath("//input[@id='ez-search-dpt-arrival-date-singlecity']");
	
	/** The lbl from and to city. */
	public static By lblFromAndToCity = By.xpath("//h1[text()='Select Your Departure Flight']/following-sibling::h2/span");
	
	/** The lbl ret from and to city. */
	public static By lblRetFromAndToCity = By.xpath("//h1[text()='Select Your Return Flight']/following-sibling::h2/span");
	
	/** The currency fares. */
	public static By currencyFares = By.cssSelector("#ez-rslt-main-container form[id='ez-rslt-main']>div:nth-child(2)>div:nth-child(2) [class^='ez-fare-total']");
	
	/** The list of flights. */
	public static By listOfFlights = By.xpath("//div[contains(text(),'Total Duration')]");
	
	/** The lbl flights found. */
	public static By lblFlightsFound = By.xpath("//span[@id='ez-rslt-found-count']");
	
	/** The ddn sort by. */
	public static By ddnSortBy = By.xpath("//select[@id='ez-rslt-sort']");
	
	/** The lnk flexible and restricted fares. */
	public static By lnkFlexibleAndRestrictedFares = By.xpath("//a[@title='Fare Type Comparison Chart']");
	
	/** The btn pop up close. */
	public static By btnPopUpClose = By.xpath("//button[@title='Close (Esc)']");
	
	/** The lnk show details. */
	public static By lnkShowDetails = By.xpath("//a[text()='Show details']");
	
	/** The lnk fare restrictions. */
	public static By lnkFareRestrictions = By.xpath("//a[text()='Fare Restrictions']");
	
	/** The lbl flexible description. */
	public static By lblFlexibleDescription = By.xpath("//div[@id='ez-flexible-disclaimer-tab']/ul/li");
	
	/** The btn restricted. */
	public static By btnRestricted = By.xpath("//a[@title='Restricted']");
	
	/** The lbl restricted description. */
	public static By lblRestrictedDescription = By.xpath("//div[@id='ez-restricted-disclaimer-tab']/ul/li");
	
	/** The lbl filters. */
	public static By lblFilters = By.xpath("//div[@id='ez-rslt-filters']//fieldset[@class='no-spacing']/legend");
	
	/** The btn dep flexible select. */
	public static By btnDepFlexibleSelect = By.cssSelector("#ez-rslt-main-container form[id='ez-rslt-main'] div[data-faretype='flexible'] button");
	
	/** The btn dep restricted select. */
	public static By btnDepRestrictedSelect = By.cssSelector("#ez-rslt-main-container form[id='ez-rslt-main'] div[data-faretype='restricted'] button");
	
	/** The lbl return. */
	public static By lblReturn = By.xpath("//div[@id='ez-rslt-header-return']//h1[@class='sm-inline-block no-caps']");
	
	/** The lbl airline name. */
	public static By lblAirlineName = By.cssSelector("#ez-rslt-main-container form[id='ez-rslt-main']>div>div h3");
	
	/** The flight schedule. */
	public static By flightSchedule = By.cssSelector("#ez-rslt-main-container form[id='ez-rslt-main']>div div [class^='itn-origin'] time");
	
	/** The lbl flight duration. */
	public static By lblFlightDuration = By.cssSelector("#ez-rslt-main-container form[id='ez-rslt-main']>div div [class^='itn-total-duration']");
	
	/** The lbl summary. */
	public static By lblSummary = By.xpath("//li[@id='ez-step-summary']");
	
	/** The lbl summary header. */
	public static By lblSummaryHeader =By.xpath("//div[@id='ez-rslt-header-summary']/h1");
	
	/** The btn ret flexible select. */
	public static By btnRetFlexibleSelect = By.cssSelector("#ez-rslt-return-container form[id='ez-rslt-return'] div[data-faretype='flexible'] button");
	
	/** The btn ret restricted select. */
	public static By btnRetRestrictedSelect = By.cssSelector("#ez-rslt-return-container form[id='ez-rslt-return'] div[data-faretype='restricted'] button");
	
	/** The btn pop up continue. */
	public static By btnPopUpContinue = By.xpath("//div[@id='popupContent']//button[text()='Continue']");
	
	/** The lbl flexible fare card. */
	public static By lblFlexibleFareCard = By.cssSelector("form[id='ez-rslt-main'] div[data-faretype='flexible'] [class^='ez-fare-info gotham']");
	
	/** The lbl restricted fare card. */
	public static By lblRestrictedFareCard = By.cssSelector("form[id='ez-rslt-main'] div[data-faretype='restricted'] [class^='ez-fare-info gotham']");
	
	/** The logo EZ air. */
	public static By logoEZAir = By.xpath("//div[@class='ez-waiting-logo']");
	
	/** The lbl cruise departure. */
	public static By lblCruiseDeparture = By.xpath("//span[text()='Cruise Departure:']/following-sibling::span");
	
	/** The lbl cruise return. */
	public static By lblCruiseReturn = By.xpath("//span[text()='Cruise Return:']/following-sibling::span");
	
	/** The ddn arrive by. */
	public static By ddnArriveBy = By.cssSelector("#ez-search-dpt-arrival-time-singlecity");
	
	/** The txt box leave on. */
	public static By txtBoxLeaveOn = By.cssSelector("#ez-search-rtn-depart-date-singlecity");
	
	/** The ddn leave at. */
	public static By ddnLeaveAt = By.cssSelector("#ez-search-rtn-depart-date-singlecity");
	
	/** The lbl landing page header. */
	public static By lblLandingPageHeader = By.cssSelector("#ez-search-header>h1");
	
	/** The lbl step bar. */
	public static By lblStepBar = By.cssSelector("#steps-bar>ol>li div:nth-child(1)");
	
	/** The flight breakdown. */
	public static By flightBreakdown = By.cssSelector("#popupContent .itn-stop-container");

	/**
	 * Verify landing page is displayed.
	 *
	 * @param landingPageHeader the landing page header
	 */
	public void verifyLandingPageIsDisplayed(String landingPageHeader){
		try {
			String headerText = actionLib.getElementText(lblLandingPageHeader, "Found Text Value");
			actionLib.compareValues(landingPageHeader, headerText, "Actual and Expected values are not same");
			extentLogs.pass("Landing Page", "Successfully Verified Landing Page Is Displayed");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Landing Page","Unable to Verify Landing Page");
		}
	}
	
	/**
	 * Verify step bar.
	 */
	public void verifyStepBar(){
		try {
			verifyDataIsDisplayed(lblStepBar);
			extentLogs.pass("Steps Bar", "Successfully Verified Steps Bar Is Displayed");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Steps Bar","Unable to Verify Steps Bar");
		}
	}
	
	/**
	 * Verify all guests.
	 *
	 * @param element the element
	 */
	public void verifyAllGuests(By element){
		try {
			boolean  value = CommonVariables.CommonDriver.get().findElement(element).isSelected();
			if(value == true){
				extentLogs.pass("Guests Check Box", "Successfully Verifieed Guests check Box");
			}
		} catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Guests Check Box","Unable to Verify Guests Check Box");
		}
	}

	/**
	 * Verify arrive and leave on fields.
	 *
	 * @param field the field
	 * @param label the label
	 */
	public void verifyArriveAndLeaveOnFields(By field , By label){
		try {
			String actual = actionLib.getElementAttribute(field,"value","Found Value");
			String expected = actionLib.getElementText(label,"Found Label Value");
			Assert.assertNotNull("Is Not Null Verified", field);
			actionLib.checkStringContains(expected,actual, "Successfully Verified Arrive and Leave On Field is not null");
			extentLogs.pass("Arrive and Leave On Field", "Successfully Verified Arrive and Leave On Field is not null");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Arrive and Leave On Field","Unable to Verify  Arrive and Leave On Field is not null");
		}
	}
	
	/**
	 * Verify field value.
	 *
	 * @param element the element
	 */
	public void verifyFieldValue(By element){
		try {
			Assert.assertNotNull("Is Not Null Verified", element);
			extentLogs.pass("Field", "Successfully Verified Field is not null");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Field","Unable to Verify Field is not null");
		}
	}
	
	/**
	 * Verify flight option drop downs.
	 *
	 * @param element the element
	 * @param defalutValue the defalut value
	 */
	public void verifyFlightOptionDropDowns(By element , String defalutValue){
		try {
			String defaultValueText = actionLib.getElementText(element, "Found Text Value");
			actionLib.compareValues(defalutValue, defaultValueText, "Actual and Expected values are not same");
			extentLogs.pass("Choose Flight Options", "Successfully Verified Flight Options");
		} catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Choose Flight Options", "Unable to Verify Flight Options");
		}
	}
	
	/**
	 * Verify drop down default value.
	 *
	 * @param defalutValue the defalut value
	 * @param element the element
	 */
	public void verifyDropDownDefaultValue(String defalutValue,By element){
		try {
			WebElement option = CommonVariables.CommonDriver.get().findElement(element);
			Select defaultValue = new Select(option);
			String value = defaultValue.getFirstSelectedOption().getText();
			actionLib.compareValues(value, defalutValue, "Actual and Expected value are not same");
			extentLogs.pass("Verify Drop Down Default VAlue", "Successfully Verified Drop Down Default Value");
		} catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Verify Drop Down Default VAlue", "Unable to Verify Drop Down Default Value");
		}
	}
	
	/**
	 * Verify departure to and return from drop down.
	 */
	public void verifyDepartureToAndReturnFromDropDown(){
		try {
			String lblDepText = actionLib.getElementText(lblDepToCity, "Found Label Departure Text");
			String ddnDepToValue = actionLib.getElementText(ddnDepTo, "Found Departure To DropDown");
			String ddnReturnFromValue = actionLib.getElementText(ddnReturnFrom, "Found Return From DropDown");
			actionLib.compareValues(ddnDepToValue, ddnReturnFromValue, "Actual and Expected value are not same");
			actionLib.checkStringContains(ddnDepToValue.toUpperCase(),lblDepText.toUpperCase(), "Actual and Expected value are not same");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Choose Flight Options", "Unable to Verify Flight Options");
		}		
	}
	
	/**
	 * Pop up close.
	 */
	public void popUpClose(){
		try {
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnPopUpClose), "Pop - Up Close Button");
			extentLogs.pass("Pop - Up Close Button", "Successfully Clicked On Pop - Up Close Button");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Pop - Up Close Button", "Unable to Perform Click Operation on Pop - Up Close Button");
		}
	}
	
	/**
	 * Click on search button.
	 */
	public void clickOnSearchButton(){
		try {
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnSearch), "Search Button");
			actionLib.waitForVisibilityOfElement(logoEZAir, "Waiting Page After Cliking on Search Button", 300000);
			extentLogs.pass("Search Button", "Successfully Clicked On Search Button");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Search Button", "Unable to Perform Click Operation on Search Button");
		}
	}
	
	/**
	 * Verify ret and dep add flight.
	 *
	 * @param element the element
	 * @param button the button
	 */
	public void verifyRetAndDepAddFlight(By element ,By button){
		try {
			int ddnList = actionLib.CountElement(element, timeoutInSecond, "List of Drop Down Before Stoppers");
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(button), button+" Button");
			int ddnList2 = actionLib.CountElement(element, timeoutInSecond, "List of Drop Down After Stoppers");
			Assert.assertFalse(ddnList!=ddnList2);
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(button), button+" Button");
			extentLogs.pass("Add Another Flight", "Successfully Verified More Drop Down Boxes to Add Stop Overs");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Add Another Flight", "Unable to Perform Click Operation on Add Another Flight Button");
		}
	}

	/**
	 * Gets the from city.
	 *
	 * @param element the element
	 * @return the from city
	 */
	public String getFromCity(By element){
		try {
			fromCityvalue = actionLib.getElementText(element, "Found Value");
		}
		catch(Throwable e){
			e.printStackTrace();	
		}
		return fromCityvalue;
	}
	
	/**
	 * Gets the to city.
	 *
	 * @param element the element
	 * @return the to city
	 */
	public String getToCity(By element){
		try {
			toCityValue = actionLib.getElementAttribute(element,"value","Found Value");
			Thread.sleep(10000);
		}
		catch(Throwable e){
			e.printStackTrace();

		}
		return toCityValue;
	}

	/**
	 * Verify from port and to port and date.
	 *
	 * @param journey the journey
	 * @param element the element
	 */
	public void verifyFromPortAndToPortAndDate(String journey ,By element){
		try {
			String expectedValue;
			if(journey == "Return"){
				expectedValue = fromCityvalue + " To " + toCityValue  + " on ";
			}
			else{
				expectedValue = toCityValue  + " To " + fromCityvalue  + " on ";
			}
			String actualValue = actionLib.getElementText(element, "Found home airport to port city and date");
			Assert.assertTrue(actualValue.contains(expectedValue));
			extentLogs.pass("From and To Port City And Date", "Successfully Verify From and To Port City And Date");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("From and To Port City And Date", "Unable to Verify From and To Port City And Date");
		}
	}
	
	/**
	 * Verify EZ air logo.
	 */
	public void verifyEZAirLogo(){
		try {
			if(actionLib.IsElementVisible(logoEZAir)){
				actionLib.waitForVisibilityOfElement(lblFromAndToCity, "Departure Header Label", 40000);
				extentLogs.pass("EZ Air Logo", "Verified the EZ Air Logo");
			}
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("EZ Air Logo", "Unable to Verify the EZ Air Logo");
		}
	}
	
	/**
	 * Verify currency fares.
	 */
	public void verifyCurrencyFares(){
		try {
			if(actionLib.IsElementVisible(currencyFares)){
				List<WebElement> fares = actionLib.FindElements(currencyFares, timeoutInSecond);
				for(WebElement price :fares){
					String priceValue = price.getText().toString();
					Assert.assertTrue(priceValue.contains("$"));
					extentLogs.pass("Currency Fares", "Successfully Verified Currency Fares");
				}
			}
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Currency Fares", "Unable to Verify Currency Fares");
		}
	}

	/**
	 * Verify no of flights found.
	 */
	public void verifyNoOfFlightsFound(){
		try {
			int noOfFlights  = actionLib.CountElement(lblFlightDuration, timeoutInSecond, "No Of Flights Found");
			String lblFlightsFoundText = actionLib.getElementText(lblFlightsFound, "No Of Flights");	
			int flightCount = Integer.parseInt(lblFlightsFoundText.substring(0,2));
			Assert.assertTrue(noOfFlights==flightCount);
			extentLogs.pass("Number Of Flights Found", "Unable to Verify Number of Flights Found");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Number Of Flights Found", "Successfully Verified Number of Flights Found");
		}
	}
	
	/**
	 * Click on what are flex and rest fares.
	 */
	public void clickOnWhatAreFlexAndRestFares(){
		try {
			actionLib.Click(CommonVariables.CommonDriver.get().findElement(lnkFlexibleAndRestrictedFares), "Flexible And Restricted Fares");
			popUpClose();
			extentLogs.pass("Flexible And Restricted Fares", "Successfully Clicked On Flexible And Restricted Fares");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Flexible And Restricted Fares", "Unable to Perform Click Operation On Flexible And Restricted Fares");
		}
	}
	
	/**
	 * Verify flight break down.
	 */
	public void verifyFlightBreakDown(){
		try {
			List<WebElement> flightBreakdwn = actionLib.FindElements(flightBreakdown,timeoutInSecond);
			if(flightBreakdwn.size()>0){
			for(WebElement stopOver :flightBreakdwn){
				Assert.assertTrue(stopOver.isDisplayed());
			}
			}
			else{
				Assert.assertTrue(CommonVariables.CommonDriver.get().findElement(flightBreakdown).isDisplayed());
			}
			extentLogs.pass("Flight BreakDown", "Successfully Flight BreakDown");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Flight BreakDown", "Unable to Perform Click Operation On Show Details");
		}
	}

	/**
	 * Click on show details.
	 */
	public void clickOnShowDetails(){
		try {
			List<WebElement> showDetails = actionLib.FindElements(lnkShowDetails, timeoutInSecond);
			for(WebElement flightDetails :showDetails){
				flightDetails.click();
				verifyFlightBreakDown();
				popUpClose();
				break;
			}
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Link Show Details", "Unable to Perform Click Operation On Show Details");
		}
	}
	
	/**
	 * Verify data is displayed.
	 *
	 * @param element the element
	 */
	public void verifyDataIsDisplayed(By element){
		try {
			List<WebElement> fareDescription = actionLib.FindElements(element,timeoutInSecond);
			for(WebElement description :fareDescription){
				Assert.assertTrue(description.isDisplayed());
			}
			extentLogs.pass("Description Of Flexible and Restricted Types", "Successfully Verified Description Of Flexible and Restricted Types");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Description Of Flexible and Restricted Types", "Unable to Verify Description Of Flexible and Restricted Types");
		}
	}

	/**
	 * Click on fare restrictions.
	 */
	public void clickOnFareRestrictions(){
		try {
			List<WebElement> fareRestrictions = actionLib.FindElements(lnkFareRestrictions, timeoutInSecond);
			for(WebElement fareResriction :fareRestrictions){
				fareResriction.click();
				actionLib.waitForVisibilityOfElement(lblFlexibleDescription, "Flexible", 5000);
				verifyDataIsDisplayed(lblFlexibleDescription);
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnRestricted), "Restricted Fares");
				actionLib.waitForVisibilityOfElement(lblRestrictedDescription, "Restricted", 5000);
				verifyDataIsDisplayed(lblRestrictedDescription);
				popUpClose();
				break;
			}
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Link Fare Restrictions", "Unable to Perform Click Operation On Link Fare Restrictions");
		}
	}
	
	/**
	 * Verify filters.
	 */
	public void verifyFilters(){
		try {
			verifyDataIsDisplayed(lblFilters);
			extentLogs.pass("List of Filters", "Verified List of Filters");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("List of Filters", "Unable to Verify List of Filters");
		}
	}
	
	/**
	 * Click on select button.
	 *
	 * @param element the element
	 */
	public void clickOnSelectButton(By element){
		try {
			List<WebElement> fareTypeList= actionLib.FindElements(element, timeoutInSecond);
			for(WebElement type :fareTypeList){
				type.click();
				Thread.sleep(10000);
				break;
			}
			extentLogs.pass("Select Button", "Successfully Clicked On Select Button");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Select Button", "Unable to Perform Click Operation on Select Button");
		}
	}
	
	/**
	 * Verify return flight page.
	 *
	 * @param fareType the fare type
	 * @throws InterruptedException the interrupted exception
	 */
	public void verifyReturnFlightPage(By fareType) throws InterruptedException{
		try {
			clickOnSelectButton(fareType);
			Thread.sleep(10000);
			try{
				int value = CommonVariables.CommonDriver.get().findElements(By.xpath("//div[@id='popupContent']//button[text()='Continue']")).size();
				if(value>0){
					actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnPopUpContinue), "Pop-Up Close button");
					Thread.sleep(10000);
				}
			}
			catch(Exception ex){
				System.out.println("No Pop-Up is Displayed.....");
			}
			Thread.sleep(10000);
			Assert.assertTrue(CommonVariables.CommonDriver.get().findElement(lblReturn).isDisplayed());
			extentLogs.pass("Return Flights Page", "Successfully Verified Return Flights Page");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Return Flights Page", "Unable to Verify Return Flights Page");
		}
	}
	
	/**
	 * Verify summary page.
	 *
	 * @param element the element
	 */
	public void verifySummaryPage(By element){
		try {
			clickOnSelectButton(element);
			Thread.sleep(10000);
			try{
				int value = CommonVariables.CommonDriver.get().findElements(By.xpath("//div[@id='popupContent']//button[text()='Continue']")).size();
				if(value<0){
					actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnPopUpContinue), "Pop-Up Close button");
					Thread.sleep(10000);
				}
			}
			catch(Exception ex){
				System.out.println("No Pop-Up is Displayed....");
			}
			Thread.sleep(10000);
			String summaryLabel = actionLib.getElementAttribute(lblSummary, "class", "Found Class Attribute");
			Assert.assertTrue(summaryLabel.contains("active"));
			Assert.assertTrue(CommonVariables.CommonDriver.get().findElement(lblSummaryHeader).isDisplayed());
			extentLogs.pass("Summary Page", "Successfully Verified Summary Page");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Summary Page", "Unable to Verify Summary Page");
		}
	}

	/**
	 * Verify flight options.
	 */
	public void verifyFlightOptions(){
		try {
			verifyDataIsDisplayed(lblAirlineName);
			verifyDataIsDisplayed(flightSchedule);
			verifyDataIsDisplayed(lblFlightDuration);
			extentLogs.pass("Flight Options", "Successfully Verified Flight Options");
		}
		catch(Throwable e){
			e.printStackTrace();
			extentLogs.fail("Flight Options", "Unable to Verify Flight Options");
		}
	}
}
