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

Feature: Stateroom Room and Dinning Page

Background:    
   Given Launch Princess Cruises	
      
Scenario: Stateroom & Dinning - Dining Selection
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
     And Click on Cruise Detail Button
     And Click on Select Stateroom 
     And Select Number Of Guests
     And Select Stateroom Type and Location
     And Select Zone Location
     And Select Deck and Stateroom
     And Select a Cabin
    Then Check if user is able to Select Bed Configuration
    When Select Any Time Dining Button
     And Select Traditional Dining Button
     And Select Dining Time
     And Select Dining Table Size
     And Close the Dinning and stateroom page
     And Select other Stateroom
    Then Check if user is able to Select Club class dinning option

Scenario:  Dining & Stateroom - Bed Configuration(Queen)
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
     And Click on Cruise Detail Button
     And Click on Stateroom Type tab 
     And Select Stateroom
     And Select Number Of Guests
     And Select Stateroom Type and Location
     And Select Zone Location
     And Select Deck and Stateroom
     And Select a Cabin
    Then Check if user is able to Select Bed Configuration
     
Scenario: Dining & Stateroom - Bed Configuration(twins)
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
     And Click on Cruise Detail Button
     And Click on Stateroom Type tab 
     And Select Stateroom
     And Select Number Of Guests
     And Select Stateroom Type and Location
     And Select Zone Location
     And Select Deck and Stateroom
     And Select a Cabin
    Then Check if user is able to select Bed Configuration twins
     
   
#Scenario: Booking flow through ADA  Check Box
		#When Select the Destination from Destination DropDown 
    #When Click on the View results button
    #And Click on the Cruise Details button after new search  
    #And Click on Select Stateroom
    #Then Select the 'I require an accessible statroom' Check Box
     #And Select Number Of Guests
     #And Select Stateroom Type and Location
     #And Select Zone Location
     #And Select Deck and Stateroom
     #And Select a Cabin
     #And Click 'Accept Terms & Continue' button

#Scenario: Booking flow through ADA  Check Box
	 #When Select the Destination from Destination DropDown 
   #When Click on the View results button
    #And Click on the Cruise Details button after new search  
    #And Click on Select Stateroom
   #Then Select the 'I require an accessible statroom' Check Box
    #And Select Number Of Guests
    #And Select Stateroom Type and Location
    #And Select Zone Location
    #And Select Deck and Stateroom
    #And Select a Cabin
	  #And Click 'Decline' button	
