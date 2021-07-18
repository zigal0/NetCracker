package ru.ncedu.zigal0.sd;

import java.util.Scanner;

public class DiceDemo implements gameDemo{
    // Constant for output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        DiceDemo diceDemo = new DiceDemo();
        diceDemo.startGame();
    }

    @Override
    public void startGame() {
        System.out.println("Game of dice with computer");
        this.getHelp();
        Scanner in = new Scanner(System.in);
        String command;
        Dice dice = new Dice();
        boolean firstTime = true;
        label:
        while (true) {
            command = in.next();
            switch (command) {
                case "end":
                    break label;
                case "again":
                    if (firstTime) {
                        System.out.println(ANSI_RED + "No players because it is first game" + ANSI_RESET);
                        continue;
                    }
                    dice.clearNumberOfWins();
                    dice.playGame();
                    break;
                case "new":
                    firstTime = false;
                    dice.init();
                    dice.playGame();
                    break;
                case "help":
                    this.getHelp();
                    break;
                default:
                    System.err.println(ANSI_RED + "Wrong command, try other" + ANSI_RESET);
                    break;
            }
        }
    }

    @Override
    public void getHelp() {
        System.out.println("There are next commands:");
        System.out.println(" - \"new\" tto start new game with new players;");
        System.out.println(" - \"help\" to get info about commands;");
        System.out.println(" - \"again\" to start new game with same players;");
        System.out.println(" - \"end\" to finish session.");
    }
}
