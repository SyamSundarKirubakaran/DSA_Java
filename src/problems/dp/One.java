package problems.dp;

/**
 * @author SYAM K
 * @problem : Maximum Sum Sub Array
 */
public class One {

    private static final int[] arr = new int[]{10, -5, -3, 4, 2, 12, -8, -12, 19};
    private static final int[] arr1 = new int[]{-3, 10, 5, -20, 4, 11, -5, 7};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        construct(arr, arr.length);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void construct(int[] arr, int length) {
        int currentSum = arr[0];
        int maxSoFar = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
                continue;
            }
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
                maxIndex = i;
            }
        }
        System.out.println("Max: " + maxSoFar + ", Index: " + maxIndex);
        findElements(arr, maxSoFar, maxIndex);
        System.out.println();
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
