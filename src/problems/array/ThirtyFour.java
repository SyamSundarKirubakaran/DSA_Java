package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Rearrange such that a[i] becomes a[a[i]]
 */
public class ThirtyFour {

    private static int[] arr = new int[]{3, 1, 0, 2, 4};

    public static void main(String[] args) {
        rearrange(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange(int[] arr, int size) {
        for (int i = 0; i <= size; i++) {
            arr[i] += (arr[arr[i]] % (size + 1)) * (size + 1);
        }
        for (int i = 0; i <= size; i++) {
            arr[i] /= (size + 1);
        }
    }

}
