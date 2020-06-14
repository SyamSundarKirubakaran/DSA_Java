package problems.strings;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Print concatenation of zig-zack string in k-rows
 */
public class Eighteen {

    private static final String str = "SYAMSUNDAR";
    private static final int n = 3;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        printZigZagConcat(str, n);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void printZigZagConcat(String str, int n) {
        if (n == 1) {
            System.out.print(str);
            return;
        }
        char[] str1 = str.toCharArray();
        int len = str.length();

        String[] arr = new String[n];
        Arrays.fill(arr, "");

        int row = 0;
        boolean down = true;

        for (int i = 0; i < len; ++i) {
            arr[row] += (str1[i]);

            if (row == n - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
