package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : No.of Non-decreasing numbers with n digits
 */
public class ThirtyFour {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        countNonDecreasing(3);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void countNonDecreasing(int n) {
        int[][] dp = new int[10][n + 1];

        for (int i = 0; i < 10; i++) {
            dp[i][1] = 1;
        }

        for (int digit = 0; digit <= 9; digit++) {
            for (int len = 2; len <= n; len++) {
                for (int x = 0; x <= digit; x++) { // didn't get this logic
                    dp[digit][len] += dp[x][len - 1];
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 10; i++) {
            count += dp[i][n];
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(count);
    }

    /*

    Count of n digit numbers = (Count of (n-1) digit numbers Ending with digit 9) +
                           (Count of (n-1) digit numbers Ending with digit 8) +
                           .............................................+
                           .............................................+
                           (Count of (n-1) digit numbers Ending with digit 0)

    Let count ending with digit ‘d’ and length n be count(n, d)
        count(n, d) = ∑(count(n-1, i)) where i varies from 0 to d
        Total count = ∑count(n-1, d) where d varies from 0 to n-1

     */

}
