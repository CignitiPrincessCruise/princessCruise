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

Feature: Details Page
Background: 
   
Scenario: Move user from the Details Page to the Stateroom Page 
   Given Click on Plan A Cruise 
     And Itineraries text should appear as a result
    When Click on the View results button
     And Click on the Cruise Details button  
    Then Pricing is per person, double occupancy… text should appear as result
     And Click on Select Stateroom 

Scenario: Move user from the Details Page to the Stateroom Page
	Given Launch Princess Cruises
	  And Click on Plan A Cruise
	  And Itineraries text should appear as a result
   When Click on the View results button  
    And Click on the Cruise Details button
    And Click on Stateroom Type tab
    And Select Stateroom
   Then Verify text Stateroom Selection in Stateroom Page
  
 Scenario: Click the Change Date drop down to change the date
   Given Launch Princess Cruises
     And Click on Plan A Cruise
     And Itineraries text should appear as a result
    When Select the Destination from Destination DropDown 
     And Click on the View results button
     And Click on the Cruise Details button after new search  
     And Click on Select Stateroom
     And Click on Change Date dropdown
    Then Check if user is able to select new date   