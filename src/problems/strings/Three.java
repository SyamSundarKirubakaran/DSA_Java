package problems.strings;

/**
 * @author SYAM K
 * @problem : Check if given 2 strings are rotations of each other
 */
public class Three {

    private static final String str1 = "AACD";
    private static final String str2 = "ACDA";

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(areRotations(str1, str2));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static boolean areRotations(String str1, String str2) {
        return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
    }

}
