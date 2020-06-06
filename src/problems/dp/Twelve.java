package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Word breaking problem
 */
public class Twelve {

    private static final List<String> dictionary = new ArrayList<>(
            Arrays.asList("i", "a", "am", "go", "good")
    );

    public static void main(String[] args) {
        String input = "iamgood";
        boolean canBeBroken = find(input);
        System.out.println(canBeBroken);
    }

    private static boolean find(String s) {
        boolean[] t = new boolean[s.length() + 1];
        int[] startIndex = new int[s.length() + 1];
        t[0] = true;
        startIndex[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!t[i])
                continue;
            for (String a : dictionary) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if (t[end]) continue;
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                    startIndex[end] = i;
                }
            }
        }
        if (t[s.length()]) {
            List<String> presentWords = new ArrayList<>();
            for (int i = 1; i <= s.length(); i++) {
                if (t[i]) {
                    presentWords.add(s.substring(startIndex[i], i));
                }
            }
            eliminateSubStringAndPrint(presentWords);
        }
        return t[s.length()];
    }

    private static void eliminateSubStringAndPrint(List<String> presentWords) {
        presentWords.sort(Comparator.comparingInt(String::length));
        List<String> removeList = new ArrayList<>();
        for (int i = 0; i < presentWords.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (presentWords.get(i).contains(presentWords.get(j))) {
                    removeList.add(presentWords.get(j));
                }
            }
        }
        presentWords.removeAll(removeList);
        System.out.println(presentWords);
    }

}
