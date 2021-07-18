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
    public void isOdd() {
        if (number % 2 != 0) {
            System.out.println("Number is odd");
        } else {
            System.out.println("Number is even");
        }
    }
}
