package ru.ncedu.zigal0.dice;

/**
 * The Player class represents player realization.
 */
public class PlayerDice implements Comparable<PlayerDice>, Player {
    private int numberOfWins;
    private int score;
    private final String name;

    public PlayerDice(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(PlayerDice other) {
        return other.getScore() - this.score;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void addWin() {
        numberOfWins++;
    }
}
