package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Smallest number that can't be formed from the array of given numbers
 */
public class ThirtyThree {

    private static int[] arr = new int[]{1, 3, 6, 10, 11, 15};

    public static void main(String[] args) {
        int result = findSmallest(arr, arr.length - 1);
        System.out.println(result);
    }

    private static int findSmallest(int[] arr, int size) {
        Arrays.sort(arr);
        int res = 1;
        for (int i = 0; i <= size && arr[i] <= res; i++) {
            res += arr[i];
        }
        return res;
    }

}
