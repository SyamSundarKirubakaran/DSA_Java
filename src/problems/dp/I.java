package problems.dp;

/**
 * @author SYAM K
 * @problem : Edit Distance
 */
public class I {

    private static final String word1 = "DATA";
    private static final String word2 = "DENT";

    public static void main(String[] args) {
        editDistance(word1, word1.length(), word2, word2.length());
    }

    private static void editDistance(String word1, int length1, String word2, int length2) {
        int[][] ed = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0)
                    ed[0][j] = j;
                else if (j == 0)
                    ed[i][0] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    ed[i][j] = ed[i - 1][j - 1];
                else
                    ed[i][j] = 1 + min(ed[i - 1][j], // delete
                            ed[i][j - 1], // insert
                            ed[i - 1][j - 1]); // replace
            }
        }
        System.out.println(ed[length1][length2]);
    }

    static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

}
