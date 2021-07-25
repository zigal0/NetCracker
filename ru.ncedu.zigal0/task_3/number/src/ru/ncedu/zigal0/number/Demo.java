package ru.ncedu.zigal0.number;

public class Demo {
    public static void main(String[] args) {
        System.out.println(PhoneNumberParser.convert("89175655655"));
        System.out.println(PhoneNumberParser.convert("+79175655655"));
        System.out.println(PhoneNumberParser.convert("+19175655655"));
        System.out.println(PhoneNumberParser.convert("+9175655655"));
        System.out.println(PhoneNumberParser.convert("5175655655"));
    }
}
