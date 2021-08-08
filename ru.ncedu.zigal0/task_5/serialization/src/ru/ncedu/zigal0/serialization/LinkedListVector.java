package ru.ncedu.zigal0.serialization;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Class LinkedListVector<E> represent simplified version f LinkedList<E> with implementation of Serializable interface.
 *
 * @param <E> - the type of elements held in this collection.
 * @author zigal0.
 */
public class LinkedListVector<E> implements Serializable {
    private final LinkedList<E> list = new LinkedList<>();

    public void addItem(E item) {
        list.add(item);
    }

    public boolean removeItem(E item) {
        return list.remove(item);
    }

    public LinkedList<E> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LinkedListVector)) {
            return false;
        }
        LinkedListVector<?> c = (LinkedListVector<?>) o;
        return this.list.equals(c.getList());
    }
}
