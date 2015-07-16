Feature: Sample google search

  Scenario: Search for car
    Given User opens "http://www.google.com"
    When User searches for "car" on "lst-ib"
    Then "srfl" should contain "car"
