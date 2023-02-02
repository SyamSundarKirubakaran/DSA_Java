import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8,1,2,2,3})));
        // System.out.println(countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));

        test();
    }


    public static void test() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        pq.add(10);
        pq.add(100);
        pq.add(20);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {


        int max = 0, i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int B[] = new int[nums.length];
        int C[] = new int[max + 1];
        for (i = 0; i <= max; i++) C[i] = 0;
        for (i = 0; i < nums.length; i++) C[nums[i]] = C[nums[i]] + 1;
        for (i = 1; i <= max; i++) C[i] = C[i] + C[i - 1];
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) B[i] = 0;
            else B[i] = C[nums[i] - 1];
        }
        return B;
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int row = 0, col = grid[0].length - 1;

        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                count += (grid.length - row);
                col--;
            } else row++;
        }

        return count;
    }


}
