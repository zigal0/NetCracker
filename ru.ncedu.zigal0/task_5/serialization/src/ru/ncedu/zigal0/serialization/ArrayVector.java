package ru.ncedu.zigal0.serialization;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Class ArrayVector<E> represent simplified version f E[] array with implementation of Serializable interface.
 *
 * @param <E> - the type of elements held in this collection.
 * @author zigal0.
 */
public class ArrayVector<E> implements Serializable {
    private E[] arr;

    public void setArray(E[] arr) {
        this.arr = arr;
    }

    public E[] getArray() {
        return arr;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ArrayVector)) {
            return false;
        }
        ArrayVector<?> c = (ArrayVector<?>) o;
        return Arrays.equals(this.arr, c.getArray());
    }
}
