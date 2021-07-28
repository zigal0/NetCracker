package ru.ncedu.zigal0.persondate;

public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person("Sergey Evgenievich Efimov 30.11.1999");
        System.out.println(p1.getDifferentFormatDate(Person.DateFormat.shortFormat));
        System.out.println(p1.getDifferentFormatDate(Person.DateFormat.mediumFormat));
        System.out.println(p1.getDifferentFormatDate(Person.DateFormat.fullFormat));
        System.out.println(p1);
    }
}
