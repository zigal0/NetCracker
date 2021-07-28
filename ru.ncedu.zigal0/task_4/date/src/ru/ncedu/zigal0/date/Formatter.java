package ru.ncedu.zigal0.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Formatter {
    public static Date toDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("y-M-d H:m").parse(stringDate);
    }

    public static Calendar toCalendar(String stringDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");
        calendar.setTime(sdf.parse(stringDate));
        return calendar;
    }
}
