import java.util.Arrays;

//Реализовать алгоритм пирамидальной сортировки (HeapSort)
public class heapsort {
    public static void main(String[] args) {
        int[] nums = {6, 7, 2, 5, 8, 1};
        System.out.println(Arrays.toString(nums));
        int size = nums.length;
        findParent(nums, size);
        System.out.println(Arrays.toString(nums));
   
    }

    static int[] findParent(int[] array, int size) {
        if (size == 1) return array;
        if (size == 2) {
            if (array[0] > array[1])
                swapElements(array, 0, 1);
            return array;
        }

        for (int i = size/2 - 1; i >= 0; i--) {
            int left = i*2 + 1;
            int right = i*2 + 2;

            if (left < size && array[left] > array[i])
                swapElements(array, left, i);

            if (right < size && array[right] > array[i])
                swapElements(array, i, right);
        }
        swapElements(array, 0, --size);
        return findParent(array, size);
    }

    static void swapElements(int[] array, int min, int max) {
        int temp = array[min];
        array[min] = array[max];
        array[max] = temp;
    }
}
