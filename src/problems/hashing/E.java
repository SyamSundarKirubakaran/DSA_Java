package problems.hashing;

import java.util.HashSet;

/**
 * @author SYAM K
 * @problem : Given an array and a range (low, high). Find the elements that are in the range but not in the array.
 */
public class E {

    private static final int[] arr = new int[]{1, 3, 5, 4};

    public static void main(String[] args) {
        

        printMissing(arr, 0, 10);

        
    }

    private static void printMissing(int[] arr, int low, int high) {
        HashSet<Integer> hs = new HashSet<>();
        for (int value : arr) hs.add(value);
        for (int i = low; i <= high; i++) {
            if (!hs.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
