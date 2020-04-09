package algo.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */
class QuickSort {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88);
        performQuickSort(integerList, 0, integerList.size() - 1);
        System.out.println(integerList);
    }

    private static void performQuickSort(List<Integer> integerList, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = performPartition(integerList, startIndex, endIndex);
            performQuickSort(integerList, startIndex, partitionIndex - 1);
            performQuickSort(integerList, partitionIndex + 1, endIndex);
        }
    }

    private static int performPartition(List<Integer> integerList, int startIndex, int endIndex) {
        int pivot = integerList.get(endIndex);
        int i = startIndex - 1;
        int valueAtI, valueAtJ;
        for (int j = startIndex; j < endIndex; j++) {
            if (integerList.get(j) <= pivot) {
                i += 1;
                valueAtI = integerList.get(i);
                valueAtJ = integerList.get(j);
                integerList.set(i, valueAtJ);
                integerList.set(j, valueAtI);
            }
        }
        integerList.set(endIndex, integerList.get(i + 1));
        integerList.set(i + 1, pivot);
        return i + 1;
    }

}
