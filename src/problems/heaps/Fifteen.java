package problems.heaps;

/**
 * @author SYAM K
 * @problem : Given K-sorted arrays of size n-each, merge them.
 */
public class Fifteen {

    public static void main(String[] args) {
        

        int[][] arr = {
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };

        printSorted(arr, arr.length);
        System.out.println();

        
    }

    private static void printSorted(int[][] arr, int n) {
        Node[] arr1 = new Node[n];
        int resultSize = 0;
        for (int i = 0; i < n; i++) {
            Node node = new Node(arr[i][0], i, 1);
            arr1[i] = node;
            resultSize += arr[i].length;
        }

        MinHeap mh = new MinHeap(arr1, n);

        for (int count = 0; count < resultSize; count++) { // Very similar to problem 5
            Node root = mh.getMin();
            System.out.print(root.element + ", ");

            if (root.j < arr[root.i].length) {
                root.element = arr[root.i][root.j];
                root.j += 1;
            } else root.element = Integer.MAX_VALUE; // If root was the last element of its array

            mh.replaceMin(root);
        }

    }

    public static class Node {
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
