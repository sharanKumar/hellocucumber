Feature: selenium examples

  Scenario: open a url and login
    When I enter my email id
    Then I should subscribe


  Scenario: find list of elements
    When I Scroll down to the bottom
    And I click on Element 1
    Then I should see element 1 webpage