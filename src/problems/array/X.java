package problems.array;

/**
 * @author SYAM K
 * @problem : Construct a product array such that the ith element in product array contains the product of all the remaining elements but i (Without Division) - Less Time Complexity
 */
public class X {
    private static int[] arr = new int[]{1, 2, 3, 4};

    public static void main(String[] args) {
        printArray(buildProductArray(arr, arr.length - 1));
    }

    private static int[] buildProductArray(int[] arr, int size) {
        int temp = 1;
        int[] product = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            product[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for (int i = size; i >= 0; i--) {
            product[i] *= temp;
            temp *= arr[i];
        }
        return product;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
