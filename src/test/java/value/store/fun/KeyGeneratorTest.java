package value.store.fun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyGeneratorTest {

    private final KeyGenerator keyGenerator = new KeyGenerator();

    @Test
    void generateKey_shouldGenerateRandomKeys() {
        String key1 = keyGenerator.generateKey();
        String key2 = keyGenerator.generateKey();

        assertNotEquals(key1, key2);
    }
}