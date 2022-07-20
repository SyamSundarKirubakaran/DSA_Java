package problems.strings;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Find a smallest window in a string containing all characters of another string
 */
public class Eleven {

    private static final int MAX_CHARS = 256;
    private static final String str = "aabcbcdbca";

    public static void main(String[] args) {
        

        System.out.println(findSubString(str));

        
    }

    static String findSubString(String str) {
        int n = str.length();
        int distCount = 0;

        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[str.charAt(i)]) {
                visited[str.charAt(i)] = true;
                distCount++;
            }
        }

        int start = 0, startIndex = -1;
        int minLen = Integer.MAX_VALUE;

        int count = 0;
        int[] currCount = new int[MAX_CHARS];

        for (int j = 0; j < n; j++) {
            currCount[str.charAt(j)]++;
            if (currCount[str.charAt(j)] == 1)
                count++;
            if (count == distCount) {
                while (currCount[str.charAt(start)] > 1) {
                    if (currCount[str.charAt(start)] > 1)
                        currCount[str.charAt(start)]--;
                    start++;
                }
                int lenWindow = j - start + 1;
                if (minLen > lenWindow) {
                    minLen = lenWindow;
                    startIndex = start;
                }
            }
        }
        return str.substring(startIndex, startIndex + minLen);
    }

}
