Feature: Plan a Cruise
Scenario: Search Cruises
	Given the user is on the home page
	When the user clicks on 'Plan a Cruise' link
	And is redirected to the 'Find your perfect Cruise vacation' page
	And fills all the details on 'Find your perfect Cruise vacation' page
	And clicks on 'View Results' button
	Then the user is redirected to search result page
	And available tours are displayed