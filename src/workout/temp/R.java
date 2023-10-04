package workout.temp;


// https://leetcode.com/problems/sort-colors/description/

class R {
    public void sortColors(int[] nums) {
        int current = 0, p1 = 0, p2 = nums.length - 1;

        while(current <= p2){
            if(nums[current] == 0){
                int temp = nums[p1];
                nums[p1] = nums[current];
                nums[current] = temp;
                p1+=1;
                current+=1;
            } else if(nums[current] == 2){
                int temp = nums[p2];
                nums[p2] = nums[current];
                nums[current] = temp;
                p2-=1;
            } else current+=1;
        }
    }
}
