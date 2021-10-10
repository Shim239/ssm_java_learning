package Lesson5;

import java.util.Random;

public class EntityGenerator implements CustomerGenerator {

    // отсюда не мое
    Customer[] customersEntity = null;

    public void createEntityArray(int entityCount) {
        customersEntity = new Customer[entityCount];

        for (int i = 0; i < entityCount; i++) {
            customersEntity[i] = generateCustomer(i);
        }
    }
    // до сюда


    @Override
    public Customer generateCustomer(int id) {
        String name = createEntityName();
        String inn = createEntityInn();
        String ogrn = createEntityOgrn();
        return new Entity(id, name, inn, ogrn);
    }

    public String createEntityName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 15;
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

    public String createEntityInn() {
        int leftLimit = 0; // number '0'
        int rightLimit = 9; // number '9'
        int targetStringLength = 10;
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

    public String createEntityOgrn() {
        int leftLimit = 0; // number '0'
        int rightLimit = 9; // number '9'
        int targetStringLength = 12;
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

/*    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "inn='" + inn + '\'' +
                "ogrn='" + ogrn + '\'' +
                '}';
    }*/

}


 /*   private int createEntityId() {
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
}*/