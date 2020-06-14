package problems.strings;

/**
 * @author SYAM K
 * @problem : Min no.of palindromic sub-sequences to be removed to empty a binary string
 */
public class Fourteen {

    public static void main(String[] args) {
        Long start = System.nanoTime();


        System.out.println(minRemovals("010010"));
        System.out.println(minRemovals("0100101"));


        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static boolean isPalindrome(String str) {
        int l = 0;
        int h = str.length() - 1;
        while (h > l)
            if (str.charAt(l++) != str.charAt(h--))
                return false;
        return true;
    }


    static int minRemovals(String str) {
        if (str.isEmpty())
            return 0;
        return isPalindrome(str) ? 1 : 2;
    }

}
