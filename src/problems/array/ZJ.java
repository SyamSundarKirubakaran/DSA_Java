package problems.array;

/**
 * @author SYAM K
 * @problem : Count number of occurrences (or frequency) in a sorted array
 */
public class ZJ {

    private static int[] arr = new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 7, 10};

    public static void main(String[] args) {
        findRange(arr, arr.length, 3);
    }

    private static void findRange(int[] arr, int size, int k) {
        int start = findStart(arr, 0, size - 1, k);
        int end = findEnd(arr, 0, size - 1, k, arr.length);
        System.out.println(end - start + 1);
    }

    private static int findStart(int[] arr, int start, int end, int k) {
        if (start <= end) {
            int middle = start + (end - start) / 2;
            if ((middle == 0 || arr[middle - 1] < k) && arr[middle] == k)
                return middle;
            else if (arr[middle] < k)
                return findStart(arr, (middle + 1), end, k);
            else
                return findStart(arr, start, (middle - 1), k);
        }
        return -1;
    }

    private static int findEnd(int[] arr, int start, int end, int k, int n) {
        if (start <= end) {
            int middle = start + (end - start) / 2;
            if ((middle == n - 1 || arr[middle + 1] > k) && arr[middle] == k)
                return middle;
            else if (arr[middle] < k)
                findEnd(arr, (middle + 1), end, k, n);
            else
                findEnd(arr, start, (middle - 1), k, n);
        }
        return -1;
    }
}
