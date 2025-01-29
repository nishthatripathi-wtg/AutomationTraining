@debug
Feature: Navbar
  Scenario: Navbar items
    Given I open bootcamp website
    Then I verify the Menu items
    | BootcampUI |
    | Employees  |
    | Departments|
    And I verify Menu "Employee" is selected