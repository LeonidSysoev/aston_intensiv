package aston.intensiv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T> {
    private final int INIT_SIZE = 10;
    private Object[] array;
    private int currentSize;

    public MyArrayList() {
        this.array = new Object[INIT_SIZE];
    }

    public T add(T item) {
        lengthCheck();
        nullCheck(item);
        if (currentSize == array.length) {
            arrayGrow();
        }
        array[currentSize++] = item;
        return item;
    }

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

    public int indexOf(T item) {
        for (int i = 0; i < currentSize; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {

        return indexOf(item) != -1;
    }

    public T remove(int index) {
        indexCheck(index);
        T item = (T) array[index];
        if (!contains(item)) {
            throw new RuntimeException();
        }
        if (index != currentSize) {
            System.arraycopy(array, index + 1, array, index, currentSize - index);
        }
        currentSize--;
        return item;
    }

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

    public int lastIndexOf(T item) {
        for (int i = currentSize - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        indexCheck(index);
        return (T) array[index];
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, currentSize);
    }

    public boolean equals(MyArrayList<T> otherList) {
        nullCheckArray(otherList);
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

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

    public void quickSort(T [] arr, int begin, int end, Comparator<T> comparator) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, comparator);

            quickSort(arr, begin, partitionIndex - 1, comparator);
            quickSort(arr, partitionIndex + 1, end, comparator);
        }
    }

    private int partition(T[] arr, int begin, int end, Comparator<T> comparator) {
        T pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    public static void swapElements(Object[] arr, int indexA, int indexB) {
        Object tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
