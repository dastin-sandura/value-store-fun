package value.store.fun;

import java.util.Objects;

public class CustomKey <T> {
    private final T keyValue;

    public CustomKey(T keyValue) {
        this.keyValue = keyValue;
    }

    public T getKeyValue() {
        return keyValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomKey<?> customKey = (CustomKey<?>) o;

        return Objects.equals(keyValue, customKey.keyValue);
    }

    @Override
    public int hashCode() {
        return keyValue != null ? keyValue.hashCode() : 0;
    }
}
