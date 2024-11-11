package aston.intensiv;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        Comparator<Integer> cmp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(8);
        arrayList.add(7);
        arrayList.add(3);
        System.out.println(Arrays.toString(arrayList.toArray()));
        arrayList.quickSort(arrayList.toArray(),0,arrayList.size());
        System.out.println(Arrays.toString(arrayList.toArray()));

    }
}