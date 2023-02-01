package problems.workout;

import java.util.HashSet;

public class Nine {

    public static void main(String[] args) {
        String s = "bbbbb";
        if (s.length() == 1) {
            System.out.println(1);
            return;
        }
        int i = 0, j = 1;
        int maxCount = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        while (i < s.length() && j < s.length() && i <= j) {
            if (set.add(s.charAt(j))) {
                j += 1;
            } else {
                while(s.charAt(i) == s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i += 1;
                }
                i+=1;
            }
            maxCount = Math.max(maxCount, j - i);
        }
        System.out.println(maxCount);
    }

}
