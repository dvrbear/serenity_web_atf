@Seat
Feature: SEAT Test

  Scenario: Select place
    Given opens main page
    When introduce username and pass
    And inserts OTP
    And go to booking
    And open workplaces
    And select ZTower
    And select Kitchen
    And select date June  13
    And select first free place
    And submit booking
    And cancel booking

#    And select place K7.65
#    And select place K7.69

    Then debug step
