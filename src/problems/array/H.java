package problems.array;

/**
 * @author SYAM K
 * @problem : Largest Difference such that the smaller number appears before larger number - Min So Far
 */

public class H {
    static int[] arr = new int[]{3, 1, 4, 7, 5, 100, 10};

    public static void main(String[] args) {
        int result = findMaxDiff(arr, arr.length - 1);
        System.out.println(result);
    }

    static int findMaxDiff(int[] arr, int size) {
        int minElementSoFar = arr[0];
        int currentDiff;
        int maxDiff = arr[1] - arr[0];
        for (int i = 1; i <= size; i++) {
            if (arr[i] < minElementSoFar) {
                minElementSoFar = arr[i];
            } else {
                currentDiff = arr[i] - minElementSoFar;
                maxDiff = max(currentDiff, maxDiff);
            }
        }
        return maxDiff;
    }

    static int max(int val1, int val2) {
        return Math.max(val1, val2);
    }

}