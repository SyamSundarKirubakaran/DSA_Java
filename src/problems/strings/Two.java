package problems.strings;

/**
 * @author SYAM K
 * @problem : Remove duplicates in a given string
 */
public class Two {

    private static final String str = "syaamyyy";

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(unique(str));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    public static String unique(String s) {
        StringBuilder str = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (str.toString().indexOf(c) < 0) {
                str.append(c);
            }
        }

        return str.toString();
    }

}
