package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Max coins by busting balloons
 */
public class ThirtySeven {

    private static final int[] arr = new int[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        

        getMax(arr, arr.length); // incorrect solution in explanation

        
    }

    private static void getMax(int[] A, int N) {
        int[] B = new int[N + 2];

        B[0] = 1;
        B[N + 1] = 1;

        for (int i = 1; i <= N; i++)
            B[i] = A[i - 1];

        int[][] dp = new int[N + 2][N + 2];

        for (int length = 1; length < N + 1; length++) {
            for (int left = 1; left < N - length + 2; left++) {
                int right = left + length - 1;
                for (int last = left; last < right + 1; last++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][last - 1] + B[left - 1] * B[last] * B[right + 1] + dp[last + 1][right]);
                }
            }
        }
        for (int i = 0; i < N + 2; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[1][N]);
    }

}
