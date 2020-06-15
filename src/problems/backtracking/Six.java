package problems.backtracking;

/**
 * @author SYAM K
 * @problem : Find subset of elements that are selected from a given set whose sum adds upto a given number `k`
 */
public class Six {

    // Subset Sum Problem
    public static void main(String[] args) {
        Long start = System.nanoTime();

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static boolean isSubsetSum(int[] set,
                               int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }
}
