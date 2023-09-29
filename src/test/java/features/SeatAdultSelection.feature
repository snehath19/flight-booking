
Feature: Seat booking and adults selection

  Background:
    Given I am on "https://www.opodo.co.uk/" page and Check the url is correct or not
    When select source as "LHR", destination as "FRA" and travel date
    Then show available flights

   Scenario: Goto flight details page when a flight is selected
   Given user select a flight
   Then check if the user is on the flight details page

    Scenario: Check if the number of passengers increased
    Given display number of passengers before count is increased
    When user clicks on Add another adult button in the page
    Then show the updated number of adults
    Then check if the number of passengers got increased

  @smoke @regression
  Scenario: Check the working of seat selection
    Given check the number of seats available
    Then check if seat size is zero then display no seat available
    Then check if adult number is one then try to add single seat
    Then check if adult number is two then try to add two seats
    Then check if selected seat is window or aisle

  Scenario Outline: Enter the adult details
    Given User is on flight details pages
    When  User tries to enter the adult details "<Name>" and "<Surname>"
    Examples:
      |Name  |Surname|
      |Anu   |Joseph|

  Scenario: Enter the contact details
    Given User is on flight details page
    When  User tries to enter the contact details
      | ss@gmail.com   |
      | ss@gmail.com   |
      | 6756453456     |
      | London         |
      | un7rt6         |
      | Milan          |