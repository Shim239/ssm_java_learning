// класс описания общих полей ФЛ и ЮЛ + геттеры, сеттеры + конструктор

package Lesson4;

import java.util.Objects;

public class Customer {
    private int id; // ИД записи
    private String inn; // ИНН ФЛ/ЮЛ

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Customer(int id, String inn) {
        this.id = id;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "id=" + id +
                ", inn='" + inn + '\'' +
                '}';
    }

}
