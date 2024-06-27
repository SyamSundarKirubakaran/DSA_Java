package problems.strings;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Find 1st non-repeating character in the given string
 */
public class G {

    static final int NO_OF_CHARS = 256;
    private static final String str = "sasssda";
    static HashMap<Character, CountIndex> hm = new HashMap<>(NO_OF_CHARS);

    public static void main(String[] args) {
        
        int result = firstNonRepeating(str);

        System.out.println(
                result == Integer.MAX_VALUE
                        ? "Either all characters are repeating or string is empty"
                        : "First non-repeating character is " + str.charAt(result)
        );

        
    }

    private static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                hm.get(str.charAt(i)).incCount();
            } else {
                hm.put(str.charAt(i), new CountIndex(i));
            }
        }
    }

    private static int firstNonRepeating(String str) {
        getCharCountArray(str);
        int result = Integer.MAX_VALUE, i;

        for (i = 0; i < str.length(); i++) {
            if (hm.get(str.charAt(i)).count == 1
                    && hm.get(str.charAt(i)).index < result) { // because we want the 1st value
                result = hm.get(str.charAt(i)).index;
            }
        }

        return result;
    }


    private static class CountIndex {
        int count, index;

        public CountIndex(int index) {
            this.count = 1;
            this.index = index;
        }

        public void incCount() {
            this.count++;
        }
    }

}
