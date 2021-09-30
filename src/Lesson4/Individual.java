// класс описания дополнительных полей ФЛ + геттеры, сеттеры + конструктор

package Lesson4;

public class Individual extends Customer {
    private int birthYear; // год рождения ФЛ
    private String gender; // пол ФЛ
    private String fio; // name

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Individual(int id, String fio, String inn, int birthYear, String gender) {
        super(id, inn);
        this.fio = fio;
        this.birthYear = birthYear;
        this.gender = gender;

    }

    @Override
    public String toString() {
        return "ФЛ: " +
                "Имя= " + fio +
                ", год рождения= " + birthYear +
                ", пол= " + gender;
    }

}
