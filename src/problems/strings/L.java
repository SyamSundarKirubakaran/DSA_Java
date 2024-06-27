package problems.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Find 1s non-repeating character in a stream of characters
 */
public class L {

    private static final int MAX_CHAR = 256;

    public static void main(String[] args) {
        

        findFirstNonRepeating("geeksforgeeksandgeeksquizfor");

        
    }

    static void findFirstNonRepeating(String stream) {
        List<Character> inDLL = new ArrayList<>();
        boolean[] repeated = new boolean[MAX_CHAR];
        for (int i = 0; i < stream.length(); i++) {
            char x = stream.charAt(i);
            System.out.println("Reading " + x + " from stream " + stream);
            if (!repeated[x]) {
                if (!(inDLL.contains(x))) {
                    inDLL.add(x);
                } else {
                    inDLL.remove((Character) x);
                    repeated[x] = true;
                }
            }
            if (inDLL.size() != 0) {
                System.out.print("First non-repeating character so far is ");
                System.out.println(inDLL.get(0));
            }
        }
    }


}
