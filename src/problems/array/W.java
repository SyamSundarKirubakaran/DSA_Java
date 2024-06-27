package problems.array;

/**
 * @author SYAM K
 * @problem : Construct a product array such that the ith element in product array contains the product of all the remaining elements but i (Without Division)
 */
public class W {

    private static int[] arr = new int[]{1, 2, 3, 4};

    public static void main(String[] args) {
        buildProductArray(arr, arr.length - 1);
    }

    private static void buildProductArray(int[] arr, int size) {
        int[] leftToRight = new int[size + 1];
        int[] rightToLeft = new int[size + 1];
        leftToRight[0] = arr[0];
        for (int i = 1; i <= size; i++) {
            leftToRight[i] = arr[i] * leftToRight[i - 1];
        }
        rightToLeft[size] = arr[size];
        for (int i = size - 1; i >= 0; i--) {
            rightToLeft[i] = arr[i] * rightToLeft[i + 1];
        }
        System.out.print(rightToLeft[1] + " ");
        for (int i = 0; i <= size - 2; i++) {
            System.out.print((leftToRight[i] * rightToLeft[i + 2]) + " ");
        }
        System.out.print(leftToRight[size - 1]);
    }
}
