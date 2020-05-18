package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : 2 elements whose sum is close to zero - either positive or negative
 */

class Twelve {
    static int[] arr = new int[]{-5, -2, 1, 2, 6, 9};

    public static void main(String[] args) {
        findSumNearZero(arr, 0, arr.length - 1);
    }

    static void findSumNearZero(int[] arr, int left, int right) {
        // Arrays.sort internally uses dual-pivot quick sort for primitive data types
        // and MergeSort for iterative objects.
        Arrays.sort(arr);
        int sum, closestSum = Integer.MAX_VALUE;
        int minLeft = left, minRight = right;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                minLeft = left;
                minRight = right;
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}