Feature: Login Functionality
  As a user of the Event Planner System
  I want to be able to log in to the system
  So that I can access my personalized user area

  
Scenario: Successful Login with Valid Credentials
    Given I am on the login page
    When I enter valid "username" and "password"
    And I click on the login button
    Then I should be logged in successfully
    And I should be redirected to my user dashboard
  
Scenario: Unsuccessful Login with Invalid Username
    Given I am on the login page
    When I enter an invalid "username" and a valid "password"
    And I click on the login button
    Then I should see an error message "Invalid user name or password"
  
Scenario: Unsuccessful Login with Invalid Password
    Given I am on the login page
    When I enter a valid "username" and an invalid "password"
    And I click on the login button
    Then I should see an error message "Invalid user name or password"

Scenario: Unsuccessful Login with Invalid Username and Password
    Given I am on the login page
    When I enter an invalid "username" and "password"
    And I click on the login button
    Then I should see an error message "Invalid user name or password"

  Scenario: Unsuccessful Login with Unrecognized User Type
    Given I am on the login page
    When I enter "username" and "password" corresponding to an unrecognized user type
    And I click on the login button
    Then I should see an error message "Invalid user name password and type"

  Scenario: Successful Login with User Type Recognition
    Given I am on the login page
    When I enter valid credentials for a recognized user type
    And I click on the login button
    Then I should be logged in successfully
    And my user type should be recognized and displayed on the dashboard

  Scenario: Error Handling for SQL Exceptions during Login
    Given I am on the login page
    When I perform an action that triggers an SQL exception during login
    And I click on the login button
    Then I should see an appropriate error message for the SQL issue
