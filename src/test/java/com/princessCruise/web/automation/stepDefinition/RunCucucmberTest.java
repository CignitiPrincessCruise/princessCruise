package com.princessCruise.web.automation.stepDefinition;

import org.testng.annotations.Test;
import com.princessCruise.web.automation.accelerators.TestEngineWeb;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;
@CucumberOptions(features = "C:\\auto\\princessCruise\\princessCruise\\src\\test\\resources\\testFeature\\PlanACruise.feature",plugin = "json:C:\\auto\\princessCruise\\princessCruise\\target\\cucumber-report-composite.json")
public class RunCucucmberTest extends TestEngineWeb {
	@Test(groups = "smoke", description = "testing cucumber")
    public void findACruise() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
	
	
	@Given("^the user is on the home page$")
	public void the_user_is_on_the_home_page() throws Throwable {
	 System.out.println("^the user is on the home page$"); 
	}

	@When("^the user clicks on 'Plan a Cruise' link$")
	public void the_user_clicks_on_Plan_a_Cruise_link() throws Throwable {
		System.out.println("the user clicks on 'Plan a Cruise' link$");   
	}

	@When("^is redirected to the 'Find your perfect Cruise vacation' page$")
	public void is_redirected_to_the_Find_your_perfect_Cruise_vacation_page() throws Throwable {
		System.out.println("is redirected to the 'Find your perfect Cruise vacation' page"); 
	}

	@When("^fills all the details on 'Find your perfect Cruise vacation' page$")
	public void fills_all_the_details_on_Find_your_perfect_Cruise_vacation_page() throws Throwable {
		System.out.println("^fills all the details on 'Find your perfect Cruise vacation' page$"); 
	}

	@When("^clicks on 'View Results' button$")
	public void clicks_on_View_Results_button() throws Throwable {
		System.out.println("^^clicks on 'View Results' button$"); 
	}

	@Then("^the user is redirected to search result page$")
	public void the_user_is_redirected_to_search_result_page() throws Throwable {
		System.out.println("the user is redirected to search result page$");   
	}

	@Then("^available tours are displayed$")
	public void available_tours_are_displayed() throws Throwable {
		System.out.println("^available tours are displayed$");  
	}
}
