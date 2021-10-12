/*
класс описания дополнительных полей ЮЛ + геттеры, сеттеры + toString
 */

package Lesson5;

public class Entity extends Customer {
    private String ogrn;
    private String name;
    private String inn;

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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Клиент ЮЛ: " +
                "id=" + getId() + '\'' +
                ", НАИМЕНОВАНИЕ='" + name + '\'' +
                ", ИНН='" + inn + '\'' +
                "ОГРН='" + ogrn + '\'';
    }
}