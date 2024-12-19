package value.store.fun;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class KeySecretStoreTest {
    KeySecretStore keySecretStore = new KeySecretStore();
    String secretValue = "My secret no one should know!";
    String secretKey = "mY-cUsTom-kEy";

    @Test
    void testValueStorage() {
        //given
        //when
        String result = keySecretStore.storeValue(secretKey, secretValue);

        //then
        assertEquals(secretKey, result);
    }

    @Test
    void shouldRetrieveValueWithCaseInsensitiveKey() {
        keySecretStore.storeValue(secretKey, secretValue);

        //when
        Optional<String> result1 = keySecretStore.retrieve(secretKey);
        Optional<String> result2 = keySecretStore.retrieve(secretKey.toLowerCase());
        Optional<String> result3 = keySecretStore.retrieve(secretKey.toUpperCase());

        assertEquals(secretValue, result1.get());
        assertEquals(secretValue, result2.get());
        assertEquals(secretValue, result3.get());
    }

    @Test
    void store_shouldThrowExceptionDueToTooLongKey() {
        String tooLongKey = "1234567890123456789012345";
        assertThrows(IllegalArgumentException.class,
                () -> keySecretStore.storeValue(tooLongKey, secretValue)
        );
    }

    @Test
    void store_shouldThrowExceptionDueToNullKey() {
        String nullKey = null;
        assertThrows(IllegalArgumentException.class,
                () -> keySecretStore.storeValue(nullKey, secretValue)
        );
    }

    @Test
    void retrieve_whenGivenNullKey_shouldThrowException() {
        String String = null;
        assertThrows(IllegalArgumentException.class,
                () -> keySecretStore.retrieve(String)
        );
    }

    @Test
    void retrieve_whenGivenNullIntegerKey_shouldThrowException() {
        Integer key = null;
        assertThrows(IllegalArgumentException.class,
                () -> keySecretStore.retrieve(key)
        );
    }


    @Test
    void store_whenStoringNullValue_thenWhat() {
        String nullValue = null;
        assertThrows(IllegalArgumentException.class,
                () -> keySecretStore.storeValue(secretKey, nullValue)
        );
    }
}