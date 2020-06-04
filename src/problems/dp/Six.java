package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Longest Increasing Sub Sequence
 */
public class Six {

    private static final int[] arr = new int[]{2, 3, 1, 5, 12, 10, 11};

    public static void main(String[] args) {
        findLis(arr, arr.length);
    }

    private static void findLis(int[] arr, int length) {
        int[] lis = new int[length];
        lis = Arrays.stream(lis).map(x -> 1).toArray();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int maxLengthIndex = 0;
        for (int i = 0; i < length; i++) {
            if (lis[i] > lis[maxLengthIndex]) {
                maxLengthIndex = i;
            }
        }
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(arr[maxLengthIndex]);
        for (int i = maxLengthIndex - 1; i >= 0; i--) {
            if (lis[i] < lis[maxLengthIndex] && arr[i] < arr[maxLengthIndex]) {
                if (lis[maxLengthIndex] - lis[i] > 1) {
                    continue;
                } else {
                    finalResult.add(arr[i]);
                }
                maxLengthIndex = i;
            }
        }
        System.out.println(finalResult);
    }

}
