package ru.ncedu.zigal0.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class DateFormatter represents abstract class, which help parse date to Date class or to Calendar class.
 *
 * @author zigal0
 */
public abstract class DateFormatter {
    /**
     * Parses string to Date.
     *
     * @param stringDate - String date in the correct format "y-M-d H:m"
     * @return Date - parsed date.
     * @throws ParseException if format is wrong.
     */
    public static Date toDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("y-M-d H:m").parse(stringDate);
    }

    /**
     * Parses string to Calendar.
     *
     * @param stringDate - String date in the correct format "y-M-d H:m"
     * @return Calendar - parsed date.
     * @throws ParseException if format is wrong.
     */
    public static Calendar toCalendar(String stringDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");
        calendar.setTime(sdf.parse(stringDate));
        return calendar;
    }
}
