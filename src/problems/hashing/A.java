package problems.hashing;

import java.util.HashSet;

/**
 * @author SYAM K
 * @problem : check if the array has duplicate entries at K distance or not
 */
public class A {

    private static final int[] arr = new int[]{10, 5, 3, 4, 3, 1, 6};

    public static void main(String[] args) {
        

        System.out.println(check(arr, arr.length, 3));

        
    }

    private static boolean check(int[] arr, int length, int k) {
        HashSet<Integer> set = new HashSet<>();
        k -= 1; // window size is 3 0..2, not 0..3
        for (int i = 0; i < length; i++) {
            if (set.contains(arr[i]))
                return true;
            set.add(arr[i]);
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        return false;
    }

}
