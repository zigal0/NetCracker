package ru.ncedu.zigal0.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class OwnCode {

    public static void main(String[] args) throws IOException {

        String curDir = Paths.get("").toAbsolutePath().toString();
        System.out.println("Current dir: " + curDir);
        String className = MethodHandles.lookup().toString();
        System.out.println("Class name: " + className);

        Path initialDir = Paths.get("InitialDir.txt");
        if (Files.exists(initialDir)) {
            System.out.println("The file initialDir.txt already exists in project dir.");
        } else {
            Files.createFile(initialDir);
            System.out.println("The file initialDir.txt was created in project dir.");
        }

        // Idk how to go to the src directory.

        className = className.replace('.', '/');

        System.out.println("Changed format of Class name: " + className);
        String absPath = curDir + "/src/" + className + ".java";
        System.out.println("Absolute way of running class: " + absPath);
        Path path = Paths.get(absPath);
        System.out.println("Code of running class:");
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
