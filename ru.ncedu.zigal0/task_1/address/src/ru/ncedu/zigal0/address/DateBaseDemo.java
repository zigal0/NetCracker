package ru.ncedu.zigal0.address;

import java.util.Scanner;

public class DateBaseDemo {
    // Constants for output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        DateBaseDemo dbd = new DateBaseDemo();
        DataBase db = new DataBase();
        System.out.println("Simple realization of data base");
        dbd.getHelp();
        Scanner in = new Scanner(System.in);
        String command;
        label:
        while (true) {
            command = in.nextLine();
            switch (command) {
                case "end":
                    break label;
                case "add":
                    System.out.println(ANSI_YELLOW + "Example:\n Enter info about pearson: Efimov Sergey 30.11.1999\n Enter address: SunBase 23 159" + ANSI_RESET);
                    System.out.print("Enter info about pearson: ");
                    String info = in.nextLine();
                    System.out.print("Enter address: ");
                    String addressNew = in.nextLine();
                    try {
                        db.addNew(info, addressNew);
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Wrong info format" + ANSI_RESET);
                    }
                    break;
                case "help":
                    dbd.getHelp();
                    break;
                case "surname":
                    System.out.print("Enter surname: ");
                    String surname = in.nextLine();
                    db.findSecondName(surname);
                    break;
                case "address":
                    System.out.println(ANSI_YELLOW + "Example:\n Enter address: SunBase 23 159" + ANSI_RESET);
                    System.out.print("Enter address: ");
                    String address = in.nextLine();
                    try {
                        db.findAddress(address);
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Wrong address format" + ANSI_RESET);
                    }
                    break;
                case "period":
                    System.out.println(ANSI_YELLOW + "Example:\n Start: 1.1.1999\n Finish: 1.1.2003" + ANSI_RESET);
                    System.out.print("Start: ");
                    String start = in.nextLine();
                    System.out.print("Finish: ");
                    String finish = in.nextLine();
                    try {
                        db.findPeriod(DateParser.parseDate(start), DateParser.parseDate(finish));
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Wrong date format" + ANSI_RESET);
                    }
                    break;
                case "oldest":
                    db.findOldest();
                    break;
                case "youngest":
                    db.findYoungest();
                    break;
                case "street":
                    System.out.print("Enter street name: ");
                    String street = in.nextLine();
                    db.findStreet(street);
                    break;
                case "show":
                    db.show();
                    break;
                default:
                    System.err.println(ANSI_RED + "Wrong command, try other" + ANSI_RESET);
                    break;
            }
        }
    }

    public void getHelp() {
        System.out.println("There are next commands:");
        System.out.println(" - \"add\" to sad new pearson to data base;");
        System.out.println(" - \"help\" to get info about commands;");
        System.out.println(" - \"surname\" to find person by last name;");
        System.out.println(" - \"address\" to find person by address;");
        System.out.println(" - \"period\" to find people born in a given period;");
        System.out.println(" - \"oldest\" to find oldest pearson;");
        System.out.println(" - \"youngest\" to find youngest pearson;");
        System.out.println(" - \"street\" to find people living on a given street;");
        System.out.println(" - \"show\" to show all humans in the data base;");
        System.out.println(" - \"end\" to finish session.");
    }
}
