package aston.intensiv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    static MyArrayList<Integer> arrayList = new MyArrayList<>();

    @BeforeEach
    void setUp() {
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(15);
    }


    @Test
    void addTest() {
        Integer[] expected = new Integer[]{5, 10, 15, 20};
        arrayList.add(20);

        assertArrayEquals(expected, arrayList.toArray());

    }

    @Test
    void addByIndexTest() {
        Integer[] expected = new Integer[]{5, 10, 15, 12};
        arrayList.add(3, 12);
        assertArrayEquals(expected, arrayList.toArray());

    }

    @Test
    void setTest() {
        Integer[] expected = new Integer[]{5, 12, 15};
        arrayList.set(1, 12);
        assertArrayEquals(expected, arrayList.toArray());

    }

    @Test
    void indexOfTest() {
        assertEquals(1, arrayList.indexOf(10));
    }

    @Test
    void containsTest() {
        assertTrue(arrayList.contains(15));
    }

    @Test
    void removeTest() {
        Integer a = 10;
        Integer[] expected = new Integer[]{5, 15};
        arrayList.remove(a);
        assertArrayEquals(expected, arrayList.toArray());

    }

    @Test
    void removeByIndexTest() {
        Integer[] expected = new Integer[]{5, 15};
        arrayList.remove(1);
        assertArrayEquals(expected, arrayList.toArray());
    }

    @Test
    void lastIndexOfTest() {
        assertEquals(2, arrayList.lastIndexOf(15));
    }

    @Test
    void getTest() {
        assertEquals(15, arrayList.get(2));
    }

    @Test
    void toArrayTest() {
        Integer[] expected = new Integer[]{5, 10, 15};
        assertArrayEquals(expected, arrayList.toArray());
    }

    @Test
    void equalsTest() {
        MyArrayList<Integer> otherList = new MyArrayList<>();
        otherList.add(5);
        otherList.add(10);
        otherList.add(15);
        assertTrue(arrayList.equals(otherList));
    }

    @Test
    void sizeTest() {
        assertEquals(3, arrayList.size());
    }

    @Test
    void isEmptyTest() {
        assertFalse(arrayList.isEmpty());

    }

    @Test
    void clearTest() {
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    void quickSortTest() {
        arrayList.add(2);
        arrayList.add(11);
        Integer[] expected = new Integer[]{2, 5, 10, 11, 15};
        arrayList.quickSort();
        assertEquals(expected[1], arrayList.get(1));
    }
}