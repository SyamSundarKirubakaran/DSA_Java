package algo.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */
public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88, 12, 96);
        performSelectionSort(integerList);
        System.out.print(integerList);
    }

    private static void performSelectionSort(List<Integer> integerList) {
        int minValue, minIndex;
        for (int i = 0; i < integerList.size() - 1; i++) {
            minValue = integerList.get(i);
            minIndex = i;
            for (int j = i + 1; j < integerList.size(); j++) {
                if (integerList.get(j) < minValue) {
                    minValue = integerList.get(j);
                    minIndex = j;
                }
            }
            if (minIndex != i)
                swap(integerList, minIndex, i);
        }
    }

    private static void swap(List<Integer> integerList, int i, int j) {
        if (i != j && integerList.get(i) != integerList.get(j)) {
            integerList.set(i, integerList.get(i) + integerList.get(j));
            integerList.set(j, integerList.get(i) - integerList.get(j));
            integerList.set(i, integerList.get(i) - integerList.get(j));
        }
    }

}
