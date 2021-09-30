// класс описания дополнительных полей ЮЛ + геттеры, сеттеры + конструктор

package Lesson4;

public class Entity extends Customer{
    private String ogrn;
    private String name;

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity(int id, String name, String inn, String ogrn) {
        super(id, inn);
        this.ogrn = ogrn;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "ogrn='" + ogrn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
