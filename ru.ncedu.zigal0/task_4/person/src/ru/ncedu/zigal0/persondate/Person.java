package ru.ncedu.zigal0.persondate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Calendar birthDate;

    enum DateFormat {
        shortFormat,
        mediumFormat,
        fullFormat
    }

    public Person(String stringInfo) {
        parseInfo(stringInfo);
    }

    public void parseInfo(String info) {
        String delimiter = " ";
        String[] subInfo = info.split(delimiter);
        firstName = subInfo[0];
        middleName = subInfo[1];
        lastName = subInfo[2];
        birthDate = DateParser.parseDate(subInfo[3], "\\.");
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " " + getDifferentFormatDate(DateFormat.shortFormat);
    }

    public String getDifferentFormatDate(DateFormat format) {
        StringBuilder result = new StringBuilder();
        result.append(birthDate.get(Calendar.DAY_OF_MONTH)).append("-");
        if (format == DateFormat.shortFormat) {
            result.append(new SimpleDateFormat("MM").format(birthDate.get(Calendar.MONTH)));
        }
        if (format == DateFormat.mediumFormat) {
            result.append(new SimpleDateFormat("MMM").format(birthDate.get(Calendar.MONTH)));
        }
        if (format == DateFormat.fullFormat) {
            result.append(new SimpleDateFormat("MMMM").format(birthDate.get(Calendar.MONTH)));
        }
        result.append("-").append(birthDate.get(Calendar.YEAR));
        return result.toString();
    }
}



