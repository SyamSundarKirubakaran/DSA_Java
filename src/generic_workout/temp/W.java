package generic_workout.temp;

// https://leetcode.com/problems/maximum-product-subarray

class W {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }

    // https://leetcode.com/problems/maximum-subarray/solutions/

    class Solution {
        public int maxSubArray(int[] nums) {
            // Initialize our variables using the first element.
            int currentSubarray = nums[0];
            int maxSubarray = nums[0];

            // Start with the 2nd element since we already used the first one.
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
                currentSubarray = Math.max(num, currentSubarray + num);
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }

            return maxSubarray;
        }
    }

}
