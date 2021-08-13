package ru.ncedu.zigal0.nio2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MyNumbers {
    public static void main(String[] args) throws IOException {

        String separator = "*****************************************************";

        System.out.println("Enter number of integers: ");
        Scanner in = new Scanner(System.in);
        int numbers = in.nextInt();

        Path path = Paths.get("Numbers.txt");
        if (Files.exists(path)) {
            Files.delete(path);
        }
        Files.createFile(path);

        // Output integers
        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        for (int i = 1; i <= numbers; i++) {
            writer.write(i);
        }
        writer.close();

        // Input
        double avg = 0;
        int i = 0;
        // Input integers
        int curInt;
        DataInputStream dis;
        dis = new DataInputStream(Files.newInputStream(path));
        while (true) {
            try {
                curInt = dis.readInt();
                i++;
                avg = (avg * (i - 1) + curInt) / i;
                System.out.print(curInt + " ");
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println();
        System.out.println("Number of integers: " + i + ", and their arithmetic mean: " + avg);
        System.out.println(separator);

        // Input bytes
        avg = 0;
        i = 0;
        byte curByte;
        dis = new DataInputStream(Files.newInputStream(path));
        while (true) {
            try {
                curByte = dis.readByte();
                i++;
                avg = (avg * (i - 1) + curByte) / i;
                System.out.print(curByte + " ");
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println();
        System.out.println("Number of bytes: " + i + ", and their arithmetic mean: " + avg);
        System.out.println(separator);

        // Input floats
        avg = 0;
        i = 0;
        float curFloat;
        dis = new DataInputStream(Files.newInputStream(path));
        while (true) {
            try {
                curFloat = dis.readFloat();
                i++;
                avg = (avg * (i - 1) + curFloat) / i;
                System.out.print(curFloat + " ");
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println();
        System.out.println("Number of floats: " + i + ", and their arithmetic mean: " + avg);
        System.out.println(separator);
        dis.close();
    }
}