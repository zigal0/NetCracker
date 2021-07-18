package ru.ncedu.zigal0.sd;

/**
 * The Game interface sets the main rules how to create class AnyGame for console games.
 */
public interface Game {
    /**
     * Sets new game and sets default settings.
     */
    void init();

    /**
     * Starts game process.
     */
    void playGame();

    /**
     * Shows winner of the game.
     */
    void showWinner();

    /**
     * Checks whether the game is finished or not.
     * @return boolean - true if game is finished
     * and false otherwise
     */
    boolean isGameFinished();
}
