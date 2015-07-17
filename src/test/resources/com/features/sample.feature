Feature: Sample google search

  Scenario: Search for car
    Given User opens "http://www.google.com"
    When User searches for "car" on "lst-ib"
    Then "lst-ib" should contain "car"

  Scenario: Failure is an option
    Given User opens "http://www.google.com"
    When User searches for "car" on "lst-ib"
    Then "lst-ib" should contain "Automata"
