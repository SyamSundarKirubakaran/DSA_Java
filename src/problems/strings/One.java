package problems.strings;

/**
 * @author SYAM K
 * @problem : Find a max occurring character in a given array.
 */
public class One {

    private static final int SIZE = 256;
    private static final String str = "syamaaa";

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(count(str));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static char count(String str) {
        int[] count = new int[SIZE];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)] += 1;
        }
        int max = -1;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        return result;
    }

}
