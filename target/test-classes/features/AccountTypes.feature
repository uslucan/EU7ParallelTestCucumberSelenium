Feature: Account Types

  Scenario: Driver manager user
    Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"

  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates to "Customers" "Accounts"
    Then the title contains "Accounts - Customers"
  @wip @smoke
  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates to "Customers" "Contacts"
    Then the title contains "Contacts - Customers"

#  Scenario: Driver user
 #   Given the user logged in as "driver"

  #Scenario: Sales manager user
   # Given the user logged in as "sales manager "

#  Scenario: Store manager user
 #   Given the user logged in as "store manager"

  Scenario Outline: Login with different "<userType>"
    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType      | tab        | module          | title                        |
      | store manager | Customers  | Contacts        | Contacts - Customers         |
      | driver        | Activities | Calendar Events | Calendar Events - Activities |
      | sales manager | Customers  | Accounts        | Accounts - Customers         |
