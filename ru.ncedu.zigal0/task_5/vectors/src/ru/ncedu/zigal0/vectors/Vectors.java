package ru.ncedu.zigal0.vectors;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;
import java.util.Vector;

public class Vectors {

    public Vector<Double> multiplyByScalar(Vector<Double> v, double scalar) throws IllegalStateException {
        if (v == null) {
            throw new IllegalStateException();
        }
        Vector<Double> res = new Vector<>();
        for (double item : v) {
            res.add(item * scalar);
        }
        return res;
    }

    public Vector<Double> sumVectors(Vector<Double> v1, Vector<Double> v2) throws ArrayIndexOutOfBoundsException, IllegalStateException {
        if (v1 == null || v2 == null) {
            throw new IllegalStateException();
        }
        if (v1.size() != v2.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Vector<Double> res = new Vector<>();
        for (int i = 0; i < v1.size(); i++) {
            System.out.println(v1.get(i) + " " + v2.get(i));
            res.add(v1.get(i) + v2.get(i));
        }
        return res;
    }

    public double dotProduct(Vector<Double> v1, Vector<Double> v2) throws ArrayIndexOutOfBoundsException, IllegalStateException {
        if (v1 == null || v2 == null) {
            throw new IllegalStateException();
        }
        if (v1.size() != v2.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        double res = 0;
        for (int i = 0; i < v1.size(); i++) {
            res = v1.get(i) * v2.get(i) + res;
        }
        return res;
    }

    public Vector<Double> difVectors(Vector<Double> v1, Vector<Double> v2) throws ArrayIndexOutOfBoundsException, IllegalStateException {
        return sumVectors(v1, multiplyByScalar(v2, -1));
    }

    public Vector<Double> divByScalar(Vector<Double> v, double divisor) throws NullPointerException, IllegalStateException {
        if (divisor == 0) {
            throw new NullPointerException();
        }
        return multiplyByScalar(v, 1 / divisor);
    }

    public void outputVector(Vector<Double> v, OutputStream out) throws IOException {
        out.write(toByteArray(v.size()));
        for (double item : v) {
           out.write(toByteArray(item));
        }
        out.flush();
    }

    public Vector<Double> inputVector(InputStream in) throws IOException {
        byte[] bytes = new byte[8];
        if (in.read(bytes) != 8) {
            throw new IOException();
        }
        Vector<Double> v = new Vector<>((int) toDouble(bytes));
        while (in.available()>0) {
            if (in.read(bytes) != 8) {
                throw new IOException();
            }
            v.add(toDouble(bytes));
        }
        return v;
    }

    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }

    public void writeVector(Vector<Double> v, Writer out) throws IOException {
        out.write("" + v.size());
        for (double item : v) {
            out.write(" " + item);
        }
        out.flush();
    }

    public Vector<Double> readVector(Reader in) throws IOException {
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = (char) in.read();
            sb.append(c);
        } while (c != '\n');
        System.out.println(sb);
        StringTokenizer tokenizer = new StringTokenizer(sb.toString().trim(), " ");
        if (tokenizer.countTokens() == 0) {
            throw new IllegalStateException();
        }
        int size = Integer.parseInt(tokenizer.nextToken());
        Vector<Double> v = new Vector<>();
        for (int i = 0; i < size; i++) {
            v.add(Double.parseDouble(tokenizer.nextToken()));
        }
        return v;
    }
}
