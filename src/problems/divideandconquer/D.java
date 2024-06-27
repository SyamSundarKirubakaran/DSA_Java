package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Search an element in a sorted Rotated Array
 */
public class D {

    private static final int[] arr = new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        

        System.out.println(performSearch(arr, 0, arr.length - 1, 4));

        
    }

    private static int performSearch(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (arr[middle] == key) {
            return middle;
        }
        if (arr[start] <= arr[middle]) {
            return (key >= arr[start] && key <= arr[middle]) ?
                    performSearch(arr, start, middle - 1, key) :
                    performSearch(arr, middle + 1, end, key);
        }
        return (key >= arr[middle] && key <= arr[end]) ?
                performSearch(arr, middle + 1, end, key) :
                performSearch(arr, start, middle - 1, key);
    }

}
