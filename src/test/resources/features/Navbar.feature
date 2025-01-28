@debug
Feature: Navbar flows
  Scenario: Navigate to bootcamp website, click on Menu item and verify the results.
    Given I open bootcamp website
    Then I verify the text "BootcampUI"
    And I verify Menu "Employee" is selected
    And I verify the Menu items
    | Employees  |
    | Departments|