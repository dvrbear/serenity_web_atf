Feature: SHOP ORDER VERIFICATION

  Scenario Outline: A guest orders a new phone without shipping
    Given a Guest opens the shop page
    When he navigates to the phone selection
    And he selects the specific phone model: <phoneModel>
    And he proceed buying
    And he chooses the shipping method: get from store
    And he chooses store location
    And he proceed ordering
    And he enters personal information
    Then he ensures that order is succeeded
    Then debug step
    Examples:
      | phoneModel                 |
      | Samsung Galaxy A23 6/128GB |
      | p1                         |
      | p2                         |

