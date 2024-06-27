package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : No.of ways to fill 2xn with 2x1
 */
public class S {

    public static void main(String[] args) {
        findTileFit(7);
    }

    private static void findTileFit(int n) {
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 2;
        for (int i = 2; i < n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        System.out.println(Arrays.toString(temp));
    }

}
