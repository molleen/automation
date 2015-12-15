Feature: Add a new item
  In order to buy a item
  As a store customer
  I want to add a new item to the catalog

  Scenario: Add a dog
    Given I have the following item
    | name | status    |
    | Fido | available |
    When I add the item to the cart
    Then the item should be available in the cart
