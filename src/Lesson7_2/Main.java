/*

ДЗ 7.2
Написать класс, который позволял бы хранить "словарь" - набор пар "ключ-значение". При этом ключ и значение могут быть любых типов.
Класс должен позволять

Добавить новую пару. Если ключ уже содержится в коллекции, то соответствующее значение заменяется на новое
получать значение по ключу. Если ключа в коллекции нет, то возвращать null
удалять пару, передав ключ. Если ключа не содержится, то ничего не делать

 */

/*

ver 1.0
on 2x.10.2021
by Smirnov SM

 */

package Lesson7_2;

public class Main {
    public static void main(String[] args) {

        Dictionary<Integer, String> dictionaryString = new Dictionary<>();
        System.out.println("Словарь (цифра - строка)");
        dictionaryString.add(1, "qwerty");
        dictionaryString.add(4, "test");
        dictionaryString.add(9, "zzz");
        dictionaryString.add(3, "trial");
        dictionaryString.add(0, "sport");
        dictionaryString.add(4, "changed"); // замена значения по ключу 4
        System.out.println(dictionaryString);
        System.out.println();

        dictionaryString.remove(3);
        dictionaryString.remove(2);
        dictionaryString.remove(0);
        dictionaryString.remove(8);
        System.out.println("Выводим словарь после удаления элементов:");
        System.out.println(dictionaryString);


        System.out.println();
        System.out.println("Выводим пары по ключу:");
        System.out.println(dictionaryString.get(9));
        System.out.println(dictionaryString.get(1));
        System.out.println(dictionaryString.get(4));
        System.out.println();
        System.out.println("Выводим пару по отсутствующему в списке ключу:");
        System.out.println(dictionaryString.get(5));


        System.out.println("\n--------------------------------------------------\n");



        Dictionary<Integer, Integer> dictionary = new Dictionary<>();
        System.out.println("Словарь (цифра - цифра):");
        dictionary.add(1, 1);
        dictionary.add(8, 2);
        dictionary.add(3, 4);
        dictionary.add(3, 9); // замена значения по ключу 3
        dictionary.add(3, 7); // замена значения по ключу 3
        dictionary.add(7, 1);
        dictionary.add(7, 5); // замена значения по ключу 7
        System.out.println(dictionary);

        System.out.println();
        System.out.println("Выводим пары по ключу:");
        System.out.println(dictionary.get(1));
        System.out.println(dictionary.get(8));
        System.out.println();
        System.out.println("Выводим пару по отсутствующему в списке ключу:");
        System.out.println(dictionary.get(5));
        System.out.println(dictionary.get(10));


    }
}
