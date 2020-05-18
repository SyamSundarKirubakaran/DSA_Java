package problems.array;

/**
 * @author SYAM K
 * @problem : Find Duplicates in O(n) time and O(1) space - Array element values are <= Max Index
 */
public class TwentySix {

    private static int[] arr = new int[]{4, 3, 1, 2, 2, 3, 4};

    public static void main(String[] args) {
        findRepeating(arr, arr.length - 1);
    }

    private static void findRepeating(int[] arr, int size) {
        for (int i = 0; i <= size; i++) {
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

}
