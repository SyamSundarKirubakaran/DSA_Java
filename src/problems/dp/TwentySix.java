package problems.dp;

/**
 * @author SYAM K
 * @problem : Cutting Rod
 */
public class TwentySix {

    private static final int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        cutRod(prices, prices.length);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void cutRod(int[] prices, int n) {
        int maxValue;
        int[] value = new int[n + 1];
        value[0] = 0;
        for (int i = 1; i <= n; i++) {
            maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, prices[j] + value[i - j - 1]);
            }
            value[i] = maxValue;
        }
        System.out.println(value[n]);
    }

}
