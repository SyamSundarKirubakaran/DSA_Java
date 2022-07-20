package problems.divideandconquer;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Array has 2n elements -> `a1, a2, a3, .., an, b1, b2, .. , bn` -> shuffle -> `a1, b1, a2, b2, .., an, bn`
 */
public class Eight {

    private static final int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        

        shuffleArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        
    }

    private static void shuffleArray(int[] arr, int left, int right) {
        if (right - left == 1) {
            return;
        }
        int middle = (left + right) / 2;
        int temp = middle + 1;
        int leftMid = (left + middle) / 2;
        for (int i = leftMid + 1; i <= middle; i++) {
            swap(arr, i, temp);
            temp += 1;
        }
        shuffleArray(arr, left, middle);
        shuffleArray(arr, middle + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
