package ru.ncedu.zigal0.oddity;

public class OddImpl implements Oddity {
    private int number;

    public OddImpl() {
        number = 0;
    }

    public OddImpl(int number) {
        this.number = number;
    }

    @Override
    public void setNumber(int x) {
        number = x;
    }

    @Override
    public boolean isOdd() {
        return number % 2 == 0;
    }
}
