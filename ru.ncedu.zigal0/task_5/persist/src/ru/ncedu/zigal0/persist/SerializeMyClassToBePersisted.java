package ru.ncedu.zigal0.persist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class SerializeMyClassToBePersisted represents initialization of MyClassToBePersisted and serialization of this class into myClassToBePersisted.ser.
 *
 * @author zigal0
 */
public class SerializeMyClassToBePersisted {

    public static void main(String[] args) {
        MyClassToBePersisted myClassToBePersisted = new MyClassToBePersisted();
        myClassToBePersisted.setGroup(712);
        myClassToBePersisted.setProfile("Robert Poll");
        System.out.println("Before serialization: " + myClassToBePersisted);
        serialize(myClassToBePersisted);
    }

    /**
     * Serializes Class MyClassToBePersisted.
     *
     * @param myClassToBePersisted - object of MyClassToBePersisted.
     */
    public static void serialize(MyClassToBePersisted myClassToBePersisted) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("myClassToBePersisted.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myClassToBePersisted);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in myClassToBePersisted.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
