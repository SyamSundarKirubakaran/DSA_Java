package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Sorted Array of non-repeating elements, find if there's `i` for which `a[i] = i`
 */
public class Nine {

    private static final int[] arr = new int[]{-1, 0, 2, 4, 8, 9, 10};
    // if multiple positions meets the conditions
    // returns first encounter .ie., middle

    public static void main(String[] args) {


        System.out.println(binarySearch(arr, 0, arr.length - 1));


    }

    private static int binarySearch(int[] arr, int low, int high) {
        if (high >= low) {
            int middle = (low + high) / 2;
            if (middle == arr[middle]) {
                return middle;
            }
            if (middle > arr[middle]) {
                return binarySearch(arr, middle + 1, high);
            } else {
                return binarySearch(arr, low, middle - 1);
            }
        }
        return -1;
    }

}
