package ru.ncedu.zigal0.vectors;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Vector;

public class Demo {
    public static void main(String[] args) throws IOException {
        Vector<Double> v1 = new Vector<>();
        v1.add(2.5);
        v1.add(3d);
        v1.add(5d);
        v1.add(11.2);
        Vectors vectors = new Vectors();
//        v1 = vectors.multiplyByScalar(v1, 2);
//        Vector<Double> v2 = new Vector<>();
//        v2.add(8d);
//        v2.add(1.1);
//        v2.add(49.11);
//        v2.add(15.2);
//        Vector<Double> res = vectors.sumVectors(v1, v2);
        File file = new File("result.txt");
        FileOutputStream fos = new FileOutputStream(file);
        vectors.outputVector(v1, fos);
        FileInputStream fis = new FileInputStream(file);
        Vector<Double> res = vectors.inputVector(fis);
        Writer writer = new PrintWriter(System.out);
        vectors.writeVector(res, writer);
        System.out.println();
        Reader reader = new InputStreamReader(System.in);
        Vector<Double> vRead = vectors.readVector(reader);
//        vectors.writeVector(vRead, writer);
        reader.close();
        fis.close();
        fos.close();
    }

}
