/*
генератор для создания клиентов типа ФЛ
содержит в себе основной метод генерации и методы генерации параметров клиента по отдельности
*/

package Lesson5;

import java.util.Random;

public class IndividualGenerator implements CustomerGenerator {

    // блок генерации клиентов по данным
    @Override
    public Customer generateCustomer() {
        Individual individual = new Individual();
        individual.setId(createIndId());
        individual.setFio(createIndFio());
        individual.setInn(createIndInn());
        individual.setBirthYear(createIndBirthYear());
        individual.setGender(CustomerGender.createIndGender());
        return individual;
    }

    // блок генерации данных
    public int createIndId() {
        Random random = new Random();
        return Math.abs(random.nextInt());
    }

    public String createIndFio() {
        Random random = new Random();
        int num = random.nextInt((500 - 1) + 1) + 1;
        return "Casual Customer " + num;
    }

    public String createIndInn() {
        int leftLimit = 48; // number '0'
        int rightLimit = 57; // number '9'
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

    public int createIndBirthYear() {
        Random random = new Random();
        int BirthYear = random.nextInt((2007 - 1920) + 1) + 1920;
        return BirthYear;
    }
}