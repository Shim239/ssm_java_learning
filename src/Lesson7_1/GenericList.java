// класс дженерик с указанными методами (для каждого метода описано, что он делает)

package Lesson7_1;

import java.util.Arrays;

public class GenericList<T> {
    private int size = 0;
    private Object[] array = new Object[size];

    // метод, возвращаемый длину списка
    public int size() {
        return size;
    }

    // метод добавления элемента (если элемент уже присутствует - то он не добавляется)
    public void add(T value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals((T)array[i])) {
                return;
            }
        }
        size++;
        if (array.length < size) {
            Object[] newArray = new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, size-1);
            array = newArray;
        }
        array[size-1] = value;

    }

/*    public void add(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return;
            }
        }
        size++;
        if (array.length < size) {
            Object[] newArray = new Object[array.length + 1];
            array = Arrays.copyOf(array, size + 1);
        }

        array[size - 1] = value;
    }*/


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

    // метод выбора элемента по индексу
    public T get(int index) {
        checkArrayIndex(index);
        return (T) array[index];
    }

    // метод удаления элемента по индексу
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
