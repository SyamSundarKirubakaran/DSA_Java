package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Get first 1.
 */
public class Fifteen {

    private static final int[] arr = new int[]{0, 0, 0, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(getFirstOne(arr, 0, arr.length));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int getFirstOne(int[] arr, int start, int end) {
        if (end >= start) {
            int middle = start + (end - start) / 2;
            if ((middle == 1 || arr[middle - 1] == 0) && arr[middle] == 1) {
                return middle;
            }
            return (arr[middle] == 0) ? getFirstOne(arr, middle + 1, end) : getFirstOne(arr, start, middle - 1);
        }
        return -1;
    }

}
