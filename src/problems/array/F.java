package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Largest Difference such that the smaller number appears before larger number
 */

public class F {
    static int[] arr = new int[]{1, 3, 5, 6, 7, 32, 45, 67};

    public static void main(String[] args) {
        int[] diff = new int[arr.length - 1];
        constructDiffArray(arr, arr.length - 1, diff);
        System.out.println(Arrays.toString(diff));
        int result = maxSumSubArray(diff, diff.length - 1);
        System.out.println(result);
    }

    static void constructDiffArray(int[] arr, int size, int[] diff) {
        for (int i = 0; i < size; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
    }

    static int maxSumSubArray(int[] diff, int size) {
        int currentMax = diff[0];
        for (int i = 1; i <= size; i++) {
            if (diff[i - 1] > 0) {
                diff[i] += diff[i - 1];
                System.out.println(Arrays.toString(diff));
            }
            currentMax = Math.max(currentMax, diff[i]);
        }
        return currentMax;
    }

}