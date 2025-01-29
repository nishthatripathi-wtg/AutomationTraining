@debug
Feature: Department flows
  Background:
    Given I open bootcamp website
    And I navigate to "Departments" tab

  Scenario: Create Department
    When I click on "Create"
    And I fill the department form details
    | name | readOnly | mandatory |
    | HR   | false    | false     |
    And I click on "Save"
    Then  I verify the department details
    And I verify the icons

    Scenario: Edit Department
      When I click on "Edit" for last department
      And I fill the department form details
        | name | readOnly | mandatory |
        | HR-1   | false    | false   |
      And I click on "Save"
      Then I verify the department details
      And I verify the icons

  # Automation Browser is not able to open dialog box
  #Scenario: Delete Department
   # When I click on "Delete" for last department
   Then I "accept" the dialog box
    #And I verify the last department is deleted
