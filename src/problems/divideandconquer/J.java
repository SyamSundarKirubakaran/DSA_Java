package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : `a[0]..a[i]` -> increasing, `a[i+1]..a[n]` -> decreasing, find i
 */
public class J {

    private static final int[] arr = new int[]{1, 2, 10, 15, 16, 17, 44, 20, 9, 5, 4};

    public static void main(String[] args) {
        

        System.out.println(getMaxElement(arr, 0, arr.length - 1));

        
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
