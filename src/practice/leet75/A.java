package practice.leet75;

// https://leetcode.com/problems/running-sum-of-1d-array/

class A {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    static class Solution {
        public int[] runningSum(int[] nums) {
            int[] result = new int[nums.length];
            int temp = 0;
            for(int i = 0; i<nums.length; i++){
                temp += nums[i];
                result[i] = temp;
            }
            return result;
        }
    }
}
