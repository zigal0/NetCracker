package ru.ncedu.zigal0.address;

import java.util.Calendar;

/**
 * Class Human represents abstraction human for data base. There are several facts about human such as first name, second Name, birth date.
 */
public class Human {
    private String firstName;
    private String secondName;
    private Calendar birthDate = Calendar.getInstance();

    public Human(String info) {
        parseInfo(info);
    }

    public String toOutput() {
        int month = birthDate.get(Calendar.MONTH) + 1;
        return secondName + " " + firstName + " " + birthDate.get(Calendar.DATE) + "."
                + month + "." + birthDate.get(Calendar.YEAR);
    }

    public void parseInfo(String info) {
        String delimiter = " ";
        String[] subInfo = info.split(delimiter);
        secondName = subInfo[0];
        firstName = subInfo[1];
        birthDate = DateParser.parseDate(subInfo[2], "\\.");
    }

    public String getSecondName() {
        return secondName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }
}

