package generic_workout.temp2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/stock-price-fluctuation/

public class H {

    private int latestTime;
    // Store price of each stock at each timestamp.
    private Map<Integer, Integer> timestampPriceMap;

    // Store stock prices in sorted order to get min and max price.
    private PriorityQueue<int[]> minHeap, maxHeap;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public H() {
        latestTime = 0;
        timestampPriceMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    }

    public static void main(String[] args) {
        // ["StockPrice","update","update","current","maximum","update","maximum","update","minimum"]
        // [[],[1,10],[2,5],[],[],[1,3],[],[4,2],[]]
    }

    public void update(int timestamp, int price) {
        // Update latestTime to latest timestamp.
        latestTime = Math.max(latestTime, timestamp);

        // Add latest price for timestamp.
        timestampPriceMap.put(timestamp, price);

        minHeap.add(new int[]{ price, timestamp });
        maxHeap.add(new int[]{ price, timestamp });
    }

    public int current() {
        // Return latest price of the stock.
        return timestampPriceMap.get(latestTime);
    }

    public int maximum() {
        int[] top = maxHeap.peek();
        // Pop pairs from heap with the price doesn't match with hashmap.
        while (timestampPriceMap.get(top[1]) != top[0]) {
            maxHeap.remove();
            top = maxHeap.peek();
        }

        return top[0];
    }

    public int minimum() {
        int[] top = minHeap.peek();
        // Pop pairs from heap with the price doesn't match with hashmap.
        while (timestampPriceMap.get(top[1]) != top[0]) {
            minHeap.remove();
            top = minHeap.peek();
        }

        return top[0];
    }

}
