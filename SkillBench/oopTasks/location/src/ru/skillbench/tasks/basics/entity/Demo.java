package ru.skillbench.tasks.basics.entity;

public class Demo {
    public static void main(String[] args) {

        Location l1 = new LocationImpl();
        l1.setName("159");
        l1.setType(Location.Type.APARTMENT);

        Location l2 = new LocationImpl();
        l2.setName("23");
        l2.setType(Location.Type.BUILDING);

        Location l3 = new LocationImpl();
        l3.setName("Саянская");
        l3.setType(Location.Type.STREET);

        Location l4 = new LocationImpl();
        l4.setName("Третий");
        l4.setType(Location.Type.DISTRICT);

        Location l5 = new LocationImpl();
        l5.setName("Железногорск");
        l5.setType(Location.Type.CITY);

        Location l6 = new LocationImpl();
        l6.setName("Ленинградская");
        l6.setType(Location.Type.REGION);

        Location l7 = new LocationImpl();
        l7.setName("Россия");
        l7.setType(Location.Type.COUNTRY);

        l1.setParent(l2);
        l2.setParent(l3);
        l3.setParent(l4);
        l4.setParent(l5);
        l5.setParent(l6);
        l6.setParent(l7);

        // test
        System.out.println(l1.getName());
        System.out.println(l1.getParentName());
        System.out.println(l1.getType());
        System.out.println(l1.getAddress());
        System.out.println(l1);
        System.out.println(l1.isCorrect());
        Location res = l1.getTopLocation();
        System.out.println(res.toString());
    }
}
