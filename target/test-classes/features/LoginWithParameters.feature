Feature: Login as different users

  Scenario: login as a driver user
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    Then the user should be able to login
    And the title contains "Dashboard"


  Scenario: login as a driver
    Given the user logged in as "store manager"
    Then the user should be able to login
    And the title contains "Dashboard"


  Scenario Outline: Login as a given user --> <username>
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <username>  |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login
    Examples:
      | username       | firstName | lastName |
      | user10         | John      | Doe      |
      | storemanager85 | John      | Doe      |

