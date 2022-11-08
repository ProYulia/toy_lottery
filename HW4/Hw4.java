package HW4;

import java.util.Arrays;

public class Hw4 {
    public static void main(String[] args) {

        int[] myArray = new int[10];
        QuickSort.createRandom(myArray);
        System.out.println(Arrays.toString(myArray));

        QuickSort.arrSort(myArray, 0, 9);
        System.out.println(Arrays.toString(myArray));

    }
}

