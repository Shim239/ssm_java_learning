/*

В коде зашиты две строки.
Нужно проверить (вывести true или false), являются ли две эти строки анаграммами (регистр и пробелы не важны)

by SmirnovSM
17.09.2021

ver 1.0

 */

import java.util.Locale;

public class Lesson3 {
    public static void main(String[] args) {
        String string1 = "Я в мире - сирота";
        String string2 = "Я в Риме - Ариост";
        String string3 = "";

        // приводим строки к нижнему регистру и убираем все пробелы
        string1 = string1.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        string2 = string2.toLowerCase(Locale.ROOT).replaceAll("\\s", "");

        //сравниваем длины измененных строк (может вообще дальше не нужно идти)
        if (string1.length() == string2.length()) {

            //побуквенно перебираем строку1
            for (int i = 0; i < string1.length(); i++) {
                String letter = string1.substring(i, i + 1);

                // если в строке 2 присутствует буква из строки 1, то добавляем ее в строку 3
                    if (string2.indexOf(letter) != -1) {
                        string3 += letter;
                }

            }

        }

        // если у строк разная длина
        else {
            System.out.println("У строк (после удаления пробелов) разная длина, они явно не анаграммы!");
        }
        /* вывод строк 1 2 и 3
        System.out.println("1 = " + string1);
        System.out.println("2 = " + string2);
        System.out.println("3 = " + string3);
        */

        // вывод в консоль результата сравнения строк 1 и 3
        System.out.println(string1.equals(string3));

    }
}
