package algo.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 */
public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88);
        performBubbleSort(integerList);
        System.out.println(integerList);
    }

    private static void performBubbleSort(List<Integer> integerList) {
        boolean swapPerformed;
        for (int i = 0; i < integerList.size(); i++) {
            swapPerformed = false;
            for (int j = 0; j < integerList.size() - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    swap(integerList, j, j + 1);
                    swapPerformed = true;
                }
            }
            if (!swapPerformed) break;
        }
    }

    public static void swap(List<Integer> integerList, int i, int j) {
        if (i != j && !integerList.get(i).equals(integerList.get(j))) {
            integerList.set(i, integerList.get(i) + integerList.get(j));
            integerList.set(j, integerList.get(i) - integerList.get(j));
            integerList.set(i, integerList.get(i) - integerList.get(j));
        }
    }
}
