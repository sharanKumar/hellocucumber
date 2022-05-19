Feature: MongoDB examples

  @db
  Scenario: Mongodb insert
    Given I add data to db

  @db
  Scenario: Mongodb update
    Given I update data in the db

  @db
  Scenario: Mongodb get
    Given I get data from db

    @db
  Scenario: Mongodb delete
    Given I delete data from db
