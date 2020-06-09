package problems.dp;

/**
 * @author SYAM K
 * @problem : No.of Non-decreasing numbers with n digits - Less space
 */
public class FortyNine {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        countNonDecreasing(3);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void countNonDecreasing(int n) { // N * (N+1)/2 * (N+2)/3 * .... * (N+n-1)/n, Where N = 10
        int N = 10;
        long count = 1;
        for (int i = 1; i <= n; i++) {
            count *= (N + i - 1);
            count /= i;
        }
        System.out.println(count);
    }

    /*

    Count of n digit numbers = (Count of (n-1) digit numbers Ending with digit 9) +
                           (Count of (n-1) digit numbers Ending with digit 8) +
                           .............................................+
                           .............................................+
                           (Count of (n-1) digit numbers Ending with digit 0)

    Let count ending with digit ‘d’ and length n be count(n, d)
        count(n, d) = ∑(count(n-1, i)) where i varies from 0 to d
        Total count = ∑count(n-1, d) where d varies from 0 to n-1

     */

}
