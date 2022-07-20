package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Arrays A -> m, B -> n, (m>n) insert(m-n) 0s in B such that dot product is max
 */
public class ThirtyOne {

    private static final int[] a = {2, 3, 1, 7, 8};
    private static final int[] b = {3, 6};

    public static void main(String[] args) {
        

        maxDotProduct(a, a.length, b, b.length);

        
    }

    private static void maxDotProduct(int[] a, int aLength, int[] b, int bLength) {
        int[][] temp = new int[bLength + 1][aLength + 1]; // why reverse -> because we are keeping digits in B as a reference
        // to compare with elements of A and not the other way round.
        // also since aLength > bLength always
        for (int[] row : temp)
            Arrays.fill(row, 0);

        for (int i = 1; i <= bLength; i++) {
            for (int j = i; j <= aLength; j++) {
                temp[i][j] = Math.max(
                        temp[i - 1][j - 1] + a[j - 1] * b[i - 1],
                        temp[i][j - 1]
                );
            }
        }

        for (int[] ints : temp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(temp[bLength][aLength]);
    }

}
