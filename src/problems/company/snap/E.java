package problems.company.snap;

// https://leetcode.com/problems/minimum-number-of-refueling-stops/

import java.util.Collections;
import java.util.PriorityQueue;

public class E {

    public int minRefuelStops(int target, int tank, int[][] stations) {
        // pq is a maxheap of gas station capacities
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for (int[] station : stations) {
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while (!pq.isEmpty() && tank < 0) {  // must refuel in past
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;
            pq.offer(capacity);
            prev = location;
        }

        // Repeat body for station = (target, inf)
        {
            tank -= target - prev;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            if (tank < 0) return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new E().minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }

}
