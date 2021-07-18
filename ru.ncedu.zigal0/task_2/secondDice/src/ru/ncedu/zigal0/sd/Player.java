package ru.ncedu.zigal0.sd;

/**
 * The Player interface define main methods which every player should to have.
 */
public interface Player {
    /**
     * Return name of the Player.
     * @return String
     */
    String getName();

    /**
     * Sets new score of Player.
     * @param score - new score
     */
    void setScore(int score);

    /**
     * Returns current score of Player.
     * @return int - current score
     */
    int getScore();
}
