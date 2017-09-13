package com.princessCruise.web.automation.pages.polarBear;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

/**
 * The Class PlanACruisePage.
 */
public class SearchResultsPage {
	
	/** The lnk plana cruise. */
	public static By lnkPlanaCruise = By.cssSelector("a[data-us-text='Plan a Cruise']");
	
	/** The lbl itineraries. */
	public static By lblItineraries = By.cssSelector("div[class='results-found-wrapper']>span");
	
	/** The btn view results. */
	//Label list
	public static By btnViewResults = By.xpath("//button[text()='View Results']");	
	
	/** The btn cruise details. */
	public static By btnCruiseDetails = By.id("select-cruise-details-E733");	
	
	/** The lbl pricing. */
	public static By lblPricing = By.cssSelector("a[data-mfp-title='Pricing Terms & Conditions']");
	
	/** The btn refine search. */
	public static By btnRefineSearch = By.id("refine-icon");
	
	
	/** The driver. */
	public WebDriver driver;
	
	/** The action lib. */
	public ActionsLibrary actionLib;
	
	/** The extent logs. */
	public ExtentLogs extentLogs=new ExtentLogs();
	
	/** The timeout in second. */
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	
	/**
	 * Instantiates a new plan A cruise page.
	 *
	 * @param driver the driver
	 */
	public SearchResultsPage(WebDriver driver)
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
	 * Timeout.
	 *
	 * @param time the time
	 * @return the optional
	 */
	public Optional<Long> timeout(Integer time)
	{
		return Optional.of(Long.parseLong(String.valueOf(time)));
	}
    
	/**
	 * Click on plan acriuse link.
	 */
	public void clickOnPlanAcriuseLink() {
		if(actionLib.IsElementVisible(lnkPlanaCruise)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(lnkPlanaCruise));
				extentLogs.pass("click Plan a Cruise", "Clicked on Plan a Cruise successfully.");
			} catch(Throwable e) {
				extentLogs.fail("click Plan a Cruise", "Unable to click on the Plan A Criuse link");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Verify itineraries.
	 */
	public void verifyItineraries() {
		if(actionLib.IsElementVisible(lblItineraries)) {
			try {
				List<WebElement> label=CommonVariables.CommonDriver.get().findElements(lblItineraries);
				for(WebElement labelValue : label )
				{
					Assert.assertTrue(labelValue.isDisplayed());
				     String txt=labelValue.getText();
				     extentLogs.pass("Verify Itineraries text ", "Itineraries text verifed successfully."+ txt);
				}
				
			} catch(Throwable e) {
				extentLogs.fail("Verify Itineraries text", "Failed to verify the text Itineraries ");
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Click on cruise details buton.
	 */
	public void clickOnCruiseDetailsButon() {
		if(actionLib.IsElementVisible(btnCruiseDetails)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnCruiseDetails));
				extentLogs.pass("Verify Cruise Details Button", "Cruise Details Button found and Clicked successfully.");
				
			} catch(Throwable e) {
				extentLogs.fail("Verify Cruise Details Button", "Failed to verify and click on cruise details button.");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Click on view result buton.
	 */
	public void clickOnViewResultButon() {
		
			try {								
				  actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnViewResults));
					if(actionLib.IsElementDisplayInCurrentView(SearchLandingPage.btnpopUpClose)) {
						actionLib.Click(CommonVariables.CommonDriver.get().findElement(SearchLandingPage.btnpopUpClose));
					}
				extentLogs.pass("Click on the view results button", "View results button found and Clicked on it successfully.");
			} catch(Throwable e) {
				extentLogs.fail("Click on the view result button", "Failed to verify and click on the view results button");
				e.printStackTrace();
			}
		
	}
	
	/**
	 * Verify cruise detailspage.
	 */
	public void verifyCruiseDetailspage() {
		if(actionLib.IsElementVisible(btnCruiseDetails)) {
			try {				
				extentLogs.pass("verify Cruise Details page", "Cruise Details page verified successfully.");
			} catch(Throwable e) {
				extentLogs.fail("verify Cruise Details page", "Failed to verify the page");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Verify homepage.
	 */
	public void verifyHomepage() {
		if(actionLib.IsElementVisible(lnkPlanaCruise)) {
			try {				
				extentLogs.pass("verify Home page", "Home page verified successfully.");
			} catch(Throwable e) {
				extentLogs.fail("verify Home page", "Failed to verify the page");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Verify pricing text.
	 */
	public void verifyPricingText() {
		if(actionLib.IsElementVisible(lblPricing)) {
			try {		
				String value=CommonVariables.CommonDriver.get().findElement(lblPricing).getText();
				extentLogs.pass("verify Pricing text", "Pricing text verified successfully and the value is "+value);
			} catch(Throwable e) {
				extentLogs.fail("verify Pricing text", "Failed to verify the text");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Click on refine search buton.
	 */
	public void clickOnRefineSearchButon() {
		if(actionLib.IsElementVisible(btnRefineSearch)) {
			try {
				actionLib.Click(CommonVariables.CommonDriver.get().findElement(btnRefineSearch));
				extentLogs.pass("click On Refine Search Button", "Clicked on Refine Search button successfully.");
			} catch(Throwable e) {
				extentLogs.fail("click On Refine Search Button", "Clicking on Refine Search button is Unsuccessful");
				e.printStackTrace();
			}
		}
	}
	
}
