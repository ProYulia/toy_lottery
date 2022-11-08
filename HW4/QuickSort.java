package HW4;

public class QuickSort {

    public static void createRandom(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random()*100);
    }

    public static void arrSort(int[] array, int left, int right) {
        if (array.length == 0 || left >= right)
            return;
        int pivot = right + (left - right) / 2;
        int i = left, j = right;

        while (i <= j) {
            while (array[i] < array[pivot])
                i++;
            while (array[j] > array[pivot])
                j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) arrSort(array, left, j);
        if (right > i) arrSort(array, i, right);

    }
}
