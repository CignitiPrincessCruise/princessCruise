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
# (Comments)
Feature: Home Page

Scenario: Home Page Search Widget functionality is working and displaying correct results on the Search Results Page
	 Given Navigate to www.princess.com and validate text on the home page
	  When Click Month/Year: Any Drop Down
	 	 And fills the Month/Year details
	   And Click Destination: Any Drop Down 	
	   And fills the Destination details
	   And Click Departure/End Port 	
	 	 And fills the Departure/End details 
	   And Click on Cruise Length: Any	
	 	 And fills the Cruise Length details   
	   And Click 'View Results' Button	
	  Then validate cruise details button on the Results page 