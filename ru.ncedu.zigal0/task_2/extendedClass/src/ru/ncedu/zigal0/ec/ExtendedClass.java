package ru.ncedu.zigal0.ec;

import java.util.Objects;

/**
 * The ExtendedClass class represents storage for an object of type such as Byte, Int, Double, String.
 * @param <T> - the type of elements maintained by this ExtendedClass
 */
public class ExtendedClass<T> {
    private final T object;

    public ExtendedClass(T object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtendedClass<?> that = (ExtendedClass<?>) o;
        return Objects.equals(getObject(), that.getObject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObject());
    }

    @Override
    public String toString() {
        return "ExtendedClass{" +
                "object=" + object +
                '}';
    }

    public T getObject() {
        return object;
    }
}
