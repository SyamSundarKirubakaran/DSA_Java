package problems.strings;

/**
 * @author SYAM K
 * @problem : Run length encoding
 */
public class H {

    private static final String str = "wwwwaaadexxxxxxywww";

    public static void main(String[] args) {
        

        runLengthEncoding(str);

        
    }

    private static void runLengthEncoding(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            System.out.print(str.charAt(i));
            System.out.print(count);
        }
        System.out.println();
    }

}
