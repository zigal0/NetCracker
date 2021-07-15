package ru.ncedu.zigal0.sqe;

import java.util.Scanner;

public class QuadraticEquationDemo {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        QuadraticEquationDemo qed = new QuadraticEquationDemo();
        System.out.println("Program for solution of quadratic equation: A * x^2 + B * x + C = 0");
        qed.getHelp();
        Scanner in = new Scanner(System.in);
        String command;
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        label:
        while (true) {
            command = in.nextLine();
            switch (command) {
                case "end":
                    break label;
                case "start":
                    quadraticEquation.getCoefficients();
                    quadraticEquation.solution();
                    break;
                case "help":
                    qed.getHelp();
                    break;
                default:
                    System.err.println(ANSI_RED + "Wrong command, try other" + ANSI_RESET);
                    break;
            }
        }
    }

    public void getHelp() {
        System.out.println("There are next commands:");
        System.out.println(" - \"start\" to run program;");
        System.out.println(" - \"help\" to get info about commands;");
        System.out.println(" - \"end\" to finish session.");
    }
}
