package Lesson5;

import java.util.Random;

public enum CustomerGender {
    MALE,
    FEMALE;

    // выбор случайного значения из ENUM
    public static CustomerGender createIndGender() {
        CustomerGender[] customerGenders = CustomerGender.values();
        int length = customerGenders.length;
        int randIndex = new Random().nextInt(length);
        return customerGenders[randIndex];
    }
}
