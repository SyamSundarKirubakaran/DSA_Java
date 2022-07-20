package problems.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author SYAM K
 * @problem : Median in a stream of numbers
 */
public class Four {

    public static void main(String[] args) {
        

        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);

        
    }

    public static void printMedian(int[] a) {
        double med = a[0];
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder()); // left
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>(); // right

        leftHeap.add(a[0]);
        System.out.println(med);

        for (int i = 1; i < a.length; i++) {
            int x = a[i];

            if (leftHeap.size() > rightHeap.size()) {
                if (x < med) {
                    int removed = leftHeap.remove();
                    rightHeap.add(removed);
                    leftHeap.add(x);
                } else rightHeap.add(x);
                med = (double) (leftHeap.peek() + rightHeap.peek()) / 2;
            } else if (leftHeap.size() == rightHeap.size()) {
                if (x < med) {
                    leftHeap.add(x);
                    med = (double) leftHeap.peek();
                } else {
                    rightHeap.add(x);
                    med = (double) rightHeap.peek();
                }
            } else {
                if (x > med) {
                    int removed = rightHeap.remove();
                    leftHeap.add(removed);
                    rightHeap.add(x);
                } else leftHeap.add(x);
                med = (double) (leftHeap.peek() + rightHeap.peek()) / 2;

            }
            System.out.println(med);
        }
    }

}
