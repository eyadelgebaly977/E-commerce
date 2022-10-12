@smoke
Feature: Search Feature
  Scenario Outline: search using product name
    When  user click on search field
    And user search with "<product name>"
    Then user could find "<product name>"


    Examples:
      | product name |
      | book         |
      | laptop       |
      | nike         |


  Scenario Outline: search using product sku
    When  user click on search field
    And user search with "<sku>"
    Then user could find "<sku>" in product details


    Examples:
      | sku          |
      | SCI_FAITH    |
      | APPLE_CAM    |
      |  SF_PRO_11   |
