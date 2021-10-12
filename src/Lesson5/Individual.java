/*
класс описания дополнительных полей ФЛ + геттеры, сеттеры + toString + компаратор
 */

package Lesson5;

import java.util.Comparator;

public class Individual extends Customer implements Comparable<Individual> {
    private int birthYear; // год рождения ФЛ
    private CustomerGender gender; // пол ФЛ
    private String fio; // name
    private String inn;

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public CustomerGender getGender() {
        return gender;
    }

    public void setGender(CustomerGender gender) {
        this.gender = gender;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Клиент ФЛ: " +
                "id=" + getId() + '\'' +
                ", ФИО='" + fio + '\'' +
                ", ИНН='" + inn + '\'' +
                ", ГОД РОЖДЕНИЯ=" + birthYear + '\'' +
                ", ПОЛ='" + gender + '\'';
    }

    // компаратор сравнения годов рождения ФЛ
    @Override
    public int compareTo(Individual o) {
        return (this.getBirthYear() - o.getBirthYear());
    }
}
