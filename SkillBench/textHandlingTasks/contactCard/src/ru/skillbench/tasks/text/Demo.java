package ru.skillbench.tasks.text;

import java.time.Period;
import java.util.Calendar;

public class Demo {
    public static void main(String[] args) {
        ContactCard contactCard = new ContactCardImpl();
        contactCard.getInstance(
                "BEGIN:VCARD\r\n" +
                        "FN:Efimov Sergey\r\n" +
                        "ORG:NetCracker\r\n" +
                        "GENDER:M\r\n" +
                        "BDAY:30-11-1999\r\n" +
                        "TEL;TYPE=WORK:4951234567\r\n" +
                        "TEL;TYPE=HOME:9150123456\r\n" +
                        "END:VCARD");
        System.out.println(contactCard.getFullName());
        System.out.println(contactCard.getOrganization());
        System.out.println(contactCard.getBirthday().getTime());
        System.out.println(contactCard.isWoman());
        System.out.println(contactCard.getAgeYears());
        System.out.println(contactCard.getPhone("WORK"));
        System.out.println(contactCard.getPhone("HOME"));
        Calendar birthDay = contactCard.getBirthday();
        Period period = contactCard.getAge();
        System.out.println(birthDay.getTime());
        System.out.println("Passed after birth day: " + period.getYears() + " years, "
                + period.getMonths() + " months, " + period.getDays() + " days.");
    }
}
