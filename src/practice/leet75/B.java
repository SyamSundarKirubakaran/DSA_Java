package practice.leet75;

// https://leetcode.com/problems/find-pivot-index/

class B {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int[] leftToRight = new int[nums.length];
            int[] rightToLeft = new int[nums.length];
            int temp1 = 0, temp2 = 0;
            int returnIndex = -1;
            for(int i=0; i<nums.length; i++){
                temp1 += nums[i];
                leftToRight[i] = temp1;
                temp2 += nums[nums.length - i - 1];
                rightToLeft[nums.length - i - 1] = temp2;
            }
            for(int i=0; i<nums.length; i++){
                if(leftToRight[i] == rightToLeft[i]){
                    returnIndex = i;
                    break;
                }
            }
            return returnIndex;
        }
    }
}
