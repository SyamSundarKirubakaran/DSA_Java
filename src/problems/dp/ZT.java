package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Matrix Chaining - Top Down
 */
public class ZT {

    private static final int[] dimen = new int[]{1, 2, 3, 4};

    public static void main(String[] args) {
        matrixChaining(dimen, dimen.length);
    }

    private static void matrixChaining(int[] dimen, int n) {
        int[][] m = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        System.out.println();
        int result = lookupChain(m, dimen, 1, n - 1);
        System.out.println(result);
    }

    private static int lookupChain(int[][] m, int[] dimen, int i, int j) {
        if (m[i][j] < Integer.MAX_VALUE)
            return m[i][j];
        if (i == j)
            m[i][j] = 0;
        else {
            for (int k = i; k <= j - 1; k++) {
                int q = lookupChain(m, dimen, i, k) +
                        lookupChain(m, dimen, k + 1, j) +
                        dimen[i - 1] * dimen[k] * dimen[j];
                if (q < m[i][j])
                    m[i][j] = q;
            }
        }
        for (int z = 0; z < dimen.length; z++) {
            System.out.println(Arrays.toString(m[z]));
        }
        System.out.println();
        return m[i][j];
    }


}
