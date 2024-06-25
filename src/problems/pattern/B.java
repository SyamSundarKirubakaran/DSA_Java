package problems.pattern;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Knuth Morris Pratt Algorithm
 */
public class B {

    public static void main(String[] args) {
        

        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);

        
    }

    private static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];

        computeLPSArray(pat, M, lps);

        System.out.println(Arrays.toString(lps));

        int i = 0;
        int j = 0;
        while (i < N) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) // some match before, not `i` is not incremented
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    private static void computeLPSArray(String pat, int M, int[] lps) { // lps -> longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) { // match found
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) { // match not found, but there was some match before this step, such that we have some `len`
                    len = lps[len - 1];
                } else { // match not found and no match in previous step as well
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

}
