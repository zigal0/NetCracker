package ru.ncedu.zigal0.oddity;

public class OddImplDemo {
    public static void main(String[] args) {
        OddImpl oddImpl1 = new OddImpl();
        OddImpl oddImpl2 = new OddImpl(69);
        oddImpl1.setNumber(42);
        System.out.println(oddImpl1.isOdd());
        System.out.println(oddImpl2.isOdd());
    }
}
