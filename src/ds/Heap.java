package ds;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */
class Heap {
    public static void main(String[] args) {
        List<Integer> maxIntegerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88);
        List<Integer> minIntegerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88);
        int heapSizeMax = maxIntegerList.size() - 1;
        int heapSizeMin = minIntegerList.size() - 1;

        // Max Heap Operations
        constructMaxHeap(maxIntegerList, heapSizeMax);
        System.out.println("Max Heap:" + maxIntegerList);
        increaseMaxHeapValue(maxIntegerList, 2, 100, heapSizeMax);
        System.out.println("Max Heap After value increase to 100 @ index:2 : " + maxIntegerList);
        reduceMaxHeapValue(maxIntegerList, 2, 1, heapSizeMax);
        System.out.println("Max Heap After value reduce to 11 @ index:2 : " + maxIntegerList);
        int maxValue = extractMax(maxIntegerList, heapSizeMax);
        System.out.println("Max value: " + maxValue);

        // Min Heap Operations
        constructMinHeap(minIntegerList, heapSizeMin);
        System.out.println("Min Heap:" + minIntegerList);
        int minValue = extractMin(minIntegerList, heapSizeMin);
        System.out.println("Min Value: " + minValue);
    }

    private static void reduceMaxHeapValue(List<Integer> integerList, int index, int newValue, int heapSize) {
        if (newValue >= integerList.get(index)) return;
        integerList.set(index, newValue);
        maxHeapify(integerList, index, heapSize);
    }

    private static void increaseMaxHeapValue(List<Integer> integerList, int index, int newValue, int heapSize) {
        if (newValue <= integerList.get(index)) return;
        integerList.set(index, newValue);
        while (index >= 0 && integerList.get(index / 2) < integerList.get(index)) {
            performSwap(integerList, index / 2, index);
            index /= 2;
        }
    }

    private static int extractMin(List<Integer> integerList, int heapSize) {
        performSwap(integerList, 0, heapSize);
        int minValue = integerList.get(heapSize);
        heapSize -= 1;
        minHeapify(integerList, 0, heapSize);
        return minValue;
    }

    private static int extractMax(List<Integer> integerList, int heapSize) {
        performSwap(integerList, 0, heapSize);
        int maxValue = integerList.get(heapSize);
        heapSize -= 1;
        maxHeapify(integerList, 0, heapSize);
        return maxValue;
    }

    private static void constructMinHeap(List<Integer> integerList, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            minHeapify(integerList, i, heapSize);
        }
    }

    private static void constructMaxHeap(List<Integer> integerList, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(integerList, i, heapSize);
        }
    }

    private static void minHeapify(List<Integer> integerList, int parent, int heapSize) {
        int leftChild = parent * 2;
        int rightChild = parent * 2 + 1;
        int least = parent;
        if (leftChild <= heapSize && integerList.get(leftChild) < integerList.get(least))
            least = leftChild;
        if (rightChild <= heapSize && integerList.get(rightChild) < integerList.get(least))
            least = rightChild;
        if (least != parent) {
            performSwap(integerList, parent, least);
            minHeapify(integerList, least, heapSize);
        }
    }

    private static void maxHeapify(List<Integer> integerList, int parent, int heapSize) {
        int leftChild = parent * 2;
        int rightChild = parent * 2 + 1;
        int largest = parent;
        if (leftChild <= heapSize && integerList.get(leftChild) > integerList.get(largest))
            largest = leftChild;
        if (rightChild <= heapSize && integerList.get(rightChild) > integerList.get(largest))
            largest = rightChild;
        if (largest != parent) {
            performSwap(integerList, largest, parent);
            maxHeapify(integerList, largest, heapSize);
        }
    }

    private static void performSwap(List<Integer> integerList, int i, int j) {
        if (i != j && !integerList.get(i).equals(integerList.get(j))) {
            integerList.set(i, integerList.get(i) + integerList.get(j));
            integerList.set(j, integerList.get(i) - integerList.get(j));
            integerList.set(i, integerList.get(i) - integerList.get(j));
        }
    }

}
