package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Coin Change Problem
 */
public class ZU {

    public static void main(String[] args) {
        

        int[] coins = new int[]{1, 2, 3};
        int amount = 5;

        compute(coins, coins.length, amount);

        
    }

    private static void compute(int[] coins, int length, int amount) {
        int[][] temp = new int[amount + 1][length];
        for (int i = 0; i < length; i++) {
            temp[0][i] = 1;
        }
        int x, y;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                x = (i - coins[j] >= 0) ? temp[i - coins[j]][j] : 0;
                y = (j >= 1) ? temp[i][j - 1] : 0;
                temp[i][j] = x + y;
            }
        }
        for (int i = 0; i < amount + 1; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        System.out.println(temp[amount][length - 1]);
    }

}
