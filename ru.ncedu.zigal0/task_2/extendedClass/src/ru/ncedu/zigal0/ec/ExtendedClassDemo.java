package ru.ncedu.zigal0.ec;

import java.util.HashSet;
import java.util.Set;

public class ExtendedClassDemo {
    public static void main(String[] args) {
        ExtendedClass<Byte> byteExample = new ExtendedClass<>((byte) 5);
        ExtendedClass<Integer> intExample = new ExtendedClass<>(6666);
        ExtendedClass<Double> doubleExample = new ExtendedClass<>(3.14);
        ExtendedClass<String> stringExample = new ExtendedClass<>("simple");
        ExtendedClass<String> stringExample2 = new ExtendedClass<>("simple");

        Set<ExtendedClass<?>> set = new HashSet<>();
        set.add(byteExample);
        set.add(intExample);
        set.add(doubleExample);
        set.add(stringExample);

        for (Object obj : set) {
            System.out.println(obj.hashCode() + " " + obj);
        }
        System.out.println(set);
        System.out.println(stringExample.equals(stringExample2));
    }
}
