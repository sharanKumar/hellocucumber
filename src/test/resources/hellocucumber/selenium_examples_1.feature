Feature: selenium examples

  Scenario: open a url and login
    When I enter my email id
    Then I should subscribe


  Scenario: test window handles
    When I click on the New window button
    Then I should see a new window
    And I come back to main window

