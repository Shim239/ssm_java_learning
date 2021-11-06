/*

В массиве из 20 объектов, содержащих и юриков, и физиков вывести всех клиентов-физиков одного пола, отсортированных по году рождения
При этом массив должен быть сгенерирован рандомно генераторами соотв-х типов клиентов
с использованием коллекций

by SmirnovSM
on 06.11.2021

ver 1.0

 */

package Lesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lesson8 {

    public static void main(String[] args) {

        // объявляем требуемые переменные
        int individualMaleCount = 0;
        int listCount = 20;

        System.out.println("Изначальный массив (для наглядности):");

        // генерируем список из случайных клиентов
        CustomerGenerator entityGeneration = new EntityGenerator();
        CustomerGenerator individualGeneration = new IndividualGenerator();

        ArrayList<Customer> customer = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listCount; i++) {
            customer.add(i, random.nextBoolean() ? entityGeneration.generateCustomer() : individualGeneration.generateCustomer());
            System.out.println(customer.get(i));
        }

        System.out.println();

        // узнаем количество ФЛ мужчин в первоначальном списке
        for (int i = 0; i < listCount; i++) {
            if (customer.get(i) instanceof Individual) {
                if (((Individual) customer.get(i)).getGender().equals(CustomerGender.MALE)) {
                    individualMaleCount++;
                }
            }
        }

        if (individualMaleCount > 0) {
           System.out.println("Количество ФЛ мужчин: " + individualMaleCount + '\n');

             // делаем список только для ФЛ мужчин типа Individual (потому что там годы рождения)
            ArrayList<Individual> individualCustomers = new ArrayList<>(individualMaleCount);

            // добавляем в список только ФЛ мужчин
            int x = 0;
            for (int i = 0; i < listCount; i++) {
                if (customer.get(i) instanceof Individual) {
                    if (((Individual) customer.get(i)).getGender().equals(CustomerGender.MALE)) {
                        individualCustomers.add(x, (Individual) customer.get(i));
                        x++;
                    }
                }
            }

            // сортировка списка по году рождения вверх (смотри Individual.java - компаратор)
            Collections.sort(individualCustomers, Individual.sortBirthYear);

            // вывод окончательного результата (только ФЛ с сортировкой по году рождения вверх)
            System.out.println("Вывод только мужчин с сортировкой по году рождения снизу вверх:");
            for (int i = 0; i < individualMaleCount; i++) {
                System.out.println(individualCustomers.get(i));
            }

        }
        else {
            System.out.println("В массиве отсутствуют клиенты мужского пола!");
        }

    }
}