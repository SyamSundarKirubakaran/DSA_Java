package problems.heaps;

/**
 * @author SYAM K
 * @problem : Convert MAX heap into MIN Heap
 */
public class Six {

    public static void main(String[] args) {
        

        int[] arr = {20, 18, 10, 12, 9, 9, 3, 5, 6, 8};
        int n = arr.length;

        System.out.print("Max Heap array : ");
        printArray(arr, n);

        convertMaxHeap(arr, n);

        System.out.print("Min Heap array : ");
        printArray(arr, n);

        
    }

    static void MinHeapify(int[] arr, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if (l < n && arr[l] < arr[i])
            smallest = l;
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            MinHeapify(arr, smallest, n);
        }
    }

    static void convertMaxHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; --i)
            MinHeapify(arr, i, n);
    }

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
