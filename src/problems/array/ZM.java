package problems.array;

/**
 * @author SYAM K
 * @problem : Find Duplicates in O(n) time and O(1) space - Array element values are ≤ Max Index - GFG
 */
public class ZM {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2, 2, 3, 4};
        int arr_size = arr.length;

        System.out.println("The repeating elements are: ");
        printRepeating(arr, arr_size);
    }

    static void printRepeating(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1)
                System.out.println(i + " ");
        }
    }
}

