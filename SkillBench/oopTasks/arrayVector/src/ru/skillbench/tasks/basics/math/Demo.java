package ru.skillbench.tasks.basics.math;

public class Demo {
    public static void main(String[] args) {
        ArrayVector avi = new ArrayVectorImpl();
        double[] a = {1, 2, 3, 5};
        avi.set(a);
        avi.get(7);
    }
}
