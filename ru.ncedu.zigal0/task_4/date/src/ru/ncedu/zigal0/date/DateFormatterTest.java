package ru.ncedu.zigal0.date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing DateFormatter methods.
 *
 * @author zigal0
 */
public class DateFormatterTest {

    @Rule
    public TestRule globalTimeout = new DisableOnDebug(Timeout.seconds(1));

    private final Calendar trueForCalendar = new GregorianCalendar(1999, Calendar.NOVEMBER, 30, 16, 30);
    private Date trueForDate = new Date();
    private Date dateForTest = new Date();
    private Calendar calendarForTest = Calendar.getInstance();


    @Before
    public void setDate() {
        trueForDate = trueForCalendar.getTime();
    }

    @Test
    public void toDateDefault() {
        try {
            dateForTest = DateFormatter.toDate("1999-11-30 16:30");
        } catch (ParseException e) {
            System.out.println("Wrong");
        }
        assertEquals(trueForDate, dateForTest);
    }

    @Test
    public void toCalendarDefault() {
        try {
            calendarForTest = DateFormatter.toCalendar("1999-11-30 16:30");
        } catch (ParseException e) {
            System.out.println("Wrong");
        }
        assertEquals(calendarForTest, trueForCalendar);
    }

    @Test(expected = ParseException.class)
    public void toDateWithException() throws ParseException{
        dateForTest = DateFormatter.toDate("1999-11/30 16:30");
    }

    @Test(expected = ParseException.class)
    public void toCalendarWithException() throws ParseException{
        calendarForTest = DateFormatter.toCalendar("1999;11-30 16:30");
    }
}