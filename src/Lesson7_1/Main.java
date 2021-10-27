/*

ДЗ 7.1
Написать класс, который бы позволял хранить неограниченное количество УНИКАЛЬНЫХ объектов любого типа и позволял

добавлять объект (если эквивалентный объект уже содержится в коллекции, то не добавляется)
брать объект по индексу
удалять объект по индексу
получать количество элементов в коллекции

ver 1.2
on 26.10.2021
by SmirnovSM

 */

package Lesson7_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        GenericList<Integer> ooo = new GenericList<>();
        ooo.add(1);
        ooo.add(2);
        ooo.add(3);
        ooo.remove(0);
        System.out.println(ooo);


        // играемся с массивом типа String
        System.out.println("играемся со списком типа String:");
        GenericList<String> list = new GenericList<>();
        list.add("Нулевой");
        list.add("Первый");
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");
        list.set(1, "Замена первому");
        list.add("Нулевой");
        System.out.print("Длина списка на текущий момент: ");
        System.out.println(list.size());
        System.out.println(list);
        System.out.print("Элемент списка №2 (считая с нуля): ");
        System.out.println(list.get(2));

        System.out.println();

        // играемся с массивом типа Integer
        System.out.println("играемся со списком типа Integer:");
        GenericList<Integer> list1 = new GenericList<>();
        list1.add(4);
        list1.add(3);
        list1.add(3);
        list1.add(3);
        list1.add(3);
        list1.add(3);
        list1.add(3);
        list1.add(2);
        list1.add(6);
        list1.add(7);
        list1.set(0, 9);
        list1.add(1);
        list1.remove(0);
        list1.remove(4);
        System.out.println(list1);
        System.out.print("Элемент списка №0 (считая с нуля): ");
        System.out.println(list1.get(0));

        System.out.println();

        // играемся с массивом типа Object
        System.out.println("играемся со списком типа Object:");
        GenericList<Object> objList = new GenericList<>();
        objList.add(1);
        objList.add("test");
        System.out.print("Элемент списка №1 (считая с нуля): ");
        System.out.println(objList.get(1));
        System.out.println();

        // делаем большой массив (могут сформироваться одинаковые значения, тогда ошибка)
        System.out.println("делаем большой список (могут сформироваться одинаковые значения, тогда ошибка):");
        GenericList<Integer> qwerty = new GenericList<>();
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            qwerty.add(random.nextInt((20000-100) + 1) + 100);

        }

        qwerty.add(101);
        System.out.println(qwerty);
        qwerty.remove(10);
        System.out.println(qwerty);
        System.out.print("Элемент списка №2 (считая с нуля): ");
        System.out.println(qwerty.get(2));
        System.out.print("Элемента списка №6 (считая с нуля): ");
        System.out.println(qwerty.get(6));
        System.out.print("На текущий момент длина списка: ");
        System.out.println(qwerty.size());

        System.out.println("\n");


        // делаем массив объектов своего класса
        System.out.println("делаем список объектов своего класса:");
        GenericList<Client> clientList = new GenericList<>();
        ClientGenerator clientGenerator = new ClientGenerator();
        clientList.add(clientGenerator.generateClient());
        clientList.add(clientGenerator.generateClient());
        clientList.add(clientGenerator.generateClient());
        clientList.add(clientGenerator.generateClient());

        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("Client № " +  i + ": " + " " + clientList.get(i));
        }

        clientList.add(clientGenerator.generateClient());
        clientList.remove(0);
        System.out.println();


        System.out.println();
        System.out.println("После небольшой обработки:");

        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("Client № " +  i + ": " + " " + clientList.get(i));
        }
        System.out.println();
        System.out.println(clientList.get(0));

    }
}
