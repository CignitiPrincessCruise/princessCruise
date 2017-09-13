#Author: nikhil.bharati@cigniti.com
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
#Sample Feature Definition Template
@SignUp 
Feature: Sign up for special offers 
In order to test the Sign up feature,
user tries different comination of available fields and varifies if the feature is working correctly or not.

  Background: 
    Given a user navigates to set location page 
      And leaves everything as default and click on Submit 
      And user clicks on Princess Cruices logo at the header 
  
  Scenario:	a user tries to sign up without filling out the sign up form -SignUP#001 
    Given user is on the the main home page 
     When the user clicks on the 'Sign up for special offers' on the header 
     Then a light box window should appear on the browser 
      And when the user clicks on the 'Send me Offers' button, error message will be displayed at the top. 
  
  Scenario:  a user enters invalid first and last name and tries to sign up - SignUP#002 
    Given user is on the the main home page 
     When the user clicks on the 'Sign up for special offers' on the header 
     Then a light box window should appear on the browser 
      And when the users enters wrong first name, last name with other details proper error should be displayed for first and last name 
      And when the user clicks on the 'Send me Offers' button, error message will be displayed at the top. 
  
  Scenario:  a user enters invalid email and tries to sign up - SignUP#003 
    Given user is on the the main home page 
     When the user clicks on the 'Sign up for special offers' on the header 
     Then a light box window should appear on the browser 
      And when the users enters first name, last name, wrong email with other details proper error should be displayed for email 
      And when the user clicks on the 'Send me Offers' button, error message will be displayed at the top. 
      
  Scenario: a user tries to sign up correctly- SignUP#004 
    Given user is on the the main home page 
     When the user clicks on the 'Sign up for special offers' on the header 
     Then a light box window should appear on the browser 
      And when the users enters first name, last name, email with all other correct details 
      And when the user clicks on the 'Send me Offers' button, user is redirected to 'Register with Princess Cruise' page. 
  
  
  
  
