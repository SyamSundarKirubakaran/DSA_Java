package problems.dp;

/**
 * @author SYAM K
 * @problem : Longest Palindromic Sub Sequence
 */
public class Fourteen {

    private static final String s = "MADONA MADAM";

    public static void main(String[] args) {
        longest(s.toCharArray());
    }

    private static void longest(char[] str) {
        int len = str.length;
        int[][] lps = new int[len][len];
        for (int i = 0; i < len; i++) {
            lps[i][i] = 1;
        }
        int j;
        for (int ls = 2; ls <= len; ls++) {
            for (int i = 0; i < len - ls + 1; i++) {
                j = i + ls - 1;
                if (str[i] == str[j] && ls == 2) {
                    lps[i][j] = 2;
                } else if (str[i] == str[j]) {
                    lps[i][j] = lps[i + 1][j - 1] + 2;
                } else {
                    lps[i][j] = Math.max(lps[i][j - 1], lps[j - 1][i]);
                }
            }
        }
        System.out.println(lps[0][len - 1]);
    }

}
