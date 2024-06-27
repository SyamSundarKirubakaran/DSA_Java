package problems.heaps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author SYAM K
 * @problem : Sort a nearly sorted array
 */
public class L {

    public static void main(String[] args) {


        int k = 3;
        int[] arr = {2, 6, 3, 12, 56, 8};
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println(Arrays.toString(arr));


    }

    private static void kSort(int[] arr, int n, int k) {
        // min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // add first k + 1 items to the min heap
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) { // add remaining elements
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }

}
