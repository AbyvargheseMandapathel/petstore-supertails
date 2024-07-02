Feature: Visiting Henlo Products on supertails

  Scenario: Visiting the Henlo Products Page
    Given I am on the homepage of supertails
    When I click on the  link henlo
    Then I should be on the Henlo Products page
    And The  displayed products should be the henlo products

