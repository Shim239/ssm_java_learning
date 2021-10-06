package Lesson5;

import java.util.Random;

public abstract class EntityGenerator implements CustomerUtils<Entity> {

    private int createEntityId() {
        return new Random().nextInt();
    }

    private String createEntityName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        String type = "ООО";
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    private int createEntityInn() {
        return new Random().nextInt();
    }

    private int createEntityOgrn() {
        return new Random().nextInt();
    }
}