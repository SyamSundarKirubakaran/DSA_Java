package problems.heaps;

/**
 * @author SYAM K
 * @problem : Given K-sorted list, find minimum range to which at least on number belongs from every list.
 */
public class Five {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int[][] arr = {
                {4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}
        };

        int k = arr.length;

        findSmallestRange(arr, k);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void findSmallestRange(int[][] arr, int k) {
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1, end = -1;

        int n = arr[0].length;

        Node[] arr1 = new Node[k];
        for (int i = 0; i < k; i++) {
            Node node = new Node(arr[i][0], i, 1);
            arr1[i] = node;
            max = Math.max(max, node.element);
        }

        MinHeap mh = new MinHeap(arr1, k);

        while (true) {
            Node root = mh.getMin();
            min = root.element;

            if ((max - min + 1) < range) { // to keep track of the least range
                range = max - min + 1;
                start = min;
                end = max;
            }

            if (root.j < n) {
                root.element = arr[root.i][root.j]; // current element .i.e, min
                root.j++;

                if (root.element > max)
                    max = root.element;
            } else break;

            mh.replaceMin(root); // replace min with next element in the sub array, i.e., j++
        }
        System.out.println("The smallest range is [" + start + ", " + end + "]");
    }

    static class Node {
        int element;
        int i;
        int j;

        Node(int a, int b, int c) {
            this.element = a;
            this.i = b;
            this.j = c;
        }
    }

    static class MinHeap {
        Node[] harr;
        int size;

        MinHeap(Node[] arr, int size) {
            this.harr = arr;
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
            if (l < size && harr[l].element < harr[i].element)
                small = l;
            if (r < size && harr[r].element < harr[small].element)
                small = r;
            if (small != i) {
                swap(small, i);
                MinHeapify(small);
            }
        }

        void swap(int i, int j) {
            Node temp = harr[i];
            harr[i] = harr[j];
            harr[j] = temp;
        }

        Node getMin() {
            return harr[0];
        }

        void replaceMin(Node x) {
            harr[0] = x;
            MinHeapify(0);
        }
    }

}
