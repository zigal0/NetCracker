package ru.ncedu.zigal0.dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The Dice class represents implementation of dice game.
 * There are N players (computer is last in list). Everyone rolls K cubes at the same time. The one with the highest score is the winner.
 * Whoever won is the first to roll in the next round. The game goes up to 7 wins. You start the game.
 */
public class Dice implements Game{
    // Constants for output
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private static int numberOfCubes = 0;
    private static int numberOfPlayers = 0;
    private final static int wins = 7;
    private final ArrayList<PlayerDice> list = new ArrayList<>();

    /**
     * Initialization of new game. Clears list from previous players. Sets number of players and numbers of cubes.
     * Adds new players.
     */
    @Override
    public void init() {
        this.list.clear();
        Scanner in = new Scanner(System.in);
        String nStr;
        String kStr;
        do {
            System.out.print("Enter number of players: ");
            nStr = in.next();
            System.out.print("Enter number of cubes: ");
            kStr = in.next();
            if (isInteger(nStr) && isInteger(kStr)) {
                break;
            }
            System.out.println(ANSI_RED + "Wrong number of players or number of cubes, try other" + ANSI_RESET);
        } while (true);

        numberOfPlayers = Integer.parseInt(nStr) + 1;
        numberOfCubes = Integer.parseInt(kStr);

        String name;
        this.list.add(new PlayerDice("You"));
        System.out.println("Player # 1\n" + "You");
        for (int j = 1; j < numberOfPlayers - 1; j++) {
            System.out.println("Enter name player # " + (j + 1));
            name = in.next();
            this.list.add(new PlayerDice("Player " + name));
        }
        this.list.add(new PlayerDice("Computer"));
    }

    /**
     * Implementation of game algorithm
     */
    @Override
    public void playGame() {
        int curScore;
        int round = 1;
        do {
            int maxScore = 0;
            System.out.println("Round # " + round);
            round++;

            for (int j = 0; j < numberOfPlayers; j++) {
                curScore = throwDice();
                if (maxScore < curScore) {
                    maxScore = curScore;
                }
                this.list.get(j).setScore(curScore);
            }

            for (int j = 0; j < numberOfPlayers; j++) {
                System.out.println(this.list.get(j).getName() + " - " + this.list.get(j).getScore());
            }
            System.out.println();

            Collections.sort(this.list);
            for (int j = 0; j < numberOfPlayers; j++) {
                if (this.list.get(j).getScore() == maxScore) {
                    this.list.get(j).addWin();
                } else {
                    break;
                }
            }

        } while (!this.isGameFinished());

        this.showWinner();
    }

    /**
     * Shows Players who reach 7 wins
     */
    @Override
    public void showWinner() {
        for (int j = 0; j < numberOfPlayers; j++) {
            if (this.list.get(j).getNumberOfWins() == wins) {
                String nameOfWinner = this.list.get(j).getName();
                if (nameOfWinner.equals("You")) {
                    System.out.println(ANSI_YELLOW + "You are a winner!!!" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_YELLOW + nameOfWinner + " is a winner!!!" + ANSI_RESET);
                }
            }
        }
    }

    /**
     * Checks for ending game
     * @return true if game is finished or false
     */
    @Override
    public boolean isGameFinished() {
        for (int j = 0; j < numberOfPlayers; j++) {
            if (this.list.get(j).getNumberOfWins() == wins) {
                return true;
            }
        }
        return false;
    }

    /**
     * Implementation of tossing K dice.
     * @return score
     */
    public static int throwDice() {
        int res = 0;
        for (int i = 0; i < numberOfCubes; i++) {
            res += (int) Math.round((Math.random() * 5) + 1);
        }
        return res;
    }

    /**
     * Checks whether the String a valid Java integer.
     * @param str - the String to check
     * @return true if the string is a correctly formatted int
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Sets 0 to numberOfWins for all players.
     */
    public void clearNumberOfWins() {
        for (PlayerDice p : this.list) {
            p.setNumberOfWins(0);
        }
    }
}
