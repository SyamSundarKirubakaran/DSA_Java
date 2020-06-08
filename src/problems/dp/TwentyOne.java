package problems.dp;

/**
 * @author SYAM K
 * @problem : K palindrome - If string becomes palindrome or not by doing atmost k deletions
 */
public class TwentyOne {

    private static final int K = 5;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        String s1 = "axba";
        String sReverse = reverse(s1);

        int lcsValue = lcs(s1.toCharArray(), sReverse.toCharArray(), s1.length(), sReverse.length());

        int diff = s1.length() - lcsValue;

        if (diff <= K) {
            System.out.println("Possible");
        } else {
            System.out.println("Not Possible");
        }

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int lcs(char[] s1, char[] s2, int s1Length, int s2Length) {
        int[][] temp = new int[s1Length + 1][s2Length + 1];
        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                if (i == 0 || j == 0) {
                    temp[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    temp[i][j] = 1 + temp[i - 1][j - 1];
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }
            }
        }
        return temp[s1Length][s2Length];
    }

    private static String reverse(String s1) {
        char[] arr = new char[s1.length()];
        int i = 0, j = s1.length() - 1;
        while (j > i) {
            arr[j] = s1.charAt(i);
            arr[i] = s1.charAt(j);
            j -= 1;
            i += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

}
