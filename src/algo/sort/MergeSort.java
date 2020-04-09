package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */

class MergeSort {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88);
        performMergeSort(integerList, 0, integerList.size() - 1);
        System.out.println(integerList);
    }

    private static void performMergeSort(List<Integer> integerList, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            performMergeSort(integerList, startIndex, middleIndex);
            performMergeSort(integerList, middleIndex + 1, endIndex);
            performMerge(integerList, startIndex, middleIndex, endIndex);
        }
    }


    private static void performMerge(List<Integer> integerList, int startIndex, int middleIndex, int endIndex) {
        int leftListSize = middleIndex - startIndex + 1;
        int rightListSize = endIndex - middleIndex;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < leftListSize; i++)
            leftList.add(integerList.get(startIndex + i));
        for (int j = 0; j < rightListSize; j++)
            rightList.add(integerList.get((middleIndex + 1) + j));
        leftList.add(Integer.MAX_VALUE);
        rightList.add(Integer.MAX_VALUE);
        int i = 0, j = 0;
        for (int k = startIndex; k <= endIndex; k++) {
            if (leftList.get(i) <= rightList.get(j)) {
                integerList.set(k, leftList.get(i));
                i += 1;
            } else {
                integerList.set(k, rightList.get(j));
                j += 1;
            }
        }
    }
}
