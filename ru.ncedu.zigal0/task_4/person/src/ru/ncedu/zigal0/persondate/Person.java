package ru.ncedu.zigal0.persondate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class Person represents basic info such as full name and birthdate about one person.
 *
 * @author zigal0
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Calendar birthDate;

    /**
     * Special enum for different formats when displaying dates.
     */
    enum DateFormat {
        shortFormat,
        mediumFormat,
        fullFormat
    }

    /**
     * Default constructor for Class Person without params.
     */
    public Person() {
    }

    /**
     * Construct for Class Person with param - info.
     *
     * @param stringInfo - info about person in the correct format: "firstName middleName lastName day.month.year".
     * @throws NoSuchFieldException - from parsInfo method.
     */
    public Person(String stringInfo) throws NoSuchFieldException {
        parseInfo(stringInfo);
    }

    /**
     * Parses info about person.
     *
     * @param info - info about person in the correct format: "firstName middleName lastName day.month.year".
     * @throws NoSuchFieldException if wrong info format.
     */
    public void parseInfo(String info) throws NoSuchFieldException {
        String delimiter = " ";
        String[] subInfo = info.split(delimiter);
        if (subInfo.length != 4) {
            throw new NoSuchFieldException();
        }
        firstName = subInfo[0];
        middleName = subInfo[1];
        lastName = subInfo[2];
        birthDate = DateParser.parseDate(subInfo[3], "\\.");
    }

    /**
     * Converts all info about person into String.
     *
     * @return String - full info.
     */
    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " " + getDifferentFormatDate(DateFormat.shortFormat);
    }

    /**
     * Returns the date in different formats depending on the param format.
     *
     * @param format - DateFormat constant that defines output.
     * @return String - date.
     */
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



