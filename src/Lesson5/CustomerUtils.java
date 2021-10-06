package Lesson5;

public interface CustomerUtils<I extends Customer> {
    Customer generate(int id, String inn);
}