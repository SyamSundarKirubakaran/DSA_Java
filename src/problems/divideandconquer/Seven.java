package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Array containing 0s before 1s, count 1s
 */
public class Seven {

    private static final int[] arr = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(countNoOfOnes(arr, arr.length));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int getFirstOne(int[] arr, int start, int end) {
        if (end >= start) {
            int middle = start + (end - start) / 2;
            if ((middle == 0 || arr[middle - 1] == 0) && arr[middle] == 1) {
                return middle;
            }
            return (arr[middle] == 0) ? getFirstOne(arr, middle + 1, end) : getFirstOne(arr, start, middle - 1);
        }
        return -1;
    }

    private static int countNoOfOnes(int[] arr, int size) {
        int first = getFirstOne(arr, 0, size - 1);
        return first == -1 ? 0 : size - first;
    }

}
