package problems.dp;

/**
 * @author SYAM K
 * @problem : In a Binary Matrix, Max Square Matrix with all 1s
 */
public class D {

    private static final int[][] arr = new int[][]
            {
                    {1, 1, 1, 1},
                    {0, 0, 1, 1},
                    {1, 1, 1, 1},
                    {0, 1, 1, 1},
            };

    public static void main(String[] args) {
        findMaxMatrix(arr, arr.length);
    }

    private static void findMaxMatrix(int[][] arr, int length) {
        int top, left, diagonal, minSelected;
        int result = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (arr[i][j] != 0) {
                    top = arr[i - 1][j];
                    left = arr[i][j - 1];
                    diagonal = arr[i - 1][j - 1];
                    minSelected = Math.min(Math.min(top, left), diagonal);
                    arr[i][j] += minSelected;
                    if (arr[i][j] > result) {
                        result = arr[i][j];
                    }
                }
            }
        }
        System.out.println(result);
    }

}
