package problems.pattern;

/**
 * @author SYAM K
 * @problem : Boyer's Moore String Matching Algorithm
 */
public class Three {

    static int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        

        char[] txt = "ABAAABCD".toCharArray();
        char[] pat = "ABC".toCharArray();
        search(txt, pat);

        
    }

    static void search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;

        int[] hashTable = new int[NO_OF_CHARS];

        fillHash(pat, m, hashTable);

        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j]) // comparison happens from the last character after aligning
                j--;

            if (j < 0) {
                System.out.println("Patterns occur at shift = " + s);
                s += (s + m < n) ? m - hashTable[txt[s + m]] : 1; // align the pattern next to character after match or shift one right
            } else
                s += Math.max(1, j - hashTable[txt[s + j]]); // max of 1 shift or aligning pattern with next matching char in text
        }
    }

    static void fillHash(char[] str, int size, int[] hashTable) {
        int i;
        for (i = 0; i < NO_OF_CHARS; i++)
            hashTable[i] = -1;
        for (i = 0; i < size; i++)
            hashTable[(int) str[i]] = i;
    }

}
