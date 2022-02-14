@navMenu
Feature: Navigation menu

  Scenario: Navigating Fleet--Vehicles
    Given the user is on the login page
    And the user enters the salesmanager information
    When the user clicks on Fleets,Vehicles
    Then the title should be Vehicles
@db
  Scenario: Navigating Marketing--Campaigns
    Given the user is on the login page
    And the user enters the salesmanager information
    When the user clicks on Marketing,Campaigns
    Then the title should be Campaigns

  Scenario: Navigating Activities--Calendar
    Given the user is on the login page
    And the user enters the salesmanager information
    When the user clicks on Activitie,Calendar
    Then the title should be Calendar




