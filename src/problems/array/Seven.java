package problems.array;

/**
 * @author SYAM K
 * @problem : Largest Difference such that the smaller number appears before larger number - Less space complexity
 */

class Seven {
    static int[] arr = new int[]{3, 1, 4, 7, 5, 100, 10};

    public static void main(String[] args) {
        int result = maxSumSubArray(arr, arr.length - 1);
        System.out.println(result);
    }

    static int maxSumSubArray(int[] arr, int size) {
        int prevDifference = arr[1] - arr[0];
        int maxDiff = arr[1] - arr[0];
        int currentDiff;
        for (int i = 1; i < size; i++) {
            currentDiff = arr[i + 1] - arr[i];
            if (prevDifference > 0) {
                currentDiff += prevDifference;
            }
            maxDiff = max(maxDiff, currentDiff);
            prevDifference = currentDiff;
        }
        return maxDiff;
    }

    static int max(int val1, int val2) {
        return Math.max(val1, val2);
    }
}