package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Find n-bit integer that doesn't have 2 consecutive zeros
 */
public class K {

    public static void main(String[] args) {
        find(4);
    }

    private static void find(int n) {
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        temp1[0] = 1;
        temp2[0] = 1;
        for (int i = 1; i < n; i++) {
            temp1[i] = temp1[i - 1] + temp2[i - 1];
            temp2[i] = temp1[i - 1];
            System.out.println("temp1: " + Arrays.toString(temp1));
            System.out.println("temp2: " + Arrays.toString(temp2));
            System.out.println();
        }
        System.out.println(temp1[n - 1] + temp2[n - 1]);
    }

}
