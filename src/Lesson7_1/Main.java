/*

ДЗ 7.1
Написать класс, который бы позволял хранить неограниченное количество УНИКАЛЬНЫХ объектов любого типа и позволял

добавлять объект (если эквивалентный объект уже содержится в коллекции, то не добавляется)
брать объект по индексу
удалять объект по индексу
получать количество элементов в коллекции

ver 1.0
on 2x.10.2021
by SmirnovSM

 */

/* Текущие проблемы:
??++1. Не работает метод remove
2. Подключить свой класс
++3. Обернуть exceptions

 */
package Lesson7_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // играемся с массивом типа String
        System.out.println("играемся с массивом типа String:");
        GenericList<String> list = new GenericList<>();
        list.add("Нулевой");
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");
        list.set(1, "Замена первому");
        list.getSize();
        System.out.println(list);
        list.output(2);

        System.out.println();

        // играемся с массивом типа Integer
        System.out.println("играемся с массивом типа Integer:");
        GenericList<Integer> list1 = new GenericList<>();
        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(6);
        list1.add(7);
        list1.set(0, 9);
        list1.add(1);
        list1.remove(0);
        list1.remove(4);
        System.out.println(list1);
        list1.output (0);

        System.out.println();

        // делаем большой массив (могут сформироваться одинаковые значения, тогда ошибка)
        System.out.println("делаем большой массив (могут сформироваться одинаковые значения, тогда ошибка):");
        GenericList<Integer> qwerty = new GenericList<>();
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            qwerty.add(random.nextInt((20000-100) + 1) + 100);

        }

        qwerty.add(101);
        System.out.println(qwerty);
        qwerty.remove(10);
        System.out.println(qwerty);
        qwerty.output(0);
        qwerty.output(6);
        qwerty.getSize();

        System.out.println("\n\n");


        // делаем массив объектов своего класса
        System.out.println("делаем массив объектов своего класса:");
        GenericList<Client> clientList = new GenericList<>();
        ClientGenerator clientGenerator = new ClientGenerator();
        clientList.add(clientGenerator.generateClient());
        clientList.add(clientGenerator.generateClient());
        clientList.add(clientGenerator.generateClient());
        clientList.add(clientGenerator.generateClient());

        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("Client № " +  clientList.getIndex(i) + ": " + " " + clientList.get(i));
        }

        clientList.add(clientGenerator.generateClient());
        clientList.remove(0);
        System.out.println();


        System.out.println();
        System.out.println("После небольшой обработки:");

        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("Client № " +  clientList.getIndex(i) + ": " + " " + clientList.get(i));
        }
        System.out.println();
        clientList.output(0);

    }
}
