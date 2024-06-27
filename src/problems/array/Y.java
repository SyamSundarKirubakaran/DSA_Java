package problems.array;

/**
 * @author SYAM K
 * @problem : Sort a nearly sorted array, each element can be misplaced by a max of k digits before or after
 */
public class Y {
    static int[] arr = new int[]{10, 27, 20, 17, 16, 12, 13, 14, 15};

    public static void main(String[] args) {
        performKWindowSorting(arr, arr.length - 1, 4);
        printArray(arr);
    }

    private static void performKWindowSorting(int[] arr, int size, int k) {
        int current, j, counter;
        for (int i = 1; i <= size; i++) {
            current = arr[i];
            counter = k;
            for (j = i; j >= 0 && arr[j - 1] > current && counter > 0; j--, counter--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = current;
        }
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
