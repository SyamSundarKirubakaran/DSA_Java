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

    private static boolean subSetSum(int[] set, int length, int sum) {
        boolean[][] subSet = new boolean[sum + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            subSet[0][i] = true;
        }
        for (int i = 0; i <= sum; i++) {
            subSet[i][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= length; j++) {
                subSet[i][j] = subSet[i][j - 1];
                if (i >= set[j - 1]) {
                    subSet[i][j] = subSet[i][j] || subSet[i - set[j - 1]][j - 1];
                }
            }
        }
        return subSet[sum][length];
    }
}
