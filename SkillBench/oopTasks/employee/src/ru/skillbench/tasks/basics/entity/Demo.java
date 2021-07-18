package ru.skillbench.tasks.basics.entity;

public class Demo {
    public static void main(String[] args) {
        EmployeeImpl p1 = new EmployeeImpl();
        p1.setFirstName("Sergey");
        p1.setLastName("Efimov");
        System.out.println(p1.getSalary());
        System.out.println(p1.getManagerName());
        System.out.println(p1.getFullName());
        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());
        EmployeeImpl p2 = new EmployeeImpl();
        p2.setFirstName("Ilya");
        p2.setLastName("Kozlov");
        p1.setManager(p2);
        EmployeeImpl p3 = new EmployeeImpl();
        p3.setFirstName("Kirill");
        p3.setLastName("Gonov");
        p2.setManager(p3);
        Employee pTop = p1.getTopManager();
        System.out.println(pTop.getFullName());
    }
}
