#Author: Cigniti
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
Feature: Landing page functionality 			
         Will display after entering EZair link for first time booking flow
 
  Scenario: Landing Page EZ001
  Given Launch EZ Air Application 
  When Landing page should display	
  Then Tell us who you are are are booking for Should list all guests from Polar booking
	And Direction dropdown Should default to Departure and Return 	
	And Class	Should default to Economy	
	And Maximum Stops	Should defaults to Any	
	And Airline	Should default to All
	And Departure To dropdown	and Return From dropdown	
	And Add another flight link Should drop down more boxes in order to add a stopover
	And Departure  From box is not null 
	And Departure To dropdown is not null
	And Return From dropdown is not null
	And Return To dropdown is not null
	And Cruise Deprature and Arrive On Box is not null
	And Cruise Return	and Leave On Box is not null
	And Departure Arrive by dropdown is not null	
	And Return Leave at dropdown is not null	
	When Click On Search Button
	Then Verify the application is redirecting to waiting page
  
  
	Scenario: Depart Search Results functionality	EZ0002	
	Given Launch EZ Air Application 
	When Get Default Departure From and To City Value
	And Click On Search Button	
	Then Verify the application is redirecting to waiting page
	Then Steps Bar	Should display One to five	
	And Select Your Depart Flight	Should display home airport to port city and date
	And Currency- Fares in XXX Should be correct currency displaying
	And flights found Should display correct number of flight options listed on page	
	And Sort by dropdown Should default to Fare low to high
	And What are Flexible and Restricted Fares Link Should be able to click and have a lightbox display	
	And Filters	Should be sectioned with Fare Type, Stops, Departure Time, and Airlines	
	And Flight options Should display Airline name, flight schedule and duration	
	When Click show details Light box should display with a breakdown of flight schedule	
	And Click fare restrictions	Light box should display the descriptions of flexible and restricted fare types	
	Then Fare Card	Should Diplay round trip for Flexible type
	And Click Select on flexible fare card Should be taken to Return Flight options	
		
	Scenario: Depart Search Results functionality	EZ0003
	Given Launch EZ Air Application 
	When Get Default Departure From and To City Value
	And Click On Search Button
	Then Verify the application is redirecting to waiting page	
	And Steps Bar	Should display One to five
	And Select Your Depart Flight	Should display home airport to port city and date	
	And Currency- Fares in XXX Should be correct currency displaying
	And flights found Should display correct number of flight options listed on page	
	And Sort by dropdown Should default to Fare low to high
	And What are Flexible and Restricted Fares Link Should be able to click and have a lightbox display	
	And Filters	Should be sectioned with Fare Type, Stops, Departure Time, and Airlines	
	And Flight options Should display Airline name, flight schedule and duration	
	When Click show details Light box should display with a breakdown of flight schedule	
	And Click fare restrictions	Light box should display the descriptions of flexible and restricted fare types	
	Then Fare Card	Should Diplay non refundable for restricted type
	And Click Select on restricted fare card Should be taken to Return Flight options
		
	Scenario: Return Search Results Functionality	EZ0004
	Given Launch EZ Air Application 
	When Get Default Return From and To City Value
	And  Click On Search Button
	Then Verify the application is redirecting to waiting page
	And Steps Bar	Should display One to five	
	And Currency- Fares in XXX Should be correct currency displaying
	And flights found Should display correct number of flight options listed on page	
	And Sort by dropdown Should default to Fare low to high
	And What are Flexible and Restricted Fares Link Should be able to click and have a lightbox display	
	And Filters	Should be sectioned with Fare Type, Stops, Departure Time, and Airlines	
	And Flight options Should display Airline name, flight schedule and duration	
	When Click show details Light box should display with a breakdown of flight schedule	
	And Click fare restrictions	Light box should display the descriptions of flexible and restricted fare types	
	Then Fare Card	Should Diplay round trip for Flexible type
	When Click Select on flexible fare card Should be taken to Return Flight options
	Then Select Your Return Flight	Should display port city to home city and date		
	And Click Select on fare card Should be taken to Summary page	
	
	Scenario: Return Search Results Functionality	EZ0005
	Given Launch EZ Air Application
	When Get Default Return From and To City Value
	And Click On Search Button
	Then Verify the application is redirecting to waiting page	
	And Steps Bar	Should display One to five	
	And Currency- Fares in XXX Should be correct currency displaying
	And flights found Should display correct number of flight options listed on page	
	And Sort by dropdown Should default to Fare low to high
	And What are Flexible and Restricted Fares Link Should be able to click and have a lightbox display	
	And Filters	Should be sectioned with Fare Type, Stops, Departure Time, and Airlines	
	And Flight options Should display Airline name, flight schedule and duration	
	When Click show details Light box should display with a breakdown of flight schedule	
	And Click fare restrictions	Light box should display the descriptions of flexible and restricted fare types	
	Then Fare Card	Should Diplay non refundable for restricted type
	When Click Select on restricted fare card Should be taken to Return Flight options	
	Then Select Your Return Flight	Should display port city to home city and date
	And Click Select on restricted fare card Should be taken to Summary page	
	