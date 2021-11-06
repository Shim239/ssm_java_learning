/*
Интерфейс генерации клиентов, содержащий в себе
метод generateCustomer класса Customer для генерации клиентов

интерфейс реализуется двумя классами - IndividualGenerator, EntityGenerator
 */

package Lesson8;

public interface CustomerGenerator {
    Customer generateCustomer();
}
