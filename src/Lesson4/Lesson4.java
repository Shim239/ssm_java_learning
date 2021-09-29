/*

В массиве из 20 объектов, содержащих и юриков, и физиков вывести всех клиентов-физиков одного пола, отсортированных по году рождения

by SmirnovSM
on хх.09.2021

ver 1.0

 */


package Lesson4;

import java.util.Arrays;

public class Lesson4 {

    public static void main(String[] args) {

        int individualCount = 0;

        // заполняем массив объектов класса Customer
        Customer[] customers = {
        new Individual (1, "Ivan", "913039192974", 1991, 'm'),
        new Entity(2, "OOO Romashka", "5038165441", "2414282408538"),
        new Individual(3, "Andrew", "086149883480", 1975, 'm'),
        new Entity(4, "OOO Assol", "1538920720", "0534354163178"),
        new Individual(5, "Maxim", "833372864590", 1984, 'm'),
        new Entity(6, "OOO Parus", "6023030411", "3774067446040"),
        new Individual(7, "Denis", "734406718503", 2001, 'm'),
        new Entity(8, "OOO Concert", "4691130451", "1817932185751"),
        new Individual(9, "Sonya", "023968109781", 2000, 'f'),
        new Entity(10, "OOO Med", "6016732508", "1499187442192"),
        new Individual(11, "Liza", "316599049616", 1985, 'f'),
        new Entity(12, "OOO Triksa", "7234152153", "0675772693761"),
        new Individual(13, "Anastasia", "237745222775", 1996, 'f'),
        new Entity(14, "OOO Dom", "1413877780", "0111061099820"),
        new Individual(15, "Diana", "482051855218", 1998, 'f'),
        new Entity(16, "OOO Zamok", "0656618256", "0690452489870"),
        new Individual(17, "Irina", "323272930376", 1948, 'f'),
        new Entity(18, "OOO Tsvetok", "3491435623", "2790491988559"),
        new Individual(19, "Maria", "526187709390", 1980, 'f'),
        new Entity(20, "OOO Kubik", "9181714586", "0516714466301")
        };

        // узнаем количество ФЛ в первоначальном массиве
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] instanceof Individual) {
                individualCount++;
            }
        }
        System.out.println("Количество ФЛ: " + individualCount);

        // объявляем массив с длиной, высчитанной из первоначального массива по количеству ФЛ
        Customer[] individualCustomers = new Customer[individualCount];

        // заполняем новый массив только ФЛ данными
        int x = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] instanceof Individual) {
                individualCustomers[x] = customers[i];
                x++;
                //System.out.println(individualCustomers[x].toString());
            }
        }


    }

}
