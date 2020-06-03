package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Maximum Sum Increasing Sub Sequence [OR] Longest increasing Sub Sequence
 */
public class Two {

    private static final int[] arr = new int[]{20, 3, 1, 15, 16, 2, 12, 13};

    public static void main(String[] args) {
        construct(arr, arr.length);
    }

    private static void construct(int[] arr, int length) {
        int[] lis = new int[length];
        lis[0] = arr[0];
        int chosenIndex;
        int maxSoFarIndex = 0;
        for (int i = 1; i < length; i++) {
            chosenIndex = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (chosenIndex == -1 || arr[j] > arr[chosenIndex]) {
                        chosenIndex = j;
                    }
                }
            }
            if (chosenIndex != -1) {
                lis[i] = arr[i] + lis[chosenIndex];
            } else {
                lis[i] = arr[i];
            }
            if (lis[i] > lis[maxSoFarIndex]) {
                maxSoFarIndex = i;
            }
        }
        System.out.println(Arrays.toString(lis));
        findElements(arr, lis, maxSoFarIndex);
    }

    private static void findElements(int[] arr, int[] lis, int maxSoFarIndex) {
        int maxSum = lis[maxSoFarIndex];
        System.out.print(arr[maxSoFarIndex] + " ");
        while (maxSum > 0) {
            maxSum -= arr[maxSoFarIndex];
            for (int i = maxSoFarIndex - 1; i >= 0; i--) {
                if (lis[i] == maxSum) {
                    System.out.print(arr[i] + " ");
                    maxSoFarIndex = i;
                    break;
                }
            }
        }
    }

}
