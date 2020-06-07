package problems.dp;

/**
 * @author SYAM K
 * @problem : 0/1 Knapsack
 */
public class FortyThree {

    private static final int[] weight = new int[]{1, 2, 4};
    private static final int[] profit = new int[]{10, 12, 28};
    private static final int n = weight.length;
    private static final int capacity = 6;

    public static void main(String[] args) {
        fillKnapSack();
    }

    private static void fillKnapSack() {
        int[][] knapSack = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            knapSack[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            knapSack[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= i) {
                    knapSack[i][j] = Math.max(profit[i - 1] + knapSack[i - 1][j - i], knapSack[i - 1][j]);
                } else {
                    knapSack[i][j] = knapSack[i - 1][j];
                }
            }
        }
        System.out.println(knapSack[n][capacity]);
    }
}
