package problems.array;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Maximum of every contiguous sub-array of size k. - Sliding Window.
 */
public class Seventeen {
    static int[] arr = new int[]{10, 4, 2, 11, 3, 15, 12, 8, 7, 9, 21, 14};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        findMaxInWindowK(arr, arr.length - 1, 3);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void findMaxInWindowK(int[] arr, int size, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        window.add(arr[0]);
        for (int i = 0; i < k; i++) {
            while (!window.isEmpty() && window.getLast() <= arr[i]) {
                window.removeLast();
            }
            window.addLast(arr[i]);
        }
        for (int i = k; i <= size; i++) {
            System.out.println(window.getFirst());
            if (window.getFirst() == arr[i - k]) {
                window.removeFirst();
            }
            while (!window.isEmpty() && window.getLast() <= arr[i]) {
                window.removeLast();
            }
            window.addLast(arr[i]);
        }
        System.out.println(window.getFirst());
    }
}
