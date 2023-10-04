package workout.temp;

// https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        subsetsWithDupHelper(subsets, currentSubset, nums, 0);
        return subsets;
    }

    private static void subsetsWithDupHelper(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index) {
        // Add the subset formed so far to the subsets list.
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // If the current element is a duplicate, ignore.
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            subsetsWithDupHelper(subsets, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // https://leetcode.com/problems/subsets/
    class Solution {
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
            // if the combination is done
            if (curr.size() == k) {
                output.add(new ArrayList(curr));
                return;
            }
            for (int i = first; i < n; ++i) {
                // add i into the current combination
                curr.add(nums[i]);
                // use next integers to complete the combination
                backtrack(i + 1, curr, nums);
                // backtrack
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (k = 0; k < n + 1; ++k) {
                backtrack(0, new ArrayList<Integer>(), nums);
            }
            return output;
        }
    }
}
