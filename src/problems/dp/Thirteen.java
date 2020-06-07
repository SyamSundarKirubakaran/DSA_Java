package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Partition Problem
 */
public class Thirteen {

    private static final int[] arr = new int[]{4, 10, 5, 15, 3, 1};

    public static void main(String[] args) {
        System.out.println(findPartition(arr, arr.length));
    }

    // If you find a subset whose sum == half the whole sum, the other sub set sum is also == half
    private static boolean findPartition(int[] arr, int length) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0)
            return false;
        boolean[][] partition = new boolean[length + 1][sum / 2 + 1];
        for (int i = 0; i <= length; i++) {
            partition[i][0] = true;
        }
        for (int i = 0; i <= sum / 2; i++) {
            partition[0][i] = false;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j >= arr[i - 1]) {
                    partition[i][j] = partition[i - 1][j] || partition[i - 1][j - arr[i - 1]];
                } else {
                    partition[i][j] = partition[i - 1][j];
                }
            }
        }
        return partition[length][sum / 2];
    }

}
