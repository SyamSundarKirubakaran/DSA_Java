package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Rectangular grid 2xn, max sum such that no 2 chosen digit are adj -> vertically, horizontally, diagonally
 */
public class Thirty {

    private static final int[][] arr = new int[][]{
            {1, 2, 3, 4, 6},
            {0, 5, 2, 1, 7}
    };

    public static void main(String[] args) {
        Long start = System.nanoTime();

        compute(arr);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void compute(int[][] arr) {
        int[] d = new int[arr[0].length];
        int maxColumn = -1;
        int maxValue = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxColumn = j;
                }
            }
        }
        if (maxColumn == 1) {
            d[maxColumn] = maxValue;
            d[0] = Math.max(arr[0][0], arr[1][0]);
        } else {
            d[maxColumn] = maxValue;
            d[1] = Math.max(arr[0][1], arr[1][1]);
        }
        for (int i = 2; i < arr[0].length; i++) {
            d[i] = Math.max(
                    Math.max(arr[0][i], arr[1][i]) + d[i - 2],
                    d[i - 1]
            );
        }
        System.out.println(Arrays.toString(d));
    }

}
