package com.princessCruise.web.automation.pages.myPrincess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.google.common.base.Optional;
import com.princessCruise.web.automation.accelerators.ActionsLibrary;
import com.princessCruise.web.automation.logs.ExtentLogs;
import com.princessCruise.web.automation.objectrepository.myPrincess.SignUpPage_OR;
import com.princessCruise.web.automation.utilities.CommonVariables;
import com.princessCruise.web.automation.utilities.ConfigManager;

public class SignUpPage extends  SignUpPage_OR {
	
	public ActionsLibrary actionLib;
	public ExtentLogs extentLogs=new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	public EventFiringWebDriver driver;
	
	public SignUpPage(WebDriver driver) {	
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
	public void fillSignUp(String firstName, String lastName, String emaild, String destination){
		
			if (actionLib.IsElementVisible(SignUpPage_OR.txtFirstName)) {
				try {
					actionLib.type(CommonVariables.CommonDriver.get().findElement(SignUpPage_OR.txtFirstName), firstName);				
					actionLib.type(CommonVariables.CommonDriver.get().findElement(SignUpPage_OR.txtLastName), lastName);
					actionLib.type(CommonVariables.CommonDriver.get().findElement(SignUpPage_OR.txtEmailId), emaild);
					actionLib.Click(CommonVariables.CommonDriver.get().findElement(SignUpPage_OR.btnSendMeOffers));
					extentLogs.pass("click Send Me Offers button", "Clicked on Send Me Offer Button successfully.");
				} catch (Throwable e) {
					e.printStackTrace();
				}

			} else {
				extentLogs.fail("First Name", "'First Name' First Name not Found.");
			}
					
		
	}
	
	public  void selectDestination(String destinationCode) {
		List<WebElement> destinationList = actionLib.FindElements(SignUpPage_OR.chkDestination,timeout(5));
		int destinationListSize = destinationList.size();
		for(int i=0; i < destinationListSize ; i++ ){			 
			 // Store the checkbox name to the string variable, using 'Value' attribute			 
			 String sValue = destinationList.get(i).getAttribute("value");		 
			 // Select the checkbox it the value of the checkbox is same what you are looking for		 
			 if (sValue.equalsIgnoreCase(destinationCode)){					 	
				 actionLib.Click(destinationList.get(i));
				 // This will take the execution out of for loop		 
				 break;		 
				 }
		 
			}
	}
	
	public void selectTravelAgent(String selectY_N) {
		List<WebElement> selectTravelAgentList = actionLib.FindElements(SignUpPage_OR.radTravelAgent,timeout(5));
		int selectTravelAgentListSize = selectTravelAgentList.size();
		for(int i=0; i < selectTravelAgentListSize ; i++ ){			 
			 // Store the checkbox name to the string variable, using 'Value' attribute			 
			 String sValue = selectTravelAgentList.get(i).getAttribute("value");		 
			 // Select the checkbox it the value of the checkbox is same what you are looking for		 
			 if (sValue.equalsIgnoreCase(selectY_N)){	
				 actionLib.Click(selectTravelAgentList.get(i));						 
				 // This will take the execution out of for loop		 
				 break;		 
				 }
		 
			}
		
	}
}
