package ru.ncedu.zigal0.sqe;

import java.util.Scanner;

/**
 * The QuadraticEquation class represents implementation of the solution of a quadratic equation.
 * To run program, you should type start.
 * To stop program, you should type end.
 * Also there is coefficients type check.
 */
public class QuadraticEquation {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private double a;
    private double b;
    private double c;

    /**
     * Inner class for calculation discriminant of the equation.
     */
    class Discriminant {
        public double calculate() {
            return b * b - 4 * a * c;
        }
    }

    /**
     * Checks whether the String a valid Java number.
     * @param str - the String to check
     * @return true if the string is a correctly formatted number
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Gets coefficients from console for solving.
     */
    public void getCoefficients() {
        Scanner in = new Scanner(System.in);
        String aStr, bStr, cStr;
        do {
            System.out.print("A = ");
            aStr = in.next();
            System.out.print("B = ");
            bStr = in.next();
            System.out.print("C = ");
            cStr = in.next();
            if (isNumeric(aStr) && isNumeric(bStr) && isNumeric(cStr)) {
                break;
            }
            System.out.println(ANSI_RED + "Wrong coefficients, try other" + ANSI_RESET);
        } while (true);

        a = Double.parseDouble(aStr);
        b = Double.parseDouble(bStr);
        c = Double.parseDouble(cStr);
    }

    /**
     * Implementation of the algorithm for solving a quadratic equation.
     */
    public void solution() {

        Discriminant discriminant = new Discriminant();
        double d = discriminant.calculate();

        if (a == 0) {
            if (b != 0) {
                System.out.println("x = " + (-c / b));
            } else {
                System.out.println("No solution");
            }
        } else if (d == 0) {
            System.out.println("x = " + (-b / (2 * a)));
        } else if (d > 0) {
            double sol1 = (-b + Math.sqrt(d)) / (2 * a);
            double sol2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("x1 = " + sol1 + " x2 = " + sol2);
        } else {
            System.out.println("No Solution");
        }
    }
}

