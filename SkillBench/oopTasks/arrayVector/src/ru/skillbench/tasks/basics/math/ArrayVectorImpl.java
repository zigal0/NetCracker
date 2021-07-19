package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{

    private double[] vector;
    @Override
    public void set(double... elements) {
        vector = elements;
    }

    @Override
    public double[] get() {
        return vector;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector res = new ArrayVectorImpl();
        res.set(this.vector.clone());
        return res;
    }

    @Override
    public int getSize() {
        return vector.length;
    }

    @Override
    public void set(int index, double value) {
        if (index >=  vector.length) {
            double[] newVector = new double[index + 1];
            System.arraycopy(vector, 0, newVector, 0, vector.length);
            vector = newVector;
            vector[index] = value;
        } else if (index >= 0) {
            vector[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return vector[index];
    }

    @Override
    public double getMax() {
        double maxValue = vector[0];
        for (double v : vector) {
            if (maxValue < v) {
                maxValue = v;
            }
        }
        return maxValue;
    }

    @Override
    public double getMin() {
        double minValue = vector[0];
        for (double v : vector) {
            if (minValue > v) {
                minValue = v;
            }
        }
        return minValue;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(vector);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int sumIndex = Math.min(vector.length, anotherVector.getSize());
        for (int i = 0; i < sumIndex; i++) {
            vector[i] += anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int multIndex = Math.min(vector.length, anotherVector.getSize());
        double res = 0;
        for (int i = 0; i < multIndex; i++) {
            res += vector[i] * anotherVector.get(i);
        }
        return res;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }
}
