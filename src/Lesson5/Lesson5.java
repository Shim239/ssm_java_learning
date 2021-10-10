/*

В массиве из 20 объектов, содержащих и юриков, и физиков вывести всех клиентов-физиков одного пола, отсортированных по году рождения

by SmirnovSM
on 30.09.2021

ver 1.0

 */


package Lesson5;

public class Lesson5 {

    public static void main(String[] args) {

        EntityGenerator[] entityGenerator = new EntityGenerator[1];
        entityGenerator[0] = new EntityGenerator();
        entityGenerator[0].generateCustomer(1);

        System.out.println(entityGenerator[0].toString());

    }
}


/*

        int individualMaleCount = 0;
        int arrayCount = 20;


        // заполняем массив объектов класса Customer
        Customer[] customers = new Customer[arrayCount];





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



*/
