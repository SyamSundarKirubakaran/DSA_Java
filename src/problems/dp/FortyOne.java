package problems.dp;

/**
 * @author SYAM K
 * @problem : Longest Common Sub Sequence
 */
public class FortyOne {

    private static final String s1 = "AGGTAB";
    private static final String s2 = "GXTXAYB";

    public static void main(String[] args) {
        lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    private static void lcs(char[] x, char[] y, int m, int n) {
        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (x[i - 1] == y[j - 1])
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        System.out.println(lcs[m][n]);
    }
}
