package ru.ncedu.zigal0.persondate;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class DateParser represents abstract class, which help parse date if format "day-month-year" where - is delimiter.
 */
public abstract class DateParser {
    public static Calendar parseDate(String date, String delimiter) {
        String[] subDate = date.split(delimiter);
        return new GregorianCalendar(Integer.parseInt(subDate[2]), Integer.parseInt(subDate[1]) - 1, Integer.parseInt(subDate[0]));
    }
}
