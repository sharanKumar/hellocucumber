Feature: selenium examples

  Scenario: open a url and login
    Given I open sample selenium website in "Chrome"
    When I enter my email id
    Then I should subscribe
    And I should close
