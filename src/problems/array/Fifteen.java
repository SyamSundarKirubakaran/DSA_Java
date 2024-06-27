package problems.array;

/**
 * @author SYAM K
 * @problem : Find the Equilibrium Index .i.e., left sum and right sum of index should be equal - Less Space Complexity.
 */

public class Fifteen {
    static int[] arr = new int[]{10, 5, 15, 3, 4, 21, 2};

    public static void main(String[] args) {
        findEquilibiriumIndex(arr, arr.length - 1);
    }

    static void findEquilibiriumIndex(int[] arr, int size) {
        int leftSum = 0, sum = 0;
        for (int i = 0; i <= size; i++) {
            sum += arr[i];
        }
        for (int i = 0; i <= size; i++) {
            sum -= arr[i];
            leftSum += arr[i];
            if (leftSum == sum) {
                System.out.println(i);
                break;
            }
        }
    }
}