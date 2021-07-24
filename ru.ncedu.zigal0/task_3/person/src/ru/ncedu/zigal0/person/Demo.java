package ru.ncedu.zigal0.person;

public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Sergey", "Evgenievich", "Efimov");
        p1.setFirstName("Gregory");
        System.out.println(p1.getFullName());
        System.out.println(p2.getFullName());
    }
}
