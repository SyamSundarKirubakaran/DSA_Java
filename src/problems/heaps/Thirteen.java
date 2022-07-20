package problems.heaps;

/**
 * @author SYAM K
 * @problem : Given n ropes with different length, connect with minimum cost.
 */
public class Thirteen {

    int[] harr;
    int heapSize;
    int capacity;

    public Thirteen(int[] a, int size) {
        heapSize = size;
        capacity = size;
        harr = a;
        int i = (heapSize - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    public static void main(String[] args) {
        

        int[] len = {4, 3, 2, 6};
        int size = len.length;
        System.out.println("Total cost for connecting ropes is " + minCost(len, size));

        
    }

    static int minCost(int[] len, int n) {
        int cost = 0;
        Thirteen minHeap = new Thirteen(len, n);
        while (!minHeap.isSizeOne()) {
            int min = minHeap.extractMin();
            int secMin = minHeap.extractMin();
            cost += (min + secMin);
            minHeap.insertKey(min + secMin);
        }
        return cost;
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && harr[l] < harr[i])
            smallest = l;
        if (r < heapSize && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int extractMin() {
        if (heapSize <= 0)
            return Integer.MAX_VALUE;
        if (heapSize == 1) {
            heapSize--;
            return harr[0];
        }

        int root = harr[0];
        harr[0] = harr[heapSize - 1];
        heapSize--;
        MinHeapify(0);

        return root;
    }

    void insertKey(int k) {
        if (heapSize == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        heapSize++;
        int i = heapSize - 1;
        harr[i] = k;

        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    boolean isSizeOne() {
        return (heapSize == 1);
    }

    void swap(int x, int y) {
        int temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }

}
