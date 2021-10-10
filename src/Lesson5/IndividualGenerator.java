package Lesson5;

import java.util.Random;

public class IndividualGenerator implements CustomerGenerator {

    public String createIndFio() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
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

    public String createIndInn() {
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

    public int createIndBirthYear() {
        return new Random().nextInt(2007);
    }

    public String createIndGender() {
        String gender;
        if(Math.random() > 0.5) gender  = "MALE";
        else gender = "FEMALE";
        return gender;
    }

    @Override
    public Customer generateCustomer(int id) {
        String fio = createIndFio();
        String inn = createIndInn();
        int birthYear = createIndBirthYear();
        String gender = createIndGender();
        return new Individual(id, fio, inn, birthYear, gender);
    }
}

/*    private int createIndId() {
        return new Random().nextInt();
    }

    private String createIndFio() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 14;
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

    private int createIndInn() {
        return new Random().nextInt();
    }

    private int createIndBirthYear() {
        int min = 1935;
        int max = 2007;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    private String createIndGender() {
        String[] gender = new String[]{"m", "f"};
        return gender[new Random().nextInt(1)];
    }*/

