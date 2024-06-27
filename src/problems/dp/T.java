package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Given a Cost matrix, min cost to reach (m-1,n-1) from (0,0), allowed movements -> left, right, diagonally down
 */
public class T {

    private static final int[][] arr = new int[][]{
            {10, 3, 4},
            {5, 6, 17},
            {13, 4, 11}
    };

    public static void main(String[] args) {
        

        minCostPath(arr, arr.length, arr.length);

        
    }

    private static void minCostPath(int[][] cost, int m, int n) {
        int[][] temp = new int[m][n];
        temp[0][0] = cost[0][0];
        for (int i = 1; i < m; i++) {
            temp[i][0] = temp[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j < n; j++) {
            temp[0][j] = temp[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = cost[i][j] + Math.min(
                        temp[i - 1][j],
                        Math.min(
                                temp[i - 1][j - 1],
                                temp[i][j - 1]
                        )
                );
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        System.out.println(temp[m - 1][n - 1]);
    }

}
