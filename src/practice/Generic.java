package practice;

import java.util.HashMap;
import java.util.Map;

public class Generic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }

    private static String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);

            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }

            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }

    public static boolean isIsomorphic(String s, String t) {
        System.out.println(transformString(s));
        System.out.println(transformString(t));
        return transformString(s).equals(transformString(t));
    }

}
