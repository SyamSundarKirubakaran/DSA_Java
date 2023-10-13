package problems.company.tesla.set1;

// https://leetcode.com/problems/move-zeroes/

public class Q {
    public void moveZeroes(int[] nums) {

        if(nums.length == 1){
            return;
        }

        int p1 = 0, p2 = 1;
        while(true){
            while(p1 < nums.length && nums[p1]!=0){ p1+=1; p2+=1;}
            while(p2 < nums.length && nums[p2]==0) p2+=1;
            if(p1 >= nums.length) break;
            if(p2 >= nums.length) break;
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
    }
}
