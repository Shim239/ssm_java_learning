/*

В коде зашиты две строки.
Нужно проверить, являются ли две эти строки анаграммами (регистр и пробелы не важны)

by SmirnovSM
20.09.2021

ver 1.0

 */

package Lesson3;

import java.util.Arrays;
import java.util.Locale;

public class Lesson3 {
    public static void main(String[] args) {
        String string1 = "ват  ерпо лИст ка";
        String string2 = "а вСт  рал опитек";

        // приводим строки к нижнему регистру и убираем все пробелы
        string1 = string1.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        string2 = string2.toLowerCase(Locale.ROOT).replaceAll("\\s", "");

        // сравниваем длины измененных строк (может вообще дальше не нужно идти)
        if (string1.length() != string2.length()) {
            System.out.println("У строк (после удаления пробелов) разная длина, они явно не анаграммы!");
            }
        else {
            // объявляем char массивы для строк
            char[] charString1 = string1.toCharArray();
            char[] charString2 = string2.toCharArray();

            // сортируем char массивы по очереди
            for (int i = 0; i < charString1.length; i++) {
                for (int j = i + 1; j < charString1.length; j++) {
                    if (charString1[i] < charString1[j]) {
                        char temp = charString1[i];
                        charString1[i] = charString1[j];
                        charString1[j] = temp;
                    }

                }
            }
            for (int i = 0; i < charString2.length; i++) {
                for (int j = i + 1; j < charString2.length; j++) {
                    if (charString2[i] < charString2[j]) {
                        char temp = charString2[i];
                        charString2[i] = charString2[j];
                        charString2[j] = temp;
                    }

                }
            }
            // сравниваем получившиеся массивы (тут запись строки подсказала idea)
            System.out.println(Arrays.equals(charString2, charString1));

        }

    }
}
