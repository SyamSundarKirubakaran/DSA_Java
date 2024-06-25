package generic_workout.company.workout;

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

class One {
    public static void main(String[] args) {
        String[] nums = new String[]{"777","7","77","77"};
        String target = "7777";
        int targetL = target.length();

        int[] numsSize = new int[nums.length];

        HashMap<Integer, ArrayList<String>> mapper = new HashMap<>();

        ArrayList<String> arr;
        for (int i = 0; i < nums.length; i++) {
            numsSize[i] = nums[i].length();
            if (mapper.get(nums[i].length()) != null) {
                arr = mapper.get(nums[i].length());
            } else {
                arr = new ArrayList<>();
            }
            arr.add(nums[i]);
            mapper.put(nums[i].length(), arr);
        }

        int counter = 0;
        int tempC = 0;
        ArrayList<String> bufferFix;
        for (int i = 0; i < nums.length; i++) {
            int currentDiff = targetL - numsSize[i];
            if (mapper.get(currentDiff) != null) {
                arr = mapper.get(currentDiff);
                bufferFix = new ArrayList<>(arr);
                tempC = 0;
                if (currentDiff == nums[i].length() && arr != null) {
                    for (String s : arr) {
                        if (s.equals(nums[i]) && tempC == 0) {
                            bufferFix.remove(s);
                            tempC += 1;
                        }
                    }
                }
                arr = bufferFix;
            } else continue;

            for (String s : arr) {
//                System.out.println(target);
//                System.out.println(nums[i].concat(s));
//                System.out.println(s.concat(nums[i]));
                if (target.startsWith(nums[i]) && nums[i].concat(s).equals(target)) {
                    counter += 1;
                    System.out.println("arr: " + s + "nums " + nums[i]);
                }
            }
        }

        System.out.println(counter);
    }
}

