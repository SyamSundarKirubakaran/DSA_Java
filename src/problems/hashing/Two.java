package problems.hashing;

import java.util.HashSet;

/**
 * @author SYAM K
 * @problem : check if 2 sets are disjoint or not
 */
public class Two {

    private static final int[] arr1 = new int[]{10, 5, 3, 4, 6};
    private static final int[] arr2 = new int[]{8, 7, 9, 3};

    public static void main(String[] args) {
        

        System.out.println(areDisjoint(arr1, arr2));

        
    }

    private static boolean areDisjoint(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : arr1) {
            hashSet.add(value);
        }

        for (int value : arr2) {
            if (hashSet.contains(value)) {
                return false;
            }
        }
        return true;
    }

}
