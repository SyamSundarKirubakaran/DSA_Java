package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Perfect Hill Sequence
 */
public class H {

    private static final int[] arr = new int[]{10, 15, 16, 9, 4, 3, 11, 1};

    public static void main(String[] args) {
        List<Integer> lis = findLis(arr, arr.length);
        System.out.println();
        List<Integer> lds = findLds(arr, arr.length);
        System.out.println();
        formHill(lis, lis.size(), lds, lds.size());
    }

    private static void formHill(List<Integer> lis, int lisSize, List<Integer> lds, int ldsSize) {
        Collections.sort(lis); // bottom to top of the hill
        if (!lis.get(lisSize - 1).equals(lds.get(0))) {
            System.out.println("Error occurred");
        } else {
            List<Integer> hillEntries = new ArrayList<>();
            if (lisSize < ldsSize) {
                hillEntries.addAll(lis);
                for (int i = 1; i <= lisSize - 1; i++) { // middle element occurs twice, therefore start from 1
                    hillEntries.add(lds.get(i));
                }
            } else { // lisSize > ldsSize
                for (int i = 0; i <= ldsSize; i++) {
                    hillEntries.add(lis.get(0));
                }
                for (int i = 1; i <= ldsSize - 1; i++) { // middle element occurs twice, therefore start from 1
                    hillEntries.add(lds.get(0));
                }
            }
            System.out.println("Hill Seq: " + hillEntries);
        }
    }

    private static List<Integer> findLds(int[] arr, int length) {
        int[] lds = new int[length];
        lds = Arrays.stream(lds).map(x -> 1).toArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (arr[i] > arr[j] && (lds[j] + 1) > lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("lds: " + Arrays.toString(lds));
        int maxIndex = findMax(lds);
        System.out.println("Max Index: " + maxIndex);
        return printLds(arr, lds, length, maxIndex);
    }

    private static List<Integer> printLds(int[] arr, int[] lds, int length, int maxIndex) {
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(arr[maxIndex]);
        for (int i = maxIndex + 1; i < length; i++) {
            if (arr[i] < arr[maxIndex] && lds[i] < lds[maxIndex]) {
                if (lds[maxIndex] - lds[i] > 1) {
                    continue;
                } else {
                    finalResult.add(arr[i]);
                }
                maxIndex = i;
            }
        }
        System.out.println("lds seq: " + finalResult);
        return finalResult;
    }

    private static List<Integer> findLis(int[] arr, int length) {
        int[] lis = new int[length];
        lis = Arrays.stream(lis).map(x -> 1).toArray();
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && (lis[j] + 1) > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("lis: " + Arrays.toString(lis));
        int maxIndex = findMax(lis);
        System.out.println("Max Index: " + maxIndex);
        return printLis(arr, lis, maxIndex);
    }

    private static List<Integer> printLis(int[] arr, int[] lis, int maxIndex) {
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(arr[maxIndex]);
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (arr[i] < arr[maxIndex] && lis[i] < lis[maxIndex]) {
                if (lis[maxIndex] - lis[i] > 1) {
                    continue;
                } else {
                    finalResult.add(arr[i]);
                }
                maxIndex = i;
            }
        }
        System.out.println("lis seq: " + finalResult);
        return finalResult;
    }

    private static int findMax(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
