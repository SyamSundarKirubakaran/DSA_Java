package problems.array;

/**
 * @author SYAM K
 * @problem : Find Sub Array whose sum is equals zero
 */
public class TwentyOne {
    static int[] arr = new int[]{8, -2, -3, -4, 5, 4};

    public static void main(String[] args) {
        findZeroSumSubArray(arr, arr.length - 1);
    }

    private static void findZeroSumSubArray(int[] arr, int size) {
        int currentSum;
        for (int i = 0; i <= size; i++) {
            currentSum = 0;
            for (int j = i; j <= size; j++) {
                currentSum += arr[j];
                if (currentSum == 0) {
                    System.out.println("Sub Array from " + (i) + " to " + (j));
                    return;
                }
            }
        }
    }
}
