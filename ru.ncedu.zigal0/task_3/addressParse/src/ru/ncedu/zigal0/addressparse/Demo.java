package ru.ncedu.zigal0.addressparse;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Demo {
    public static void main(String[] args) {
        System.out.println("AddressTest(JUnit) is running:");
        Result result = JUnitCore.runClasses(AddressTest.class);
        if(result.wasSuccessful()) {
            System.out.println("All tests finished successfully");
        } else {
            System.out.println(result);
        }
        System.out.println("MyTest is running:");
        MyTest myTest = new MyTest();
        if (myTest.testRunner()) {
            System.out.println("All tests were passed");
        } else {
            System.out.println("There are mistakes");
        }
    }
}
