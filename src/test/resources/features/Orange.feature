@Orange
Feature: ORANGE SITE

  Scenario Outline: A guest orders a new phone without shipping
    Given opens Orange
    When navigates to the phone selection
    And selects the specific phone model: <phoneModel>
    And proceed buying
    Then debug step
    Examples:
      | phoneModel     |
      | Huawei Nova 8i |
