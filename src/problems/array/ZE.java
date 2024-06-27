package problems.array;

/**
 * @author SYAM K
 * @problem : Trapping Rain Water Problem
 */
public class ZE {
    private static int[] arr = new int[]{1, 0, 2, 0, 1, 0, 3, 1, 0, 2};

    public static void main(String[] args) {
        int result = findWaterCapacity(arr, arr.length - 1);
        System.out.println(result);
    }

    private static int findWaterCapacity(int[] arr, int size) {
        int[] left = new int[size + 1];
        int[] right = new int[size + 1];
        int capacity = 0;
        left[0] = arr[0];
        for (int i = 1; i <= size; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        right[size] = arr[size];
        for (int i = size - 1; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        for (int i = 0; i <= size; i++) {
            capacity += Math.min(left[i], right[i]) - arr[i];
        }
        return capacity;
    }

}
