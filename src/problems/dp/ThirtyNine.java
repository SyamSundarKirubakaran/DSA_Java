package problems.dp;

/**
 * @author SYAM K
 * @problem : Sub Set Sum Problem
 */
public class ThirtyNine {

    private static final int[] arr = new int[]{3, 4, 5, 2};

    public static void main(String[] args) {
        System.out.println(subSetSum(arr, arr.length, 6));
    }

    private static boolean subSetSum(int[] arr, int length, int sum) {
        boolean[][] subSet = new boolean[length + 1][sum + 1];
        for (int i = 0; i <= length; i++) {
            subSet[i][0] = true;
        }
        for (int i = 0; i <= sum; i++) {
            subSet[0][i] = false;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i - 1]) {
                    subSet[i][j] = subSet[i - 1][j] || subSet[i - 1][j - arr[i - 1]];
                } else {
                    subSet[i][j] = subSet[i - 1][j];
                }
            }
        }
        return subSet[length][sum];
    }
}
