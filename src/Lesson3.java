/*

В коде зашиты две строки.
Нужно проверить, являются ли две эти строки анаграммами (регистр и пробелы не важны)

by SmirnovSM
20.09.2021

ver 1.0

 */

import java.util.Locale;

public class Lesson3 {
    public static void main(String[] args) {
        String string1 = "ав стр ал  оП итек ";
        String string2 = "вАте  рпол  ис  тКа";
        int sum1 = 0;
        int sum2 = 0;

        // приводим строки к нижнему регистру и убираем все пробелы
        string1 = string1.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        string2 = string2.toLowerCase(Locale.ROOT).replaceAll("\\s", "");

        // сравниваем длины измененных строк (может вообще дальше не нужно идти)
        if (string1.length() == string2.length()) {
            char[] charString1 = string1.toCharArray();
            char[] charString2 = string2.toCharArray();

            // у каждого char символа есть свой код (порядковый номер), если сумма кодов равна - то значит строки есть анаграммы
            for (int i = 0; i < charString1.length; i++) {
                sum1 += charString1[i];
                sum2 += charString2[i];

            }

            // проверяем контрольные суммы по двум строкам
            if (sum1 == sum2) {
                System.out.println("Буквосочетания являются анаграммами");
            }
            else {
                System.out.println("Буквосочетания не являются анаграммами");
            }

         }

        else {
            System.out.println("У строк (после удаления пробелов) разная длина, они явно не анаграммы!");
        }
    }
}
