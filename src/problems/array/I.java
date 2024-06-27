package problems.array;

/**
 * @author SYAM K
 * @problem : Find the number occurring odd number of times in the given array(Only one element occurs odd number of times)
 */

public class I {
    static int[] arr = new int[]{1, 1, 3, 2, 4, 4, 2, 3, 4};

    public static void main(String[] args) {
        int result = findOddNoOfElements(arr);
        System.out.println(result);
    }

    static int findOddNoOfElements(int[] arr) {
        int result = 0;
        for (int value : arr) {
            result ^= value; // XOR operator
        }
        return result;
    }
}