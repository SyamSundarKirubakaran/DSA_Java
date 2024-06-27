package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Steps 1 or 2 to reach n
 */
public class O {

    public static void main(String[] args) {
        find(6);
    }

    private static void find(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
    }

}
