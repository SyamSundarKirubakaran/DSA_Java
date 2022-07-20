package problems.dp;

/**
 * @author SYAM K
 * @problem : Longest Common Sub Sequence
 */
public class TwentyTwo {

    public static void main(String[] args) {
        

        String s1 = "aabab";
        String s2 = "abab";

        lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());

        
    }

    private static void lcs(char[] s1, char[] s2, int m, int n) {
        int[][] temp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    temp[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    temp[i][j] = 1 + temp[i - 1][j - 1];
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }
            }
        }
        System.out.println(temp[m][n]);
    }

}
