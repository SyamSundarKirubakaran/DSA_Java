package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Longest Decreasing Sub Sequence
 */
public class Seven {

    private static final int[] arr = new int[]{2, 10, 11, 5, 3, 4, 12, 1};

    public static void main(String[] args) {
        findLds(arr, arr.length);
    }

    private static void findLds(int[] arr, int length) {
        int[] lds = new int[length];
        lds = Arrays.stream(lds).map(x -> 1).toArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (arr[j] < arr[i] && lds[j] + 1 > lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(lds));
        int maxIndex = findMaxIndex(lds, length);
        System.out.println(maxIndex);
        printSequence(arr, lds, length, maxIndex);
    }

    private static void printSequence(int[] arr, int[] lds, int length, int maxIndex) {
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(arr[maxIndex]);
        for (int i = maxIndex - 1; i < length; i++) {
            if (arr[i] < arr[maxIndex] && lds[i] < arr[maxIndex]) {
                if (lds[maxIndex] - lds[i] > 1) {
                    continue;
                } else {
                    finalResult.add(arr[i]);
                }
                maxIndex = i;
            }
        }
        System.out.println(finalResult);
    }

    private static int findMaxIndex(int[] lds, int length) {
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (lds[i] > lds[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
