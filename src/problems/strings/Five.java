package problems.strings;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Reverse a given string
 */
public class Five {

    private static final String str = "programming";

    public static void main(String[] args) {
        Long start = System.nanoTime();

        reverse(str.toCharArray());

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void reverse(char[] str) {
        int i = 0, j = str.length - 1;
        char temp;
        while (i < j) {
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i += 1;
            j -= 1;
        }
        System.out.println(Arrays.toString(str));
    }

}
