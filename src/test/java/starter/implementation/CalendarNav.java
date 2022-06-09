package starter.implementation;

import starter.utils.Const;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarNav extends BasePageObject {

    public void clickNextWeek(String month, String dayOfMonth) {
        if (!lessThanTwoWeeks(month, dayOfMonth)) {
            failWithMessage("You cannot book place in more than 14 days");
        }
        sleep(1);
        String date = month + " " + dayOfMonth;
        for (int i = 0; i < checkWhatWeek(month, dayOfMonth); i++) {
            click("//div[@class='icon next']");
        }
        click(String.format(Const.DATE_PATERRN, date));
    }

    public void checkWhatMonth(String month, String dayOfMonth) {
        if (!lessThanTwoWeeks(month, dayOfMonth)) {
            failWithMessage("You cannot book place in more than 14 days");
        }
        sleep(1);
        String date = month + " " + dayOfMonth;
        Date todaysDate = new Date();
        boolean checkIfNextMoth = theMonth(todaysDate.getMonth()).equals(month);
        if (!checkIfNextMoth) {
            click("//*[@id='booking']/div[3]/div[3]/div[2]/div/div[1]/span[2]");
        }
        click(String.format(Const.DATE_PATERRN, date));
    }


    private static boolean lessThanTwoWeeks(String month, String dayOfMonth) {
        try {
            Date currentDate = new Date();
            Date givenDate = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(month);
            Calendar currentCalendar = Calendar.getInstance();
            Calendar calendar = Calendar.getInstance();
            currentCalendar.setTime(currentDate);
            calendar.setTime(givenDate);
            LocalDate dateBefore = LocalDate.of(currentCalendar.get(Calendar.YEAR), currentCalendar.get(Calendar.MONTH) + 1, currentCalendar.get(Calendar.DAY_OF_MONTH));
            LocalDate dateAfter = LocalDate.of(currentCalendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, Integer.parseInt(dayOfMonth));
            long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
            return noOfDaysBetween <= 14;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    private static int checkWhatWeek(String month, String dayOfMonth) {
        try {
            Date currentDate = new Date();
            Date givenDate = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            LocalDate date = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(java.util.Calendar.DAY_OF_MONTH));
            int weekOfYear = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
            LocalDate dateRequested = LocalDate.of(calendar.get(Calendar.YEAR), givenDate.getMonth() + 1, Integer.parseInt(dayOfMonth));
            int requestedWeek = dateRequested.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
            return requestedWeek - weekOfYear;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }


    private static String theMonth(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}
