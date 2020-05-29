package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Next least greater number to the given number, input as digit array - with same digits
 */
public class Thirty {
    private static int[] arr = new int[]{2, 1, 8, 7, 6, 5};

    public static void main(String[] args) {
        findNextLeast(arr, arr.length - 1);
    }

    private static void findNextLeast(int[] arr, int size) {
        int i, j;
        for (i = size - 1; i >= 0; i--) {
            if (arr[i] > arr[i - 1])
                break;
        }
        if (i == 0) {
            return;
        }
        int x = arr[i - 1], smallest = i;
        for (j = i + 1; j <= size; j++) {
            if (arr[j] > x && arr[j] < arr[smallest])
                smallest = j;
        }
        swap(arr, i - 1, smallest);
        Arrays.sort(arr, i, size + 1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
