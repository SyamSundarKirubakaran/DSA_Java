package problems.pattern;

/**
 * @author SYAM K
 * @problem : Find all occurrences of str2 in str1 - Brute force
 */
public class One {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        String str1 = "SyamSundarK";
        String str2 = "Sundar";
        printIndex(str1, str2);
        System.out.println();

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void printIndex(String str1, String str2) {
        boolean flag = false;
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
            if (str1.startsWith(str2, i)) {
                System.out.print(i + " ");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("NONE");
        }
    }

}
