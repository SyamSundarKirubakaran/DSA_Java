package generic_workout.temp2;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class B {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int j, count, maxCount = -1;
        char[] charArr = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            j = i + 1;
            count = 0;
            charSet.clear();
            charSet.add(charArr[i]);
            while (j < s.length() && !charSet.contains(charArr[j])) {
                charSet.add(charArr[j]);
                count += 1;
                j += 1;
            }
            if ((count + 1) > maxCount) {
                maxCount = count + 1;
            }
            if (j == s.length()) {
                break;
            }
        }
        return maxCount == -1 ? 0 : maxCount;
    }

}
