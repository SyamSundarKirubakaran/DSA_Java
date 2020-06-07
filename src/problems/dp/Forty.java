package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Matrix Chaining - Bottom Up - Results Upper triangular Matrix
 */
public class Forty {

    private static final int[] arr = new int[]{1, 2, 3, 4}; // -> A(1x2), B(2x3), C(3x4)

    public static void main(String[] args) {
        matrixChaining(arr, arr.length);
    }

    private static void matrixChaining(int[] arr, int n) {
        int[][] m = new int[n][n];
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        int j, q;
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) { // Filling happens diagonally down starting from (1,2)
                j = i + l - 1; // Tricky calculation - better do it in Top Down Approach
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                    printMatrix(m);
                }
            }
        }
        System.out.println();
        System.out.println(m[1][n - 1]);
    }

    private static void printMatrix(int[][] m) {
        System.out.println();
        for (int[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }
    }


}
