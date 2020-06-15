package problems.heaps;

import java.util.PriorityQueue;

/**
 * @author SYAM K
 * @problem : K-Largest elements from an array
 */
public class Three {

    // heap represents the following min heap:
    //     10
    //    /   \
    //  25     23
    //  / \   / \
    // 45 50 30 35
    // / \ /
    //63 65 81
    private static final int[] heap = {10, 25, 23, 45, 50, 30, 35, 63, 65, 81};
    private static final int heapSize = heap.length;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        deleteKLargest(heap, heapSize, 3);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void deleteKLargest(int[] heap, int heapSize, int k) {
        // converts to max Heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i, Integer j) -> Integer.compare(j, i));
        for (int value : heap) {
            pq.add(value);
        }
        System.out.println(pq);
        while (k > 0 && !pq.isEmpty()) {
            System.out.println(pq.remove());
            k -= 1;
        }
    }

}
