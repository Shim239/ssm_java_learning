/*

Lesson2_JavaLearning_BSPB
by Smirnov SM
on 12.09.2021

 В коде заданы параметры десяти клиентов
Программа выводит всех женщин с сортировкой по возрасту

 */

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {

        // задаем значения в массивах
        int[] age = new int[]{18,5,69,74,21,78,45,18,22,54};

        boolean [] gender = new boolean[]{true,false,false,false,true,true,false,false,true,true};

        String[] fio = new String[10];
        fio[0] = "Иванов Иван Иванович";
        fio[1] = "Сурикова Анна Игоревна";
        fio[2] = "Игнатина Лариса Ивановна";
        fio[3] = "Туманова Ольга Петровна";
        fio[4] = "Вернский Игорь Игоревич";
        fio[5] = "Сидоров Семен Игнатьевич";
        fio[6] = "Василькова Ирина Альбертовна";
        fio[7] = "Соколова Жанна Семеновна";
        fio[8] = "Бобров Захар Александрович";
        fio[9] = "Зимин Михаил Максимович ";

        System.out.println("Вывод только женщин, сортировка по возрасту!\n");

        int temp_age = 0;
        boolean temp_gender = false;
        String temp_fio = "test";

        for (int i = 0; i < age.length; i++) {
            for (int j = i+1; j < age.length; j++) {
                if (age[i] > age[j]) {
                    temp_age = age[i];
                    age[i] = age[j];
                    age[j] = temp_age;

                    temp_gender = gender[i];
                    gender[i] = gender[j];
                    gender[j] = temp_gender;

                    temp_fio = fio[i];
                    fio[i] = fio[j];
                    fio[j] = temp_fio;
                }
        }


    }
        for (int i = 0; i < age.length; i++) {
            if (!gender[i]) {
                System.out.println(fio[i] + ", " + age[i] + " лет");
            }
        }
}
}