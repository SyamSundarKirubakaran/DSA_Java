package algo.sort;

class HeapSort {
    static int[] arr = new int[]{22, 33, 11, 55, 99, 77, 66, 88};

    public static void main(String[] args) {
        performHeapSort(arr.length - 1);
        printArray();
    }

    static void maxHeapify(int parent, int size) {
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int largest = parent;
        if (leftChild <= size && arr[leftChild] > arr[parent])
            largest = leftChild;
        if (rightChild <= size && arr[rightChild] > arr[largest])
            largest = rightChild;
        if (largest != parent) {
            swap(parent, largest);
            maxHeapify(largest, size);
        }
    }

    static void buildMaxHeap(int size) {
        for (int i = (size / 2); i >= 0; i--) {
            maxHeapify(i, size);
        }
    }

    static void performHeapSort(int size) {
        buildMaxHeap(size);
        int newSize = size;
        for (int i = size; i > 0; i--) {
            swap(0, newSize);
            newSize -= 1;
            maxHeapify(0, newSize);
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}