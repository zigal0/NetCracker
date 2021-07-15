package ru.ncedu.zigal0.address;

import java.util.*;

/**
 * Class DataBase represents simple implementation of data base. It is built on HashMap and stores pairs: Address (key) - Human (value).
 */
public class DataBase {

    private final HashMap<Address, Human> list = new HashMap<>();

    public DataBase() {
        this.installDefault();
    }

    /**
     * Fills new data base with default Humans.
     */
    private void installDefault() {
        this.addNew("Efimov Sergey 30.11.1999", "SunBase 23 159");
        this.addNew("Sedelnikova Nastya 24.07.1998", "MoonBase 68 79");
        this.addNew("Lukakhin Mikhail 10.2.2000", "SunBase 1 30");
        this.addNew("Kazakov Gregory 30.6.2005", "WaterBase 42 258");
        this.addNew("Adamova Alisa 5.3.1997", "FireBase 69 420");
    }

    /**
     * Adds new Human to data base.
     * @param info - String with correct format of info about Human otherwise exception
     * @param address - String with correct format of address otherwise exception
     */
    public void addNew(String info, String address) {
        try {
            list.put(new Address(address), new Human(info));
        } catch (Exception e) {
            System.out.println("Wrong format, try other");
        }
    }

    /**
     * Finds full info about Human with a given name.
     * @param secondName - String surname
     */
    public void findSecondName(String secondName) {
        boolean check = true;
        Set<Address> adds = this.list.keySet();
        for (Address add : adds) {
            if (this.list.get(add).getSecondName().equals(secondName)) {
                this.printSingle(add);
                check = false;
            }
        }
        if (check) {
            System.out.println("There is no such person");
        }
    }

    /**
     * Finds all Humans living on a given street.
     * @param street - String street name
     */
    public void findStreet(String street) {
        Set<Address> adds = this.list.keySet();
        boolean check = true;
        for (Address add : adds) {
            if (add.getStreetName().equals(street)) {
                this.printSingle(add);
                check = false;
            }
        }
        if (check) {
            System.out.println("There are no Humans living on this street");
        }
    }

    /**
     * Finds Human living at a given address.
     * @param address - String with correct format otherwise exception
     */
    public void findAddress(String address) {
        Address add = new Address(address);
        if (this.list.containsKey(add)) {
            this.printSingle(add);
        } else {
            System.out.println("There is no such person");
        }
    }

    /**
     * Finds Humans with a given birth date.
     * @param birthDate - Calendar format date
     */
    public void findBirthDate(Calendar birthDate) {
        boolean check = true;
        Set<Address> adds = this.list.keySet();
        for (Address add : adds) {
            if (this.list.get(add).getBirthDate().equals(birthDate)) {
                this.printSingle(add);
                check = false;
            }
        }
        if (check) {
            System.out.println("There is no pearson with such birth date");
        }
    }

    /**
     * Finds the youngest Human in the data base.
     */
    public void findYoungest() {
        Calendar youngest = Calendar.getInstance();
        youngest.set(0, Calendar.JANUARY, 1);
        Set<Address> adds = this.list.keySet();
        for (Address add : adds) {
            if (this.list.get(add).getBirthDate().after(youngest)) {
                youngest = this.list.get(add).getBirthDate();
            }
        }
        findBirthDate(youngest);
    }

    /**
     * Finds the oldest Human in the data base.
     */
    public void findOldest() {
        Calendar oldest = Calendar.getInstance();
        oldest.set(3000, Calendar.JANUARY, 1);
        Set<Address> adds = this.list.keySet();
        for (Address add : adds) {
            if (this.list.get(add).getBirthDate().before(oldest)) {
                oldest = this.list.get(add).getBirthDate();
            }
        }
        findBirthDate(oldest);
    }

    /**
     * Finds Humans who has a birth date in a given period.
     */
    public void findPeriod(Calendar dateStart, Calendar dateFinish) {
        boolean check = true;
        Set<Address> adds = this.list.keySet();
        for (Address add : adds) {
            if (this.list.get(add).getBirthDate().after(dateStart) && this.list.get(add).getBirthDate().before(dateFinish)) {
                this.printSingle(add);
                check = false;
            }

        }
        if (check) {
            System.out.println("There are no Humans with birth date in this period.");
        }
    }

    /**
     * Shows all data base content.
     */
    public void show() {
        Set<Address> adds = this.list.keySet();
        for (Address add : adds) {
            this.printSingle(add);
        }
    }

    /**
     * Additional function which helps to output full info about Human.
     * @param address - Address
     */
    public void printSingle(Address address) {
        System.out.println(this.list.get(address).toOutput() + " " + address.toOutput());
    }
}
