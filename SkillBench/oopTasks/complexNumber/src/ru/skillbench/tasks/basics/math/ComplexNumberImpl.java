package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {

    private double re;
    private double im;

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl(String value) {
        numberParser(value);
    }

    public ComplexNumberImpl() {
        re = 0;
        im = 0;
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        re = 0;
        im = 0;
        this.numberParser(value);
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber copyNumber = new ComplexNumberImpl();
        copyNumber.set(this.re, this.im);
        return copyNumber;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return copy();
    }

    @Override
    public String toString() {
        if (re == 0 & im == 0) {
            return "0.0";
        }
        String res = "";
        if (re != 0) {
            res = Double.toString(re);
        }
        if (im != 0) {
            if (im > 0 && re != 0) {
                res += "+";
            }
            res += im + "i";
        }
        return res;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber cn = (ComplexNumber) other;
        return cn.getRe() == re && cn.getIm() == im;
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double res = Math.pow(re, 2) + Math.pow(im, 2) - Math.pow(other.getRe(), 2) - Math.pow(other.getIm(), 2);
        if (res < 0) {
            return -1;
        }
        if (res > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        re *= -1;
        im *= -1;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        // this number is a+bi and arg2 is c+di
        // a*c-b*d
        double curRe = re * arg2.getRe() - im * arg2.getIm();
        // b*c+a*d
        double curIm = im * arg2.getRe() + re * arg2.getIm();
        re = curRe;
        im = curIm;
        return this;
    }

    private void numberParser(String value) {
        if (value.charAt(value.length() - 1) != 'i') {
            this.re = Double.parseDouble(value);
        } else {
            int sub = Math.max(value.lastIndexOf("+"), value.lastIndexOf("-"));
            if (sub == -1) {
                if (value.length() == 1) {
                    im = 1;
                } else {
                    im = Double.parseDouble(value.substring(0, value.length() - 1));
                }
                re = 0;
            } else {
                String reString = value.substring(0, sub);
                String imString = value.substring(sub, value.length() - 1);
                if (reString.isEmpty()) {
                    re = 0;
                } else {
                    re = Double.parseDouble(reString);
                }
                if (imString.length() != 1) {
                    im = Double.parseDouble(imString);
                } else {
                    if (value.charAt(sub) == '-') {
                        im = -1;
                    } else {
                        im = 1;
                    }
                }
            }
        }
    }
}
