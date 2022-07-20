package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Count all Palindromic sub string in a string
 */
public class TwentyEight {

    public static void main(String[] args) {
        

        String str = "esass";
        int length = str.length();
        lpss(str, str.toCharArray(), length);

        
    }

    private static void lpss(String str, char[] strc, int length) {
        boolean[][] temp = new boolean[length][length];
        int[][] count = new int[length][length];
        for (int i = 0; i < length; i++) {
            temp[i][i] = true;
            count[i][i] = 1;
        }
        int j;
        int maxLength = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        for (int ls = 2; ls <= length; ls++) {
            for (int i = 0; i < length - ls + 1; i++) {
                j = i + ls - 1;
                if (strc[i] == strc[j]) {
                    if (i + 1 > j - 1) {
                        temp[i][j] = true;
                    } else {
                        temp[i][j] = temp[i + 1][j - 1];
                    }

                    // count
                    count[i][j] = 1 + count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];

                    if (ls > maxLength) {
                        maxLength = ls;
                        start = i;
                    }
                } else {
                    temp[i][j] = false;

                    // count
                    count[i][j] = count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];

                }
            }

        }
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        System.out.println("Max: " + maxLength + ", Start: " + start);
        System.out.println(str.substring(start, maxLength));
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(count[i]));
        }
        System.out.println(count[0][length - 1]);
    }
}
