package problems.company.tesla.set2;

// https://leetcode.com/problems/3sum/

import java.util.*;

public class ZB {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            Set<Integer> dups = new HashSet<>();
            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < nums.length; ++i)
                if (dups.add(nums[i])) {
                    for (int j = i + 1; j < nums.length; ++j) {
                        int complement = -nums[i] - nums[j];
                        if (seen.containsKey(complement) && seen.get(complement) == i) {
                            List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                            Collections.sort(triplet);
                            res.add(triplet);
                        }
                        seen.put(nums[j], i);
                    }
                }
            return new ArrayList(res);
        }
    }
}
