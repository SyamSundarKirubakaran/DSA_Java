package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Find Peek Element
 */
public class Fourteen {

    private static final int[] arr = new int[]{1, 2, 10, 15, 16, 17, 44, 20, 9, 5, 4};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(getMaxElement(arr, 0, arr.length - 1));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int getMaxElement(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        if ((end == start + 1) && arr[start] >= arr[end]) {
            return arr[start];
        }
        if ((end == start + 1) && arr[start] < arr[end]) {
            return arr[end];
        }
        int middle = (start + end) / 2;
        if (arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]) {
            return arr[middle];
        }
        return (arr[middle - 1] > arr[middle] && arr[middle] > arr[middle + 1]) ?
                getMaxElement(arr, start, middle - 1) : getMaxElement(arr, middle + 1, end);
    }

}