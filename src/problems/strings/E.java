package problems.strings;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Reverse a given string
 */
public class E {

    private static final String str = "programming";

    public static void main(String[] args) {
        

        reverse(str.toCharArray());

        
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
