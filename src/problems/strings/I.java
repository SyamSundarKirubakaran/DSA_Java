package problems.strings;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Anagrams
 */
public class I {

    private static final int NO_OF_CHARS = 256;
    private static final char[] str1 = ("listen").toCharArray();
    private static final char[] str2 = ("silent").toCharArray();

    public static void main(String[] args) {
        

        System.out.println(areAnagram(str1, str2));

        
    }

    private static boolean areAnagram(char[] str1, char[] str2) {
        int[] count1 = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int[] count2 = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        for (int i = 0; i < str1.length && i < str2.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        if (str1.length != str2.length)
            return false;
        for (int i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;
        return true;
    }

}
