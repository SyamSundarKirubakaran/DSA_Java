package problems.dp;

/**
 * @author SYAM K
 * @problem : Longest Palindromic sub string - Less Space Complexity
 */
public class ZV {

    public static void main(String[] args) {
        

        String str = "esass";
        lpss(str, str.toCharArray(), str.length());

        
    }

    private static void lpss(String s, char[] str, int length) {
        int low, high;
        int maxLength = Integer.MIN_VALUE, start = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < length && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                low -= 1;
                high += 1;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < length && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                low -= 1;
                high += 1;
            }
        }
        System.out.println(s.substring(start, maxLength + 1));
    }

}
