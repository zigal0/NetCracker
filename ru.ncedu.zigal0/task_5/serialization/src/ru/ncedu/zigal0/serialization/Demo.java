package ru.ncedu.zigal0.serialization;

import javax.xml.transform.sax.SAXSource;
import java.io.*;

public class Demo {
    public static void main(String[] args) {
        // LinkedListVector.
        System.out.println("LinkedListVector test:");
        LinkedListVector<String> listBefore = new LinkedListVector<>();
        listBefore.addItem("Sergey");
        listBefore.addItem("Kirill");
        listBefore.addItem("Ilya");
        listBefore.addItem("Vlad");
        serialize(listBefore, "LinkedListVector.ser");
        LinkedListVector<?> listAfter = (LinkedListVector<?>) deserialize("LinkedListVector.ser");

        System.out.println("Comparison listBefore and listAfter: " + listBefore.equals(listAfter));

        if (!listBefore.removeItem("Sergey")) {
            System.out.println("Error");
        }
        System.out.println("Comparison modified listBefore and listAfter: " + listBefore.equals(listAfter));
        System.out.println("************************************************************");

        // ArrayVector.
        System.out.println("ArrayVector test:");
        Double[] arr = {12.2, 12d, 64.2};
        ArrayVector<Double> arrayBefore = new ArrayVector<>();
        arrayBefore.setArray(arr);
        serialize(arrayBefore, "ArrayVector.ser");
        ArrayVector<?> arrayAfter = (ArrayVector<?>) deserialize("ArrayVector.ser");
        System.out.println("Comparison arrayBefore and arrayAfter: " + arrayAfter.equals(arrayBefore));

        Double[] arr1 = {2d, 152.1};
        arrayBefore.setArray(arr1);
        System.out.println("Comparison new arrayBefore and arrayAfter: " + arrayAfter.equals(arrayBefore));
    }

    /**
     * Serializes Object obj with implemented Serializable interface.
     *
     * @param obj  - Object that will be serialized.
     * @param name - path for file.
     */
    public static void serialize(Object obj, String name) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes Object obj with implemented Serializable interface.
     *
     * @param name - path for file.
     * @return Object is deserialized from name.
     */
    public static Object deserialize(String name) {
        Object res = null;
        try {
            FileInputStream fileIn = new FileInputStream(name);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            res = in.readObject();
            System.out.println("Serialized data is read from " + name);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}

