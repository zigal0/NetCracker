package ru.ncedu.zigal0.ec;

import java.util.Objects;

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
