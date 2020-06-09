package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Longest Palindromic sub string
 */
public class TwentySeven {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        String s = "esass";
        int length = s.length();

        lpss(s, s.toCharArray(), length);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void lpss(String str, char[] s, int length) {
        boolean[][] temp = new boolean[length][length];
        int j;
        for (int i = 0; i < length; i++) {
            temp[i][i] = true;
        }
        int start = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (int ls = 2; ls <= length; ls++) {
            for (int i = 0; i < length - ls + 1; i++) {
                j = i + ls - 1;
                if (s[i] == s[j]) {
                    if (i + 1 > j - 1) { // equal and in read value in lower triangular matrix
                        temp[i][j] = true;
                    } else {
                        temp[i][j] = temp[i + 1][j - 1];
                    }
                    if (ls > maxLength) {
                        maxLength = ls;
                        start = i;
                    }
                } else {
                    temp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        System.out.println(str.substring(start, maxLength));
    }

}
