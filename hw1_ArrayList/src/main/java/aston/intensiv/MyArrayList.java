package aston.intensiv;

import java.util.Arrays;

/**
 * Класс реализация ArrayList,
 *
 * @author Leonid Sysoev
 */
public class MyArrayList<T extends Comparable<T>> {
    private final int INIT_SIZE = 10;
    private Object[] array;
    private int currentSize;

    public MyArrayList() {
        this.array = new Object[INIT_SIZE];
    }

    /**
     * Метод для добавления элементов в лист
     * @param item новый элемент
     * @return item новый элемент
     */
    public T add(T item) {
        lengthCheck();
        nullCheck(item);
        if (currentSize == array.length) {
            arrayGrow();
        }
        array[currentSize++] = item;
        return item;
    }
    /**
     * Метод для добавления элементов в лист по индексу
     * @param item новый элемент
     * @param index индекс элемента
     * @return item новый элемент
     */
    public T add(int index, T item) {
        lengthCheck();
        nullCheck(item);
        indexCheck(index);
        if (index == currentSize) {
            array[currentSize++] = item;
        } else {
            System.arraycopy(array, index, array, currentSize + 1, currentSize - index);
        }
        return item;
    }

    /**
     * Метод для изменения элементов в листе по индексу
     * @param item новый элемент
     * @param index индекс элемента
     * @return item новый элемент
     */
    public T set(int index, T item) {
        indexCheck(index);
        nullCheck(item);
        for (int i = 0; i < currentSize; i++) {
            if (i == index) {
                array[i] = item;
            }
        }
        return item;
    }
    /**
     * Метод для поиска индекса элемента
     * @param item элемент
     * @return  индекс элемента
     */
    public int indexOf(T item) {
        for (int i = 0; i < currentSize; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Метод для определения наличия элемента
     * @param item  элемент
     * @return  индекс элемента
     */
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }
    /**
     * Метод для удаления элемента по индексу
     * @param index индекс элемента
     */
    public void remove(int index) {
        indexCheck(index);
        T item = (T) array[index];
        if (!contains(item)) {
            throw new RuntimeException();
        }
        if (index != currentSize) {
            System.arraycopy(array, index + 1, array, index, currentSize - index);
        }
        currentSize--;
    }
    /**
     * Метод для удаления элемента по элементу
     * @param item  элемент
     * @return  элемент
     */
    public T remove(T item) {
        nullCheck(item);
        int index = indexOf(item);
        if (!contains(item)) {
            throw new RuntimeException();
        }
        if (index != currentSize) {
            System.arraycopy(array, index + 1, array, index, currentSize - index);
        }
        currentSize--;
        return item;
    }
    /**
     * Метод для поиска последнего индекса элемента
     * @param item элемент
     * @return  индекс элемента
     */
    public int lastIndexOf(T item) {
        for (int i = currentSize - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Метод для получения элемента по индексу
     * @param index индекс элемента
     * @return item элемент
     */
    public T get(int index) {
        indexCheck(index);
        return (T) array[index];
    }
    /**
     * Метод для преобразования листа в массив
     * @return массив элементов
     */
    public Object[] toArray() {
        return Arrays.copyOf(array, currentSize);
    }
    /**
     * Метод для сравнения листов
     * @param otherList индекс элемента
     * @return boolean
     */
    public boolean equals(MyArrayList<T> otherList) {
        nullCheckArray(otherList);
        return Arrays.equals(this.toArray(), otherList.toArray());
    }
    /**
     * Метод для получения размера листа
          * @return currentSize размер листа
     */
    public int size() {
        return currentSize;
    }
    /**
     * Метод для проверки пуст-ли лист
     * @return boolean
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }
    /**
     * Метод для очистки листа
     */
    public void clear() {
        currentSize = 0;
    }

    private void arrayGrow() {
        int newLength = (int) (array.length * 1.5);
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void lengthCheck() {
        if (currentSize == array.length) {
            throw new RuntimeException();
        }
    }

    private void indexCheck(int index) {
        if (index < 0 || index > currentSize) {
            throw new RuntimeException();
        }
    }

    private void nullCheckArray(MyArrayList<T> array) {
        if (array == null) {
            throw new RuntimeException();
        }
    }

    private void nullCheck(T item) {
        if (item == null) {
            throw new RuntimeException();
        }
    }
    /**
     * Метод для быстрой сортировки листа
     */
    public void quickSort() {
        quickSort(array, 0, currentSize - 1);
    }


    private void quickSort(Object[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Object[] arr, int begin, int end) {
        T pivot = (T) arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (((T) arr[j]).compareTo(pivot) <= 0) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Object[] arr, int indexA, int indexB) {
        Object tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

}
