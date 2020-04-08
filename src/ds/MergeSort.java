package ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */

public class MergeSort {
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
        int n1 = middleIndex - startIndex + 1;
        int n2 = endIndex - middleIndex;
        ArrayList<Integer> leftSet = new ArrayList<>(n1);
        ArrayList<Integer> rightSet = new ArrayList<>(n2);
        for (int i = 0; i < n1; i++)
            leftSet.add(integerList.get(startIndex + i));
        for (int j = 0; j < n2; j++)
            rightSet.add(integerList.get((middleIndex + 1) + j));
        leftSet.add(Integer.MAX_VALUE);
        rightSet.add(Integer.MAX_VALUE);
        int i = 0, j = 0;
        for (int k = startIndex; k <= endIndex; k++) {
            if (leftSet.get(i) <= rightSet.get(j)) {
                integerList.set(k, leftSet.get(i));
                i += 1;
            } else {
                integerList.set(k, rightSet.get(j));
                j += 1;
            }
        }
    }
}
