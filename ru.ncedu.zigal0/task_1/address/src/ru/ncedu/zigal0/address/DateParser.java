package ru.ncedu.zigal0.address;

import java.util.Calendar;

/**
 * Class DateParser represents abstract class, which help parse date if format "day-month-year" where - is delimiter.
 */
public abstract class DateParser {
    public static Calendar parseDate(String date, String delimiter) {
        String[] subDate = date.split(delimiter);
        Calendar formatDate = Calendar.getInstance();
        formatDate.set(Integer.parseInt(subDate[2]), Integer.parseInt(subDate[1]) - 1, Integer.parseInt(subDate[0]));
        return formatDate;
    }
}
