package generic_workout;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/

public class K {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(subsets(arr));
    }

    public static void backtrack(List<List<Integer>> output,
                                 int first, ArrayList<Integer> curr,
                                 int[] nums, int k, int n) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = first; i < n; i++) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(output,i + 1, curr, nums, k, n);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for (int k = 0; k <= n; k++) {
            // not including `n` will not add `[1, 2, 3]` ie., the actual array to the output
            // k basically denotes the length of the to-be created subset
            backtrack(output, 0, new ArrayList<Integer>(), nums, k, n);
        }
        return output;
    }



}
