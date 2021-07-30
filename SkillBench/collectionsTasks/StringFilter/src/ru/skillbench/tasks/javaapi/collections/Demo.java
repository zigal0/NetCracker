package ru.skillbench.tasks.javaapi.collections;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        String separator = "*********************************************";
        StringFilter list = new StringFilterImpl();
        list.add("Lol");
        list.add(null);
        list.add("Kek");
        list.add("CheBureck");
        list.add("Lol");
        list.add("NiggeR");
        list.remove("nIgger");
        list.add("Chicken");
        list.add("Char");
        list.add("91");
        list.add("distribute");
        list.add("(123)456-7890");
        list.add("-7.55");
        list.add("1000");
        list.add("1 000");
        list.add("protection");
        list.add("copyright");
        list.add("charge");
        list.add("original");
        list.add("guarantee");
        list.add("program");
        list.add("danger");
        list.add("verbatim");
        list.add("redistributors");
        list.add("recipients");
        list.add("restricted");
        list.add("outside");
        list.add("instead");
        list.add("restest");
        list.add("chcher");


        Collection<String> full = list.getCollection();
        for (String word : full) {
            System.out.println(word);
        }
        System.out.println(separator);

        Iterator<String> collection = list.getStringsContaining("ol");
        if (!collection.hasNext()) {
            System.out.println("Empty");
        }
        while (collection.hasNext()) {
            System.out.println(collection.next());
        }
        System.out.println(separator);

        collection = list.getStringsStartingWith("Ch");
        if (!collection.hasNext()) {
            System.out.println("Empty");
        }
        while (collection.hasNext()) {
            System.out.println(collection.next());
        }
        System.out.println(separator);

        collection = list.getStringsByNumberFormat("####");
        if (!collection.hasNext()) {
            System.out.println("Empty");
        }
        while (collection.hasNext()) {
            System.out.println(collection.next());
        }
        System.out.println(separator);

        collection = list.getStringsByPattern("*ch*ch*");
        if (!collection.hasNext()) {
            System.out.println("Empty");
        }
        while (collection.hasNext()) {
            System.out.println(collection.next());
        }
        System.out.println(separator);
    }
}
