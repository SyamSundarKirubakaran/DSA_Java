package algo.sort;

import java.util.Arrays;
import java.util.List;

class QuickSort {

    static List<Integer> unsortedList = Arrays.asList(9, 6, 5, 0, 8, 2, 7, 1);

    public static void main(String[] args) {
        performQuickSort(0, unsortedList.size() - 1);
        printList(unsortedList);
    }

    static int performPartitioning(int startIndex, int endIndex) {
        int pivot = unsortedList.get(endIndex);
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex; j++) {
            if (unsortedList.get(j) <= pivot) {
                i += 1;
                performSwap(i, j);
            }
        }
        performSwap(i + 1, endIndex);
        return i + 1;
    }

    static void performSwap(int i, int j) {
        int temp = unsortedList.get(i);
        unsortedList.set(i, unsortedList.get(j));
        unsortedList.set(j, temp);
    }

    static void performQuickSort(int startIndex, int endIndex) {
        int middleIndex;
        if (startIndex < endIndex) {
            middleIndex = performPartitioning(startIndex, endIndex);
            performQuickSort(startIndex, middleIndex - 1);
            performQuickSort(middleIndex + 1, endIndex);
        }
    }

    static void printList(List<Integer> sortedList) {
        for (Integer integer : sortedList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}