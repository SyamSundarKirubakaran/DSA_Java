package problems.divideandconquer;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Bolt and Nuts
 */
public class Two {

    private static final char[] bolts = new char[]{'*', '$', '@', '#', '!'};
    private static final char[] nuts = new char[]{'$', '*', '#', '@', '!'};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        matchNutsBolts(nuts, bolts, 0, bolts.length - 1);
        System.out.println("Bolts: " + Arrays.toString(bolts));
        System.out.println("Nuts: " + Arrays.toString(nuts));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void matchNutsBolts(char[] nuts, char[] bolts, int start, int end) {
        if (start < end) {
            int pivot = partition(nuts, start, end, bolts[end]);
            partition(bolts, start, end, nuts[pivot]);
            matchNutsBolts(nuts, bolts, start, pivot - 1);
            matchNutsBolts(nuts, bolts, pivot + 1, end);
        }
    }

    private static int partition(char[] arr, int start, int end, char pivot) {
        int index = start;
        for (int index2 = start; index2 < end; index2++) {
            if (arr[index2] < pivot) { // comparing ASCII values
                swap(arr, index2, index);
                index += 1;
            } else if (arr[index2] == pivot) {
                swap(arr, index2, end);
                index2 -= 1;
            }
        }
        swap(arr, index, end);
        return index;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
