package ru.ncedu.zigal0.dice;

public interface Game {
    void init();
    void playGame();
    void showWinner();
    boolean isGameFinished();
}
