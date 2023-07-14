#Author: Shashank Shrivastava
#Date: 14.Jul.2023
#Description: To validate user is successfully registered and able to Login
Feature: Feature to Test Signup/Login t Flow

  Scenario: Validate User Signup is successful with valid credentials
    Given user is on application url
    And user click on Login and lands on login screen
    And user clicks on Create Account tab
    When user enters name, email address and password
    And clicks on create account button
    
  Scenario: Validate User is sucessfully able to login with valid credentials
  	Given user click on profile icon and navigate to profile page
  	And user clicks on signout
  	When user click on Login
    And user enters email address and password
    And clicks on login button
    Then user is navigated to home page  
