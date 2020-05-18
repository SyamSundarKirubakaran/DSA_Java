package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Rotate Matrix by 90 degree - anti-clockwise
 */
public class ThirtyFive {

    private static int[][] arr = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    public static void main(String[] args) {
        preformRotation(arr, arr.length - 1);
    }

    private static void printArray(int[][] arr, int size) {
        for (int i = 0; i <= size; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void preformRotation(int[][] arr, int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0, k = size; j < k; j++, k--) {
                swap(arr, i, j, i, k);
            }
        }
        for (int i = 0; i <= size; i++) {
            for (int j = i + 1; j <= size; j++) {
                swap(arr, i, j, j, i);
            }
        }
        printArray(arr, arr.length - 1);
    }

    private static void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

}
