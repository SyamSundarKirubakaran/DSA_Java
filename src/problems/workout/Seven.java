package problems.workout;

import java.util.Arrays;

public class Seven {

    public static void main(String[] args){
        int[] nums = new int[]{2,0,2,1,1,0};

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


        System.out.println(Arrays.toString(nums));
    }

}
