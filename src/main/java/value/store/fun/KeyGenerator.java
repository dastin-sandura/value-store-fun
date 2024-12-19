package value.store.fun;

import java.util.Random;

public class KeyGenerator {

    private static final String PREDEFINED_SET = "abcd12345";

    public String generateKey() {
        Random random = new Random();
        int length = random.nextInt(6, 21);
        StringBuilder randomKeyBuilder = new StringBuilder();
        for (int l = 0; l < length; l++) {
            randomKeyBuilder.append(
                    PREDEFINED_SET.charAt(
                            random.nextInt(0, PREDEFINED_SET.length())
                    )
            );
        }
        return randomKeyBuilder.toString();
    }
}
