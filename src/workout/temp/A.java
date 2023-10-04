package workout.temp;

/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

class A {

    public static void main(String[] args) {
        String[] nums = new String[]{"777","7","77","77"};
        String target = "7777";
        System.out.println(numOfPairs(nums, target));
    }


    public static int numOfPairs(String[] nums, String target){
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for (String num : nums) {
            if (target.startsWith(num)) {
                String substring = target.substring(num.length());
                if (map.containsKey(substring))
                    result += map.get(substring); // mistake here
            }
            if (target.endsWith(num)) {
                String substring = target.substring(0, target.length() - num.length());
                if (map.containsKey(substring))
                    result += map.get(substring);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }

}

