package ru.ncedu.zigal0.persondate;

public class Demo {
    public static void main(String[] args) {
        String separator = "**************************************************";
        Person p1 = new Person();
        try {
            p1.parseInfo("Sergey Evgenievich Efimov 30.11.1999");
        } catch (NoSuchFieldException e) {
            System.out.println("Wrong date Format.");
        }
        System.out.println(p1.getDifferentFormatDate(Person.DateFormat.shortFormat));
        System.out.println(p1.getDifferentFormatDate(Person.DateFormat.mediumFormat));
        System.out.println(p1.getDifferentFormatDate(Person.DateFormat.fullFormat));
        System.out.println(p1);
        System.out.println(separator);

        try {
            Person p2 = new Person("Sergey Evgenievich Efimov 30/11.1999");
        } catch (NoSuchFieldException e) {
            System.out.println("Wrong info format");
        }
    }
}
