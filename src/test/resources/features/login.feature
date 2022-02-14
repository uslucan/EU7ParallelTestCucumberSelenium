@login @smoke
Feature: User should be able to login

  Background:
    Given the user is on the login page

@driver @VYT-123
  Scenario: Login as a driver
    When the user enters the driver information
    Then the user should be able to login

@salesmanager @VYT-123
  Scenario: Login as a salesmanager
    When the user enters the salesmanager information
    Then the user should be able to login

  @storemanager @smoke
  Scenario: Login as a storemanager
    When the user enters the storemanager information
    Then the user should be able to login



