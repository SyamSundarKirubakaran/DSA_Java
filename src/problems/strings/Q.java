package problems.strings;

/**
 * @author SYAM K
 * @problem : Convert one string to another using min no.of given operations
 */
public class Q {

    private static final String str1 = "EACBD";
    private static final String str2 = "EABCD";

    public static void main(String[] args) {
        

        System.out.println(minOps(str1, str2));

        
    }

    public static int minOps(String A, String B) {
        if (A.length() != B.length())
            return -1;

        int i, j, res = 0;
        int[] count = new int[256];

        for (i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }

        for (i = 0; i < 256; i++)
            if (count[i] != 0)
                return -1;

        i = A.length() - 1;
        j = B.length() - 1;

        while (i >= 0) {
            if (A.charAt(i) != B.charAt(j))
                res++;
            else
                j--;
            i--;
        }
        return res;
    }

}
