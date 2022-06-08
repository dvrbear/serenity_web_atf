package starter.definition;

import io.cucumber.java.en.When;
import starter.implementation.CalendarNav;

import java.text.ParseException;

import static starter.utils.ConstXpath.SWITCH_BTN_XPATH;

public class CalendarDef  {

    private CalendarNav calendar;

    @When("selects date : {} {}")
    public void selectDate(String month, String dayOfMonth){
        calendar.click(SWITCH_BTN_XPATH);
        calendar.clickNextWeek(month,dayOfMonth);
//        calendar.checkWhatMonth(month,dayOfMonth);
    }

    @When("selects place by hours: from {} to {}")
    public void selectHours(String startHour, String endHour){
        calendar.timeDrag(startHour, endHour);
    }
}
