Feature: Flight filters checking

  Background:
    Given I am on "https://www.opodo.co.uk/" page and Check the url is correct or not
    When select source as "LHR", destination as "FRA" and travel date
    Then show available flights

  Scenario: Check for cheapest flights
    Given User is shown prices before applying any sort
    When User click on cheapest flights button
    Then show prices after the sort
    Then check if the results are sorted based on cheapest price

  @smoke
  Scenario: Check for fastest flights
    Given User is shown list of flight hours
    When User click on fastest flights button
    Then show flight duration of fastest flights in sort order

  Scenario: Check the working of stops(layover) filter
    Given User is shown the list of flight stops
    When User click on the no stops filter check box
    Then show the list of stops of all flights
    Then check if only direct flights are shown