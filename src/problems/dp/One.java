package problems.dp;

/**
 * @author SYAM K
 * @problem : Maximum Sum Sub Array
 */
public class One {

    private static final int[] arr = new int[]{10, -5, -3, 4, 2, 12, -8, -12, 19};

    public static void main(String[] args) {
        construct(arr, arr.length);
    }

    private static void construct(int[] arr, int length) {
        int currentSum = arr[0];
        int maxSoFar = arr[0];
        int maxIndex = 0;
        for (int i = 1; i <= length - 1; i++) {
            currentSum += arr[i];
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
                maxIndex = i;
            }
        }
        System.out.println("Max: " + maxSoFar + ", Index: " + maxIndex);
        findElements(arr, maxSoFar, maxIndex);
    }

    private static void findElements(int[] arr, int maxSoFar, int maxIndex) {
        for (int i = maxIndex; i >= 0; i--) {
            if (maxSoFar > 0) {
                System.out.print(arr[i] + " ");
                maxSoFar -= arr[i];
            } else break;
        }
    }

}
