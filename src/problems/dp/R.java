package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : No.of times a string appeared as Sub Sequence in other string
 */
public class R {

    public static void main(String[] args) {
        

        String s1 = "abbab";
        int m = s1.length();
        String s2 = "ab";
        int n = s2.length();

        findCount(s1.toCharArray(), m, s2.toCharArray(), n);

        
    }

    private static void findCount(char[] s1, int m, char[] s2, int n) {
        int[][] temp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                temp[i][j] = 0;
            }
        }
        for (int i = 0; i <= m; i++) {
            temp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j];
                } else {
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        System.out.println(temp[m][n]);
    }


}
