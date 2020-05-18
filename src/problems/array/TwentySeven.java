package problems.array;

/**
 * @author SYAM K
 * @problem : Find 2 repeating elements in a given array - XOR - Given (n+2) elements - 1 ≤ a[i] ≤ n - All elements from 1 to n occurs at least once (Except the 2 numbers that occurs twice)
 */
public class TwentySeven {
    private static int[] arr = new int[]{2, 1, 2, 3, 4, 1}; // only 2 elements are repeated twice

    public static void main(String[] args) {
        findRepeating(arr, arr.length - 1);
    }

    private static void findRepeating(int[] arr, int size) {
        int setBit, x = 0, y = 0, xorResult = arr[0], n = size - 1, index;
        for (index = 1; index <= size; index++) {
            xorResult ^= arr[index];
        }
        for (index = 1; index <= n; index++) {
            xorResult ^= index;
        }
        setBit = xorResult & ~(xorResult - 1);
        for (index = 0; index <= size; index++) {
            if ((arr[index] & setBit) != 0) {
                x ^= arr[index];
            } else {
                y ^= arr[index];
            }
        }
        for (index = 1; index <= n; index++) {
            if ((index & setBit) != 0) {
                x ^= index;
            } else {
                y ^= index;
            }
        }
        System.out.println("The 2 repeating numbers are " + x + " and " + y);
    }

}
