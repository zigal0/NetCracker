package ru.ncedu.zigal0.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Own class for testing DateFormatter methods.
 *
 * @author zigal0
 */
public class MyTest {
    private final Calendar trueForCalendar = new GregorianCalendar(1999, Calendar.NOVEMBER, 30, 16, 30);
    private Date trueForDate = new Date();
    private Date dateForTest = new Date();
    private Calendar calendarForTest = Calendar.getInstance();

    public boolean testRunner() {
        trueForDate = trueForCalendar.getTime();
        boolean check;
        check = toDateDefault();
        check &= toCalendarDefault();
        check &= toCalendarWithException();
        check &= toDateWithException();
        return check;
    }

    public boolean toCalendarDefault() {
        try {
            calendarForTest = DateFormatter.toCalendar("1999-11-30 16:30");
        } catch (ParseException e) {
            System.out.println("Wrong");
        }
        return trueForCalendar.equals(calendarForTest);
    }

    public boolean toDateDefault() {
        try {
            dateForTest = DateFormatter.toDate("1999-11-30 16:30");
        } catch (ParseException e) {
            System.out.println("Wrong");
        }
        return dateForTest.equals(trueForDate);
    }

    public boolean toDateWithException() {
        try{
            dateForTest = DateFormatter.toDate("1999-11/30 16:30");
        } catch (ParseException e) {
            return true;
        }
        return false;
    }

    public boolean toCalendarWithException() {
        try{
            calendarForTest = DateFormatter.toCalendar("1999-11.30 16:30");
        } catch (ParseException e) {
            return true;
        }
        return false;
    }
}
