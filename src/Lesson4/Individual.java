// класс описания дополнительных полей ФЛ + геттеры, сеттеры + конструктор

package Lesson4;

public class Individual extends Customer {
    private int birthYear; // год рождения ФЛ
    private char gender; // пол ФЛ

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Individual(int id, String name, String inn, int birthYear, char gender) {
        super(id, name, inn);
        this.birthYear = birthYear;
        this.gender = gender;
    }
}
