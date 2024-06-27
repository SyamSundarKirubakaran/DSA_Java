package problems.strings;

/**
 * @author SYAM K
 * @problem : Check if palindrome
 */
public class F {

    private static final String str = "madam";

    public static void main(String[] args) {


        System.out.println(checkPalindrome(str.toCharArray()));

        
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
