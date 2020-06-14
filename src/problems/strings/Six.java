package problems.strings;

/**
 * @author SYAM K
 * @problem : Check if palindrome
 */
public class Six {

    private static final String str = "madam";

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(checkPalindrome(str.toCharArray()));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static boolean checkPalindrome(char[] str) {
        int i = 0, j = str.length - 1;
        while (i < j) {
            if (str[i] != str[j]) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

}
