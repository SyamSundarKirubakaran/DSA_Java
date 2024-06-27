package problems.dp;

/**
 * @author SYAM K
 * @problem : Min cost to make strings(x and y) equal, del(x) -> S, del(y) -> P
 */
public class Q {

    public static void main(String[] args) {
        

        String s1 = "aasam";
        String s2 = "sama";
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s1Cost = 10;
        int s2Cost = 20;

        int lcsLength = lcs(s1.toCharArray(), s2.toCharArray(), s1Length, s2Length);

        System.out.println((s1Length - lcsLength) * s1Cost + (s2Length - lcsLength) * s2Cost);

        
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


}
