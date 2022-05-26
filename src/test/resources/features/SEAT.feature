@Seat
Feature: SEAT Test

  Scenario: Select place
    Given opens main page
    Then introduce username and pass
    And press login button
    And inserts token
    And sign in seat
    And go to booking
    And open workplaces
    And select ZTower
    And select Kitchen
    And select first free place
    And submit booking
    And cancel booking
#    And select date
#    And select place K7.65
#    And select place K7.69

    Then debug step
