package ru.ncedu.zigal0.vectors;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Class Vectors represents math operations on vectors such as sum, multiplication by scalar, dot product and other.
 * Also, this class allows outputting/inputting Vector from/into byte stream and symbols stream.
 *
 * @author zigal0.
 */
public class Vectors {

    /**
     * Multiplies vector by scalar.
     *
     * @param v      - the initial vector.
     * @param scalar - the scalar of double type.
     * @return Vector<Double> - vector multiplied by the scalar.
     * @throws IllegalStateException - if v is null.
     */
    public static Vector<Double> multiplyByScalar(Vector<Double> v, double scalar) throws IllegalStateException {
        if (v == null) {
            throw new IllegalStateException();
        }
        Vector<Double> res = new Vector<>();
        for (double item : v) {
            res.add(item * scalar);
        }
        return res;
    }

    /**
     * Adds 2 given vectors.
     *
     * @param v1 - the first vector.
     * @param v2 - the second vector.
     * @return Vector<Double> - sum of Vector v1 and Vector v2.
     * @throws ArrayIndexOutOfBoundsException - if vectors have different sizes.
     * @throws IllegalStateException          - if one of the Vector is null.
     */
    public static Vector<Double> sumVectors(Vector<Double> v1, Vector<Double> v2) throws ArrayIndexOutOfBoundsException, IllegalStateException {
        if (v1 == null || v2 == null) {
            throw new IllegalStateException();
        }
        if (v1.size() != v2.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Vector<Double> res = new Vector<>();
        for (int i = 0; i < v1.size(); i++) {
            res.add(v1.get(i) + v2.get(i));
        }
        return res;
    }

    /**
     * Performs scalar vector multiplication.
     *
     * @param v1 - the first vector.
     * @param v2 - the second vector.
     * @return double - result of dot product.
     * @throws ArrayIndexOutOfBoundsException - if vectors have different sizes.
     * @throws IllegalStateException          - if one of the Vector is null.
     */
    public static double dotProduct(Vector<Double> v1, Vector<Double> v2) throws ArrayIndexOutOfBoundsException, IllegalStateException {
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

    /**
     * Subtracts from the first vector the second.
     *
     * @param v1 - the first vector.
     * @param v2 - the second vector.
     * @return Vector<Double> - difference of Vector v1 and Vector v2.
     * @throws ArrayIndexOutOfBoundsException - if vectors have different sizes.
     * @throws IllegalStateException          - if one of the Vector is null.
     */
    public static Vector<Double> difVectors(Vector<Double> v1, Vector<Double> v2) throws ArrayIndexOutOfBoundsException, IllegalStateException {
        return sumVectors(v1, multiplyByScalar(v2, -1));
    }

    /**
     * Divides vector by scalar.
     *
     * @param v       - the initial vector.
     * @param divisor - the scalar of double type.
     * @return Vector<Double> - vector multiplied by the scalar.
     * @throws IllegalStateException - if v is null.
     */
    public static Vector<Double> divByScalar(Vector<Double> v, double divisor) throws NullPointerException, IllegalStateException {
        if (divisor == 0) {
            throw new NullPointerException();
        }
        return multiplyByScalar(v, 1 / divisor);
    }

    /**
     * Writes set vector v to byte stream.
     *
     * @param v   - the initial vector.
     * @param out - the stream into which the vector will be written (OutputStream).
     * @throws IOException - if any error occurs with IO.
     */
    public static void outputVector(Vector<Double> v, OutputStream out) throws IOException {
//        out.write(toByteArray(v.size()));
//        for (double item : v) {
//           out.write(toByteArray(item));
//        }
//        out.flush();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(v.size());
        for (double item : v) {
            dos.writeDouble(item);
        }
        out.flush();
        dos.close();
    }

    /**
     * Reads set vector v to byte stream.
     *
     * @param in - the stream from which the vector will be read (InputStream).
     * @return Vector - read vector from in.
     * @throws IOException - if any error occurs with IO.
     */
    public static Vector<Double> inputVector(InputStream in) throws IOException {
//        byte[] bytes = new byte[8];
//        if (in.read(bytes) != 8) {
//            throw new IOException();
//        }
//        Vector<Double> v = new Vector<>((int) toDouble(bytes));
//        while (in.available()>0) {
//            if (in.read(bytes) != 8) {
//                throw new IOException();
//            }
//            v.add(toDouble(bytes));
//        }
//        return v;
        DataInputStream dis = new DataInputStream(in);
        int size = dis.readInt();
        Vector<Double> v = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            v.add(dis.readDouble());
        }
        dis.close();
        return v;
    }

    /**
     * Converts double to byte array.
     *
     * @param value - double value.
     * @return byte[] - byte array
     * @deprecated
     */
    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }

    /**
     * Converts byte array to Double.
     *
     * @param bytes - byte array.
     * @return double - double value.
     * @deprecated
     */
    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }

    /**
     * Writes set vector v to symbol stream.
     *
     * @param v   - the initial vector.
     * @param out - the stream into which the vector will be written (Writer).
     * @throws IOException - if any error occurs with IO.
     */
    public static void writeVector(Vector<Double> v, Writer out) throws IOException {
        out.write("" + v.size());
        for (double item : v) {
            out.write(" " + item);
        }
        out.flush();
    }

    /**
     * Reads set vector v to symbol stream.
     *
     * @param in - the stream from which the vector will be read (Reader).
     * @return Vector - read vector from in.
     * @throws IOException - if any error occurs with IO.
     */
    public static Vector<Double> readVector(Reader in) throws IOException {
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
