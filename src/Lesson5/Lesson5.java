/*

В массиве из 20 объектов, содержащих и юриков, и физиков вывести всех клиентов-физиков одного пола, отсортированных по году рождения
При этом массив должен быть сгенерирован рандомно генераторами соотв-х типов клиентов

by SmirnovSM
on 12.10.2021

ver 2.0

 */

package Lesson5;

import java.util.Arrays;
import java.util.Random;

public class Lesson5 {

    public static void main(String[] args) {

        // объявляем требуемые переменные
        int individualMaleCount = 0;
        int arrayCount = 20;

        System.out.println("Изначальный массив (для наглядности):");

        // генерируем массив из случайных клиентов
        CustomerGenerator entityGeneration = new EntityGenerator();
        CustomerGenerator individualGeneration = new IndividualGenerator();

        Customer[] customer = new Customer[arrayCount];
        Random random = new Random();
        for (int i = 0; i < arrayCount; i++) {
            customer[i] = random.nextBoolean() ? entityGeneration.generateCustomer() : individualGeneration.generateCustomer();
            System.out.println(customer[i]);
        }

        System.out.println();

        // узнаем количество ФЛ мужчин в первоначальном массиве
        for (int i = 0; i < customer.length; i++) {
            if (customer[i] instanceof Individual) {
                if (((Individual) customer[i]).getGender().equals(CustomerGender.MALE)) {
                    individualMaleCount++;
                }
            }
        }

        if (individualMaleCount != 0) {
            System.out.println("Количество ФЛ мужчин: " + individualMaleCount + '\n' + '\n');

            // делаем массив только для ФЛ мужчин типа Individual (потому что там годы рождения)
            Individual[] individualCustomers = new Individual[individualMaleCount];

            // добавляем в массив только ФЛ мужчин
            int x = 0;
            for (int i = 0; i < customer.length; i++) {
                if (customer[i] instanceof Individual) {
                    if (((Individual) customer[i]).getGender().equals(CustomerGender.MALE)) {
                        individualCustomers[x] = (Individual) customer[i];
                        x++;
                    }
                }
            }

            // сортировка массива по году рождения вверх (смотри Individual.java компаратор)
            Arrays.sort(individualCustomers);

            // вывод окончательного результата (только ФЛ с сортировкой по году рождения вверх)
            System.out.println("Вывод только мужчин с сортировкой по году рождения снизу вверх:");
            for (int i = 0; i < individualMaleCount; i++) {
                System.out.println(individualCustomers[i]);
            }
        }
        else {
            System.out.println("В массиве отсутствуют клиенты мужского пола!");
        }

    }
}