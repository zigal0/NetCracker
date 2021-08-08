package ru.ncedu.zigal0.persist;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Class SerializeMyClassToBePersisted represents deserialization of MyClassToBePersisted from myClassToBePersisted.ser.
 *
 * @author zigal0
 */
public class DeserializeMyClassToBePersisted {
    public static void main(String[] args) {
        deserialize();
    }

    /**
     * Deserializes Class MyClassToBePersisted.
     */
    public static void deserialize() {
        MyClassToBePersisted myClassToBePersisted;

        try {
            FileInputStream fileIn = new FileInputStream("myClassToBePersisted.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myClassToBePersisted = (MyClassToBePersisted) in.readObject();
            System.out.println("Serialized data is read from myClassToBePersisted.ser");
            System.out.println("After Deserialization: " + myClassToBePersisted);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
