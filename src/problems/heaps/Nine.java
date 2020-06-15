package problems.heaps;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SYAM K
 * @problem : Find the Kth largest element in a stream
 */
public class Nine {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int[] stream = new int[]{10, 20, 11, 70, 50, 40, 100, 5};
        kthLargestStream(stream, 3);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void kthLargestStream(int[] stream, int k) {
        int count = 0, x;
        int[] arr = new int[k];
        MinHeap mh = new MinHeap(arr, k);
        Scanner sb = new Scanner(System.in);
        do {
            x = sb.nextInt();
            if (count < k - 1) {
                arr[count] = x;
            } else {
                if (count == k - 1) {
                    arr[count] = x;
                    mh.buildHeap(mh.size);
                } else {
                    if (x > mh.getMin()) {
                        mh.replaceMin(x);
                    }
                }
                System.out.println("Kth largest: " + mh.getMin() + ", Heap Values: " + Arrays.toString(mh.harr));
            }
            count += 1;
        } while (count != 8);
    }

    static class MinHeap {
        int[] harr;
        int size;

        MinHeap(int[] arr, int size) {
            this.harr = arr;
            this.size = size;
            int i = (size - 1) / 2;
            while (i >= 0) {
                MinHeapify(i);
                i--;
            }
        }

        void buildHeap(int size) {
            this.size = size;
            int i = (size - 1) / 2;
            while (i >= 0) {
                MinHeapify(i);
                i--;
            }
        }

        int left(int i) {
            return 2 * i + 1;
        }

        int right(int i) {
            return 2 * i + 2;
        }

        void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int small = i;
            if (l < size && harr[l] < harr[i])
                small = l;
            if (r < size && harr[r] < harr[small])
                small = r;
            if (small != i) {
                swap(small, i);
                MinHeapify(small);
            }
        }

        void swap(int i, int j) {
            int temp = harr[i];
            harr[i] = harr[j];
            harr[j] = temp;
        }

        int getMin() {
            return harr[0];
        }

        void replaceMin(int x) {
            harr[0] = x;
            MinHeapify(0);
        }
    }

}
