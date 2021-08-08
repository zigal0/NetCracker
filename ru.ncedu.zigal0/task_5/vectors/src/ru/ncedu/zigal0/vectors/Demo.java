package ru.ncedu.zigal0.vectors;

import java.io.*;
import java.util.Vector;

public class Demo {
    public static void main(String[] args) throws IOException {
        String separator = "**********************************************";
        // Creation Vector v1
        Vector<Double> v1 = new Vector<>();
        v1.add(2.5);
        v1.add(3d);
        v1.add(5d);
        v1.add(11.2);
        System.out.println("Initial vector v1");
        printVector(v1);
        System.out.println(separator);

        // Simple operation
        System.out.println("Multiplied by 3");
        printVector(Vectors.multiplyByScalar(v1, 3));
        System.out.println(separator);

        System.out.println("Divided by 5");
        printVector(Vectors.divByScalar(v1, 5));
        System.out.println(separator);

        // Creation Vector v2 of the same size
        Vector<Double> v2 = new Vector<>();
        v2.add(8d);
        v2.add(1.1);
        v2.add(49.11);
        v2.add(23d);

        System.out.println("Initial vector v2");
        printVector(v2);
        System.out.println(separator);


        System.out.println("Sum of 2 vectors");
        printVector(Vectors.sumVectors(v1, v2));
        System.out.println(separator);

        System.out.println("Difference between 2 vectors");
        printVector(Vectors.difVectors(v1, v2));
        System.out.println(separator);

        System.out.println("Scalar product");
        System.out.println(Vectors.dotProduct(v1, v2));

        // Creation Vector v2 of a different size
        Vector<Double> v3 = new Vector<>();
        v2.add(8d);
        System.out.println(separator);

        // Try to sum vectors with different size
        try {
            Vectors.sumVectors(v1, v3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: different sizes");
        }
        // Try to scalar multiply vectors with different size
        try {
            Vectors.dotProduct(v1, v3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: different sizes");
        }
        // Try to scalar multiply vector & null
        try {
            Vectors.dotProduct(v1, null);
        } catch (IllegalStateException e) {
            System.out.println("One Vector is null");
        }
        System.out.println(separator);

        // Input & output
        //// Byte
        System.out.println("Write the vector to ByteFile.bin in byte representation");
        File file = new File("ByteFile.bin");
        FileOutputStream fos = new FileOutputStream(file);
        Vectors.outputVector(v1, fos);

        System.out.println("Read the vector from ByteFile.bin in byte representation");
        FileInputStream fis = new FileInputStream(file);
        Vector<Double> v4 = Vectors.inputVector(fis);
        printVector(v4);
        System.out.println(separator);

        fis.close();
        fos.close();

        // Symbols
        Reader reader = new InputStreamReader(System.in);
        Vector<Double> vRead = Vectors.readVector(reader);

        Writer writer = new PrintWriter(System.out);
        Vectors.writeVector(vRead, writer);
        System.out.println();
        System.out.println(separator);

        reader.close();
        writer.close();
    }

    public static void printVector(Vector<?> v) {
        System.out.print("Size: " + v.size() + "\n" + "Content: ");
        for (Object item : v) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

