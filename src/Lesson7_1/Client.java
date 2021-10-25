package Lesson7_1;

public class Client {
    private Integer id;
    private String Fio;

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        Fio = fio;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Fio='" + Fio + '\'' +
                '}';
    }
}
