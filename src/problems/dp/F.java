package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Longest Increasing Sub Sequence
 */
public class F {

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
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(lis));
        int maxIndex = finMaxIndex(lis, length);
        System.out.println(maxIndex);
        findSequence(lis, arr, maxIndex);
    }

    private static int finMaxIndex(int[] lis, int length) {
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (lis[i] > lis[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void findSequence(int[] lis, int[] arr, int maxIndex) {
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(arr[maxIndex]);
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (lis[i] < lis[maxIndex] && arr[i] < arr[maxIndex]) {
                if (lis[maxIndex] - lis[i] > 1) {
                    continue;
                } else {
                    finalResult.add(arr[i]);
                }
                maxIndex = i;
            }
        }
        System.out.println(finalResult);
    }

}
