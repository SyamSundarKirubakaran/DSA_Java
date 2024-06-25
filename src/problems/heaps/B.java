package problems.heaps;

/**
 * @author SYAM K
 * @problem : Deleting arb element in MIN heap
 */
public class B {

    // heap represents the following min heap:
    //     10
    //    /   \
    //  25     23
    //  / \   / \
    // 45 50 30 35
    // / \ /
    //63 65 81
    private static final int[] heap = {10, 25, 23, 45, 50, 30, 35, 63, 65, 81};
    private static int heapSize = heap.length;

    public static void main(String[] args) {
        

        deleteArb(heap, heapSize, 25);

        printHeap(heap, heapSize);


    }

    private static void printHeap(int[] heap, int heapSize) {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private static void deleteArb(int[] arr, int size, int element) {
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == element) {
                System.out.println("Deletion done @ " + i);
                break;
            }
        }
        if (i < size) {
            arr[i] = arr[size - 1];
            heapSize -= 1;
            minHeapify(arr, i, heapSize);
        }
    }

    private static void minHeapify(int[] heap, int parent, int heapSize) {
        int leftChild = parent * 2;
        int rightChild = parent * 2 + 1;
        int least = parent;
        if (leftChild <= heapSize && heap[leftChild] < heap[least])
            least = leftChild;
        if (rightChild <= heapSize && heap[rightChild] < heap[least])
            least = rightChild;
        if (least != parent) {
            int temp = heap[parent];
            heap[parent] = heap[least];
            heap[least] = temp;
            minHeapify(heap, least, heapSize);
        }
    }

}
