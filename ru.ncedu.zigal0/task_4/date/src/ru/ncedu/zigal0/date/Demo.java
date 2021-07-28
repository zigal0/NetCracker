package ru.ncedu.zigal0.date;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.text.ParseException;

public class Demo {
    public static void main(String[] args) throws ParseException {
        System.out.println("AddressTest(JUnit) is running:");
        Result result = JUnitCore.runClasses(FormatterTest.class);
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
