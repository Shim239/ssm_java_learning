// класс описания общих полей ФЛ и ЮЛ + геттеры, сеттеры + конструктор

package Lesson4;

public class Customer {
    private int id; // ИД записи
    private String name; // Название компании / ФИО клиента
    private String inn; // ИНН ФЛ/ЮЛ

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Customer(int id, String name, String inn) {
        this.id = id;
        this.name = name;
        this.inn = inn;
    }
}
