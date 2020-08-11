package problems.array;

/**
 * @author SYAM K
 * @problem : Find Duplicates in O(n) time and O(1) space - Array element values are <= Max Index
 */
public class TwentySix {

    private static final int[] arr = new int[]{4, 3, 1, 2, 2, 3, 4};

    public static void main(String[] args) {
        findRepeating(arr, arr.length - 1);
    }

    private static void findRepeating(int[] arr, int size) {
        for (int i = 0; i <= size; i++) {
            int absoluteValue = Math.abs(arr[i]);
            if (arr[absoluteValue] >= 0) {
                arr[absoluteValue] = -arr[absoluteValue];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

}
