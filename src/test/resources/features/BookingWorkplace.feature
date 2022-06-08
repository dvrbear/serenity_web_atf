@Seat
Feature: Booking workplace

  Scenario: Book and Cancel workplace
    Given opens main page
    When introduce username and pass
    And inserts OTP
    And navigate to office : Ztower_1
    And selects date : June 22
    And selects place by hours: from 08:00 to 18:00


#    And go to booking
#    And open workplaces
#    And select ZTower
#    And select Kitchen

#    And select first free place
#    And submit booking
#    And cancel booking
#    And select date
#    And select place K7.65
#    And select place K7.69

    Then debug step
