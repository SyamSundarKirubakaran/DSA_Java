package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Rearrange such that a[i] becomes a[a[i]]
 */
public class ZH {

    private static final int[] arr = new int[]{3, 1, 0, 2, 4};

    public static void main(String[] args) {
        rearrange(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * result = a + b * n, where n > a, b
     * <p>
     * Actual,
     * a = result % n
     * b = result / n
     * <p>
     * should swap, ergo
     * b = result % n
     * a = result / n
     * <p>
     * Ultimate formula by combining these 2,
     * <p>
     * a = (result % n) * n
     * <p>
     * Notice a multiplication at the end which is got by
     * bringing `n` in `result / n` to the other side.
     */

    private static void rearrange(int[] arr, int size) {
        for (int i = 0; i <= size; i++) {
            System.out.println("I. " + arr[i]);
            arr[i] += (arr[arr[i]] % (size + 1)) * (size + 1);
            System.out.println("II. " + arr[i]);
        }
        for (int i = 0; i <= size; i++) {
            System.out.println("III. " + arr[i]);
            arr[i] /= (size + 1);
            System.out.println("IV. " + arr[i]);
        }
    }

}
