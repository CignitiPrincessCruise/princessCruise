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


Feature: Search Results
Scenario: Select an itinerary and move to Details Page
  Given Click on Plan A Cruise
    And Itineraries text should appear as a result 
   When Click on the View results button
   Then verify the presence of cruiseDetails button and Click on the Cruise Deatils button
  
Scenario: Refine Search will refine the original search results - Cruise 
 	Given Click on Plan A Cruise
   When Select the Destination from Destination DropDown
    And Select the Departure from Departure Drop Down 
    And Select the Length of Cruise from Length Cruise Drop Down
    And Click on Show More Otions
    And Select Ship from Ship DropDown
    And Select the Itinerary Port from Itinerary Port Drop Down
    And Select the Stateroom from StateRoom Drop Down
    And Select the No of Guests from  Guests Drop Down
    And Select A Month From the Calender
    And Click on View Results Button		
    And Click on 'Refine Search' Button
    And Select the Destination from Destination DropDown
    And Select the Departure from Departure Drop Down 
    And Select the Length of Cruise from Length Cruise Drop Down
    And Select Ship from Ship DropDown
    And Select the Itinerary Port from Itinerary Port Drop Down
    And Select the Stateroom from StateRoom Drop Down
    And Select the No of Guests from  Guests Drop Down
    And Select A Month From the Calender	
   Then verify the presence of View Results button and Click on View Results Button	
  		
     
Scenario: Refine Search will refine the original search results - Cruisetour					
  Given Click on Plan A Cruise
   When Click on Search Cruisetours Tab 
    And Select the Destination from Destination DropDown
    And Select the Departure from Departure Drop Down 
    And Select the Length of Cruise from Length Cruise Drop Down
    And Select the Length of Cruisetour from Length Cruisetour Drop Down
    And Click on Show More Otions
    And Select Travel Sequence from Travel Sequence dropdown
    And Select Cruisetour Category from Cruisetour Categories dropdown
    And Select Ship from Ship DropDown in Cruisetours Tab 
    And Select the Itinerary Port from Itinerary Port Drop Down
    And Select the Stateroom from StateRoom Drop Down
    And Select the No of Guests from  Guests Drop Down
    And Select A Month From the Calender
    And Click on View Results Button		
    And Click on 'Refine Search' Button	
    And Select the Destination from Destination DropDown
    And Select the Departure from Departure Drop Down 
    And Select the Length of Cruise from Length Cruise Drop Down
    And Select the Length of Cruisetour from Length Cruisetour Drop Down
    And Select Travel Sequence from Travel Sequence dropdown
    And Select Cruisetour Category from Cruisetour Categories dropdown
    And Select Ship from Ship DropDown in Cruisetours Tab 
    And Select the Itinerary Port from Itinerary Port Drop Down
    And Select the Stateroom from StateRoom Drop Down
    And Select the No of Guests from  Guests Drop Down
    And Select A Month From the Calender
   Then verify the presence of View Results button and Click on View Results Button	
   