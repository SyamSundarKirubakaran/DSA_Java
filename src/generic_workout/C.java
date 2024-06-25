package generic_workout;

// https://leetcode.com/problems/longest-palindromic-substring/

public class C {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if(s.length() == 1) return s;

        int n = s.length() - 1, j;
        int i1, i2;
        char[] charArr = s.toCharArray();
        String result = String.valueOf(s.charAt(0));
        int currentMax = 1;
        int i = 0;
        j = n;
        while (true) {
            while (i < j && charArr[i] != charArr[j]) {
                j -= 1;
            }
            if (i < j) {
                i1 = i;
                i2 = j;
                while (i1 < i2 && charArr[i1] == charArr[i2]) {
                    i1 += 1;
                    i2 -= 1;
                }
                if (i1 >= i2) {
                    if ((j - i + 1) > currentMax) {
                        result = s.substring(i, j + 1);
                        currentMax = j - i + 1;
                    }
                    i += 1;
                    if (i == n)
                        break;
                    j = n;
                } else {
                    j -= 1;
                }
            } else {
                i += 1;
                if (i == n)
                    break;
                j = n;
            }
        }
        return result;
    }

}
