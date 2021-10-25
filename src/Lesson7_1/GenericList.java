// класс дженерик с указанными методами (для каждого метода описано, что он делает)

package Lesson7_1;

import java.util.Arrays;

public class GenericList<T> {
    private int size;
    private Object[] array = new Object[size];

    // метод, возвращаемый длину массива
    public int size() {
        return size;
    }

    public int getSize() {
        System.out.println("В списке находится " + size + " элемента(-ов).");
        return size;
    }


    // метод получения индекса элемента массива
    public int getIndex(int index) {
        return index;
    }

    // метод добавления элемента
    public void add(T value) {
        size++;
        if (array.length < size) {
            array = Arrays.copyOf(array, size + 1);
        }
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                throw new IllegalArgumentException("Exception! This value is already exists in this list!");
            }
        }
        array[size - 1] = value;
    }

    // метод замены элемента по индексу
    public void set(int index, T value) {
        try {
            checkArrayIndex(index);
            array[index] = value;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("You are trying to add an item with an index: " + index + "\n\n");
        }

    }

    // метод вывода в консоль элемента по номеру его индекса
    public T output(int index) {
        try {
            checkArrayIndex(index);
            System.out.println("Элемент списка № " + (index + 1) + ": " + array[index]);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("You are trying to " +
                    "output in console an item with an index: " + index + "\n\n");
        }
        return (T) array[index];
    }

    // метод удаления элемента по его индексу (АВТОРСКИЙ)
    public void remove(int index) {
        int removedIndex = index;
        if (array == null || removedIndex < 0 || removedIndex >= array.length) {
            System.out.println("No removal operation can be performed!!");
        }
        Object[] newArray = new Object[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == removedIndex) {
                continue;
            }
            newArray[k++] = array[i];
        }
        array = newArray;
        size--;
    }

    // метод проверки существования индекса в списке, если нет - то ошибка
    private void checkArrayIndex (int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Exception! Invalid index of array!\n" + "Array size: " + size);
        }
    }


    // метод toString скопирован с лекции для первого потока, дабы в процессе работы смотреть что я делаю не так
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
