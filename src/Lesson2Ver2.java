/*

Lesson2_JavaLearning_BSPB
by Smirnov SM
on 15.09.2021

В коде заданы параметры десяти клиентов
Программа выводит всех женщин с сортировкой по возрасту

ver2 с двумерными массивами

 */


import java.util.Arrays;

public class Lesson2Ver2 {
    public static void main(String[] args) {
        String[][] clients = new String[][] {
                {"25", "Ivan", "male"},
                {"16", "Lilia", "female"},
                {"33", "Felicia", "female"},
                {"18", "Andrew", "male"},
                {"34", "Isabelle", "female"},
                {"62", "Agatha", "female"},
                {"47", "Crispin", "male"},
                {"48", "Piers", "male"},
                {"48", "Nora", "female"},
                {"48", "Ada", "female"}
        };

        // отделяем от двумерного массива возраста в отдельный массив
        String[] age = new String[clients.length];

        for (int i = 0; i < clients.length; i++) {
            age[i] = clients[i][0];
        }

        // переводим массив возрастов в int для возможности сравнения <, >
        int[] intAge = Arrays.asList(age).stream().mapToInt(Integer::parseInt).toArray(); // это нагугленая строчка


        // объявляем переменные для сравнения элементов массива
        int tempAge;
        String[] tempGender = new String[clients.length];
        String[] tempClients = new String[clients.length];

        // ставим элементы массива по возрастанию
        for (int i = 0; i < clients.length; i++) {
            for (int j = i+1; j < clients.length; j++) {
                if (intAge[i] > intAge[j]) {
                    tempAge = intAge[i]; // здесь работаем с int массивом возрастов
                    intAge[i] = intAge[j];
                    intAge[j] = tempAge;

                    tempClients[i] = clients[i][1]; // здесь меняем местами данные в строках двумерного массива
                    clients[i][1] = clients[j][1];
                    clients[j][1] = tempClients[i];

                    tempGender[i] = clients[i][2]; // здесь меняем местами данные в строках двумерного массива
                    clients[i][2] = clients[j][2];
                    clients[j][2] = tempGender[i];

                }
            }
        }

        System.out.println();
        System.out.println("Выводим только женщин с сортировкой по возрасту!\n");

        for (int i = 0; i < clients.length; i++) {
            if (clients[i][2] == "female") {
                System.out.println(clients[i][1] + ", age: " + intAge[i]);
            }


        }

    }
}