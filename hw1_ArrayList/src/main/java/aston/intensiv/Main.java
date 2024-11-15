package aston.intensiv;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(8);
        arrayList.add(7);
        arrayList.add(3);
        System.out.println(Arrays.toString(arrayList.toArray()));
        arrayList.add(6, 500);
        //arrayList.quickSort();
        System.out.println(Arrays.toString(arrayList.toArray()));


    }
}