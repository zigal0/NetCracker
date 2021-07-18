package ru.ncedu.zigal0.oddity;

public class OddImplDemo {
    public static void main(String[] args) {
        OddImpl oddImpl1 = new OddImpl();
        oddImpl1.setNumber(42);
        OddImpl oddImpl2 = new OddImpl(69);
        oddImpl1.isOdd();
        oddImpl2.isOdd();
    }
}
