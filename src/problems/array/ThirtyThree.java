package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Smallest number that can't be formed by sum of given numbers
 */
public class ThirtyThree {

    private static final int[] arr = new int[]{1, 2, 3, 6, 10, 11, 15};

    public static void main(String[] args) {
        int result = findSmallest(arr, arr.length - 1);
        System.out.println(result);
    }

    private static int findSmallest(int[] arr, int size) {
        Arrays.sort(arr);
        int res = 1; // One more than possible sum by summing up from arr[0] to arr[i]
        for (int i = 0; i <= size && res >= arr[i]; i++) {
            System.out.println(arr[i] + ", " + res);
            res += arr[i];
        }
        return res;
    }

}
