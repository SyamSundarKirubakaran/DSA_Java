package algo.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */
class HeapSort {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88);
        performMaxHeapSort(integerList);
        System.out.println(integerList);
    }

    private static void performMaxHeapSort(List<Integer> integerList) {
        int heapSize = integerList.size() - 1;
        buildMaxHeap(integerList, heapSize);
        for (int i = integerList.size() - 1; i >= 0; i--) {
            swap(integerList, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(integerList, 0, heapSize);
        }
    }

    private static void buildMaxHeap(List<Integer> integerList, int heapSize) {
        for (int i = (integerList.size() - 1) / 2; i >= 0; i--) {
            maxHeapify(integerList, i, heapSize);
        }
    }

    private static void maxHeapify(List<Integer> integerList, int parent, int heapSize) {
        int leftChild = parent * 2;
        int rightChild = leftChild + 1;
        int largest = parent;
        if (leftChild <= heapSize && integerList.get(leftChild) > integerList.get(largest))
            largest = leftChild;
        if (rightChild <= heapSize && integerList.get(rightChild) > integerList.get(largest))
            largest = rightChild;
        if (largest != parent) {
            swap(integerList, largest, parent);
            maxHeapify(integerList, largest, heapSize);
        }
    }

    private static void swap(List<Integer> integerList, int i, int j) {
        if (i != j && !integerList.get(i).equals(integerList.get(j))) {
            integerList.set(i, integerList.get(i) + integerList.get(j));
            integerList.set(j, integerList.get(i) - integerList.get(j));
            integerList.set(i, integerList.get(i) - integerList.get(j));
        }
    }
}
