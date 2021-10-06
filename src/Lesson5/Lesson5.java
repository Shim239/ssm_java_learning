/*

В массиве из 20 объектов, содержащих и юриков, и физиков вывести всех клиентов-физиков одного пола, отсортированных по году рождения

by SmirnovSM
on 30.09.2021

ver 1.0

 */


package Lesson5;

public class Lesson5 {

    public static void main(String[] args) {

        int individualMaleCount = 0;

        // заполняем массив объектов класса Customer
        Customer[] customers = {
        new Individual(1, "Ivan", "913039192974", 1991, "m"),
        new Entity(2, "OOO Romashka", "5038165441", "2414282408538"),
        new Individual(3, "Andrew", "086149883480", 1975, "m"),
        new Entity(4, "OOO Assol", "1538920720", "0534354163178"),
        new Individual(5, "Maxim", "833372864590", 1984, "m"),
        new Entity(6, "OOO Parus", "6023030411", "3774067446040"),
        new Individual(7, "Denis", "734406718503", 2001, "m"),
        new Entity(8, "OOO Concert", "4691130451", "1817932185751"),
        new Individual(9, "Sonya", "023968109781", 2000, "f"),
        new Entity(10, "OOO Med", "6016732508", "1499187442192"),
        new Individual(11, "Liza", "316599049616", 1985, "f"),
        new Entity(12, "OOO Triksa", "7234152153", "0675772693761"),
        new Individual(13, "Anastasia", "237745222775", 1996, "f"),
        new Entity(14, "OOO Dom", "1413877780", "0111061099820"),
        new Individual(15, "Diana", "482051855218", 1998, "f"),
        new Entity(16, "OOO Zamok", "0656618256", "0690452489870"),
        new Individual(17, "Irina", "323272930376", 1948, "f"),
        new Entity(18, "OOO Tsvetok", "3491435623", "2790491988559"),
        new Individual(19, "Oleg", "526187709390", 1980, "m"),
        new Entity(20, "OOO Kubik", "9181714586", "0516714466301")
        };

        // узнаем количество ФЛ мужчин в первоначальном массиве
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] instanceof Individual) {
                if (((Individual) customers[i]).getGender().equals("m"))
                individualMaleCount++;
            }
        }
        System.out.println("Количество ФЛ мужчин: " + individualMaleCount + '\n');

        // делаем массив только для ФЛ мужчин типа Individual (потому что там годы рождения)
        Individual[] individualCustomers = new Individual[individualMaleCount];

        // добавляем в массив только ФЛ мужчин
        int x = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] instanceof Individual) {
                if (((Individual) customers[i]).getGender().equals("m")) {
                    individualCustomers[x] = (Individual) customers[i];
                    x++;
                }
            }
        }

        Individual tempIndividualCustomers;
        // сортировка клиентов ФЛ по году рождения
        for (int i = 0; i < individualMaleCount; i++) {
            for (int j = 0; j <individualMaleCount ; j++) {
                if (individualCustomers[i].getBirthYear() < individualCustomers[j].getBirthYear()) {
                    tempIndividualCustomers = individualCustomers[i];
                    individualCustomers[i] = individualCustomers[j];
                    individualCustomers[j] = tempIndividualCustomers;
                }

            }

        }
        // вывод окончательного результата
        for (int i = 0; i < individualMaleCount; i++) {
            System.out.println(individualCustomers[i]);
        }



    }

}
