Feature: selenium examples

  Scenario: find list of elements
    When I Scroll down to the bottom
    And I click on Element 1
    Then I should see element 1 webpage

  #Scenario: Different Relative xpath
    #Simple xpath - //tag[@attribute='value']
    #Indexes - (//div[@id="nav-xshop"])/a[3]
    #following - //div[@id='nav-xshop']//following::a/span
    #following-sibling - //a[@data-csa-c-content-id="nav_cs_buy_again"]//following-sibling::a[2]
    #  preceding        - //a[@data-csa-c-content-id="nav_cs_buy_again"]//preceding::a[1]
    # preceding-sibling - //a[@data-csa-c-content-id="nav_cs_buy_again"]//preceding-sibling::a[1]
    # child - //div[@id="nav-xshop"]//child::script[2]
    # parent - //div[@id="nav-xshop"]//parent::div
    # ancestor - //div[@id="nav-xshop"]//ancestor::div
    # descendent - //div[@id="nav-xshop"]//descendant::a
