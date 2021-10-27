// класс дженерик "словарь"

// дописать метод удаления и разобраться с работой чекКод

package Lesson7_2;

import java.util.Arrays;

public class Dictionary<K, T> {

    private Object[] arrayValue = new Object[0];
    private Object[] arrayKey = new Object[0];

    private int sizeArrayValue = 0;
    private int sizeArrayKey = 0;


    // метод добавления новой пары в массивы (если ключ уже есть - то значение заменяется последним)
    public void add(K key, T value) {
        for (int i = 0; i < sizeArrayKey; i++) {
            if (key.equals(arrayKey[i])) {
                arrayValue[i] = value;
                return;
            }
        }
        sizeArrayValue++;
        sizeArrayKey++;
        if (arrayValue.length < sizeArrayKey) {
            Object[] newArrayKey = new Object[arrayKey.length + 1];
            Object[] newArrayValue = new Object[arrayValue.length + 1];
            System.arraycopy(arrayKey, 0, newArrayKey, 0, sizeArrayKey-1);
            System.arraycopy(arrayValue, 0, newArrayValue, 0, sizeArrayValue-1);
            arrayKey = newArrayKey;
            arrayValue = newArrayValue;
        }
        arrayValue[sizeArrayValue - 1] = value;
        arrayKey[sizeArrayKey - 1] = key;
    }






    // метод выбора пары по ключу (если ключа нет, то возвращается NULL)
    public K get(K key) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == (K)arrayKey[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(arrayKey[i]);
                sb.append(" -> ");
                sb.append(arrayValue[i]);
                return (K) sb.toString();
            }
        }
        return null;
    }

    // метод удаления пары по ключу (если ключа нет, то ничего не делается)
    public void remove(K key) {

        // проверка: если нет такого ключа, то ничего не делать
        for (int n = 0; n < arrayKey.length; n++) {
            if ((K)arrayKey[n] == key) {

                // удаление элемента из массива key
                int index = n;
                Object[] newArrayKey = new Object[arrayKey.length - 1];
                System.arraycopy(arrayKey, 0, newArrayKey, 0, index);
                System.arraycopy(arrayKey, index + 1, newArrayKey, index, arrayKey.length-(index + 1));
                arrayKey = newArrayKey;

                // удаление элемента из массива value
                Object[] newArrayValue = new Object[arrayValue.length - 1];
                for (int i = 0; i < arrayValue.length; i++) {
                    if (key.equals(arrayValue[i])) {
                        index = i;
                    }
                }
                System.arraycopy(arrayValue, 0, newArrayValue, 0, index);
                System.arraycopy(arrayValue, index + 1, newArrayValue, index, arrayValue.length-(index + 1));
                arrayValue = newArrayValue;

            }
        }

    }

    // красивый вывод информации в консоль
    public String toString() {
        StringBuilder sb = new StringBuilder("KEY -> VALUE\n");
        for (int i = 0; i < arrayKey.length; i++) {
            sb.append(arrayKey[i]);
            sb.append(" -> ");
            sb.append(arrayValue[i]);
            if (i != arrayKey.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
