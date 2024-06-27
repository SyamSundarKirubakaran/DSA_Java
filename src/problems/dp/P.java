package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Longest non overlapping repeating sub string
 */
public class P {

    public static void main(String[] args) {
        

        String str = "runjogrun";

        longestRepeatingSubString(str.toCharArray(), str.length());


    }

    private static void longestRepeatingSubString(char[] str, int length) {
        int[][] lrs = new int[length + 1][length + 1];
        StringBuilder res = new StringBuilder();
        int resLength = 0;

        int index = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (str[i - 1] == str[j - 1] && (j - i) > lrs[i - 1][j - 1]) { // after && -> overlap condition
                    lrs[i][j] = lrs[i - 1][j - 1] + 1;
                    if (lrs[i][j] > resLength) {
                        resLength = lrs[i][j];
                        index = Math.max(index, i);
                    }
                } else {
                    lrs[i][j] = 0;
                }
            }
        }

        if (resLength > 0) {
            for (int i = index - resLength + 1; i <= index; i++) {
                res.append(str[i - 1]);
            }
        }
        for (int[] lr : lrs) {
            System.out.println(Arrays.toString(lr));
        }
        System.out.println(res);
    }

}
