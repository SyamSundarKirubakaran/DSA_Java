package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : All Pair Shortest path - Floyd Warshall's
 */
public class ZS {

    public static void main(String[] args) {
        floyd();
    }

    private static void floyd() {
        int[][] dist = new int[][]{
                {0, 11, 1, 6},
                {11, 0, 7, 3},
                {1, 7, 0, 2},
                {6, 3, 2, 0}
        };
        int n = 4;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                    printMatrix(dist);
                }
            }
        }
    }

    private static void printMatrix(int[][] dist) {
        System.out.println();
        for (int[] ints : dist) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
