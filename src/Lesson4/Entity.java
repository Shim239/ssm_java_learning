// класс описания общих полей ЮЛ + геттеры, сеттеры + конструктор

package Lesson4;

public class Entity extends Customer{
    private String ogrn;

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public Entity(int id, String name, String inn, String ogrn) {
        super(id, name, inn);
        this.ogrn = ogrn;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "ogrn='" + ogrn + '\'' +
                '}';
    }
}
