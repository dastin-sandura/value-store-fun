package value.store.fun;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class KeySecretStore {

    public static final int MAX_KEY_LENGTH = 20;
    private final Map<CustomKey, String> dataStore = new ConcurrentHashMap<>();

    public String storeValue(KeyGenerator generator, String value) throws NullPointerException {
        return storeValue(generator.generateKey(), value);
    }

    public String storeValue(String key, String value) {
        validateKey(key);
        validateValue(value);
        validateTheStore(key);
        dataStore.put(normalizeTheKey(key), value);
        return key;
    }

    private void validateTheStore(String key) {
        if (dataStore.containsKey(normalizeTheKey(key))) {
            throw new IllegalStateException("Cannot store value for existing key. It would erase existing data.");
        }
    }

    private void validateTheStore(Integer key) {
        if (dataStore.containsKey(normalizeTheKey(key))) {
            throw new IllegalStateException("Cannot store value for existing key. It would erase existing data.");
        }
    }

    public Integer storeValue(Integer key, String value) {
        validateKey(key);
        validateValue(value);
        validateTheStore(key);
        dataStore.put(normalizeTheKey(key), value);
        return key;
    }

    private static void validateValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null, because we want to store data.");
        }
    }

    private static CustomKey<String> normalizeTheKey(String key) throws NullPointerException {
        return new CustomKey<>(key.toLowerCase());
    }

    private static CustomKey<Integer> normalizeTheKey(Integer key) throws NullPointerException {
        return new CustomKey<>(key);
    }

    public Optional<String> retrieve(String key) {
        validateKey(key);
        return Optional.ofNullable(
                dataStore.get(normalizeTheKey(key))
        );
    }

    public Optional<String> retrieve(Integer key) {
        validateKey(key);
        return Optional.ofNullable(
                dataStore.get(normalizeTheKey(key))
        );
    }

    private static void validateKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (key.length() > MAX_KEY_LENGTH) {
            throw new IllegalArgumentException("Key cannot be longer than constraint: " + MAX_KEY_LENGTH);
        }
    }

    private static void validateKey(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

}
