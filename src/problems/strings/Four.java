package problems.strings;

/**
 * @author SYAM K
 * @problem : Reverse the words in the given sentence
 */
public class Four {

    private static final String str = "Thinking of moving to Kotlin";

    public static void main(String[] args) {
        Long start = System.nanoTime();

        split(str.split(" "));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void split(String[] s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            ans.append(s[i]).append(" ");
        }
        System.out.println(ans.substring(0, ans.length() - 1));
    }

}