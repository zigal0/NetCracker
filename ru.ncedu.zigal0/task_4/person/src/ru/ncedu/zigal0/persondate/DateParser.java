package ru.ncedu.zigal0.persondate;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class DateParser represents abstract class, which help parse date if format "y-M-d" where - is delimiter.
 */
public abstract class DateParser {
    public static Calendar parseDate(String date, String delimiter) throws NoSuchFieldException {
        String[] subDate = date.split(delimiter);
        if (subDate.length != 3 || !isInteger(subDate[0]) || !isInteger(subDate[1]) || !isInteger(subDate[2])) {
            throw new NoSuchFieldException();
        }
        return new GregorianCalendar(Integer.parseInt(subDate[2]), Integer.parseInt(subDate[1]) - 1, Integer.parseInt(subDate[0]));
    }

    /**
     * Checks whether the String a valid Java integer.
     * @param str - the String to check
     * @return true if the string is a correctly formatted int
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
