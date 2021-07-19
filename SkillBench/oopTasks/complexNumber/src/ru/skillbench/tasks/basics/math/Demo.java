package ru.skillbench.tasks.basics.math;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
//        System.out.println(Double.parseDouble("-1.5"));
//        Scanner in = new Scanner(System.in);
//        String number;
//        number = in.nextLine();
//        int sub = Math.max(number.lastIndexOf("+"), number.lastIndexOf("-"));
//        String imString = number.substring(sub, number.length() - 1);
//        String reString = number.substring(0, sub);
//        System.out.println(imString);
//        System.out.println(Double.parseDouble(reString));
//        System.out.println(sub);
//        System.out.println(number.lastIndexOf("+"));
        ComplexNumber n = new ComplexNumberImpl("-3i");
        n.set("4");
//        ComplexNumber n1 = new ComplexNumberImpl("-5+2i");
//        ComplexNumber n2 = new ComplexNumberImpl("1+i");
//        ComplexNumber n3 = new ComplexNumberImpl("+4-i");
//        ComplexNumber n4 = new ComplexNumberImpl("i");
//        ComplexNumber n5 = new ComplexNumberImpl("-3i");
//        ComplexNumber n6 = new ComplexNumberImpl("3");
        System.out.println(n);
//        System.out.println(n1.toString());
//        System.out.println(n2.toString());
//        System.out.println(n3.toString());
//        System.out.println(n4.toString());
//        System.out.println(n5.toString());
//        System.out.println(n6.toString());
    }
}
