package algo.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */

class InsertionSort {
    public static void main(String[] args) {
        System.out.println(performInsertionSort(Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88)));
    }

    private static List<Integer> performInsertionSort(List<Integer> integerList) {
        int i, currentValue;
        for (int j = 1; j < integerList.size(); j++) {
            currentValue = integerList.get(j);
            i = j - 1;
            while (i >= 0 && integerList.get(i) > currentValue) {
                integerList.set(i + 1, integerList.get(i));
                i -= 1;
            }
            integerList.set(i + 1, currentValue);
        }
        return integerList;
    }
}
