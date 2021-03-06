package ru.ncedu.zigal0.oddity;

/**
 * Classes that implement this interface can easily check whether the number is odd or not.
 */
public interface Oddity {
    /**
     * Sets new number.
     * @param x - new value
     */
    void setNumber(int x);

    /**
     * Checks whether the number is odd or not and print result in console.
     */
    void isOdd();
}
